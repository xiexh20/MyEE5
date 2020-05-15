package com.eh7n.f1telemetry.data;

import java.util.List;

import com.eh7n.f1telemetry.data.elements.LapData;
import dbconn.Tables;
import dbconn.tables.Extractedlapdata;
import dbconn.tables.Instantlapdata;
import ndbconn.tables.records.DatanamesRecord;
import org.jooq.DSLContext;
import org.jooq.Result;

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
    public PacketList[] saveToDB(PacketList[] histPacketLists, DSLContext dbContext, Result<DatanamesRecord> dNameList) {

        // save instant data into database
        Instantlapdata IT = Tables.INSTANTLAPDATA;   // abreviate for Table InstantLapData
        LapData lapData = lapDataList.get(getHeader().getPlayerCarIndex());
        dbContext.insertInto(IT, IT.SESSIONID, IT.SESSIONTIME, IT.CURRENTLAPTIME, IT.TOTALDISTANCE, IT.LAPDISTANCE)
                .values(getHeader().getSessionUID().longValue(),
                        (double) getHeader().getSessionTime(),
                        (double) lapData.getCurrentLapTime(),
                        (double) lapData.getTotalDistance(),
                        (double) lapData.getLapDistance())
                .execute();
        PacketList[] newLists = addToHistLists(histPacketLists);        // add to history buffer
        
        int histPacketsCount = newLists[getHeader().getPacketId()].size();
        if (histPacketsCount == UPDATEPERIOD) {
            // get the last element(curret packet) and save to database
            Extractedlapdata ET = Tables.EXTRACTEDLAPDATA;
            dbContext.insertInto(ET, ET.SESSIONID, ET.SESSIONTIME, ET.LASTLAPTIME, ET.BESTLAPTIME,
                    ET.PENALTIES, ET.SAFETYCARDELTA, ET.CURRENTLAPNUM, ET.CARPOSITION)
                    .values(getHeader().getSessionUID().longValue(),
                            (double) getHeader().getSessionTime(),
                            (double) lapData.getLastLapTime(),
                            (double) lapData.getBestLaptTime(),
                            (short) lapData.getPenalties(),
                            (short) lapData.getSafetyCarDelta(),
                            (byte) lapData.getCurrentLapNum(),
                            (byte) lapData.getCarPosition())
                    .execute();
            // empty the lap list buffer
            newLists[getHeader().getPacketId()].clear();
        }
        return newLists;
    }

}
