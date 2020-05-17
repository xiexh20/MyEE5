package com.eh7n.f1telemetry.data;

import java.util.List;

import com.eh7n.f1telemetry.data.elements.LapData;
import dbconn.Tables;
import dbconn.tables.Extractedlapdata;
import dbconn.tables.Instantlapdata;
import java.time.LocalDateTime;
import java.util.HashMap;
import ndbconn.DBConst;
import ndbconn.routines.Savelist;
import ndbconn.tables.records.DatanamesRecord;
import org.jooq.DSLContext;
import org.jooq.DataType;
import org.jooq.Result;
/**
 * 
 * @author Eric, source: https://github.com/eh7n/f1-2018_telemetry.git
 * adapted by Xianghui Xie, May, 2020.
 */
public class PacketLapData extends Packet {

    private static final int UPDATEPERIOD = 10;
    private List<LapData> lapDataList;

    public PacketLapData() {
    }

    public List<LapData> getLapDataList() {
        return lapDataList;
    }

    public void setLapDataList(List<LapData> lapDataList) {
        this.lapDataList = lapDataList;
    }

    @Override
    /**
     * part instantaneous part delayed data
     */
    public PacketList[] saveToDB(PacketList[] histPacketLists, DSLContext db) {
        
        // get the data for the player car
        LapData lapData = lapDataList.get(getHeader().getPlayerCarIndex());
        
        Savelist proc = new Savelist();
        proc.setDtype(DBConst.FLOAT);
        StringBuilder dataList = new StringBuilder();
        StringBuilder nameList = new StringBuilder();
        
        nameList.append("lapDistance").append(DBConst.COMMA);
        dataList.append(lapData.getLapDistance()).append(DBConst.COMMA);
        nameList.append("totalDistance").append(DBConst.COMMA);
        dataList.append(lapData.getTotalDistance()).append(DBConst.COMMA);
        nameList.append("currentLapTime");
        dataList.append(lapData.getCurrentLapTime());

        proc.setDatalist(dataList.toString());
        proc.setNamelist(nameList.toString());
        proc.setArrivetime(LocalDateTime.now());
        proc.setSessionuid(getHeader().getSessionUID().longValue());
        proc.setSessiontime((double)getHeader().getSessionTime());
        proc.execute(db.configuration());

        PacketList[] newLists = addToHistLists(histPacketLists);        // add to history buffer

        int histPacketsCount = newLists[getHeader().getPacketId()].size();
        if (histPacketsCount == UPDATEPERIOD) {
            // get the last element(curret packet) and save to database
            
            // save float data list
            proc.setDtype(DBConst.FLOAT);
            nameList = new StringBuilder();
            dataList = new StringBuilder();
            
            nameList.append("bestLapTime").append(",");
            dataList.append(lapData.getBestLaptTime()).append(",");
            nameList.append("lastLapTime");
            dataList.append(lapData.getLastLapTime());
            proc.setDatalist(dataList.toString());
            proc.setNamelist(nameList.toString());
            proc.execute(db.configuration());
            
            // save int8 data
            proc.setDtype(DBConst.UINT8);
            proc.setNamelist("currentLapNum"+DBConst.COMMA+"penalties");
            proc.setDatalist(lapData.getCurrentLapNum()+DBConst.COMMA+lapData.getPenalties());
            proc.execute(db.configuration());
            
            // empty the lap list buffer
            newLists[getHeader().getPacketId()].clear();
        }
        return newLists;
    }
   

}
