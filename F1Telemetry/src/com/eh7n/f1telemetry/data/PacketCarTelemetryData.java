package com.eh7n.f1telemetry.data;

import java.util.List;

import com.eh7n.f1telemetry.data.elements.ButtonStatus;
import com.eh7n.f1telemetry.data.elements.CarTelemetryData;
import dbconn.Tables;
import dbconn.tables.Cartelemetry;
import dbconn.tables.Heatmapdata;
import java.time.LocalDateTime;
import java.util.HashMap;
import ndbconn.DBConst;
import ndbconn.routines.Savelist;
import ndbconn.tables.Int16data;
import ndbconn.tables.Int8data;
import ndbconn.tables.records.DatanamesRecord;
import org.jooq.DSLContext;
import org.jooq.Result;

/**
 * 
 * @author Eric, source: https://github.com/eh7n/f1-2018_telemetry.git
 * adapted by Xianghui Xie, May, 2020.
 */

public class PacketCarTelemetryData extends Packet {

    private List<CarTelemetryData> carTelemetryData;
    private ButtonStatus buttonStatus; // TODO, create a representation of this data properly
    private static final int UPDATEPERIOD = 10;

    public PacketCarTelemetryData() {
    }

    public List<CarTelemetryData> getCarTelemetryData() {
        return carTelemetryData;
    }

    public void setCarTelemetryData(List<CarTelemetryData> carTelemetryData) {
        this.carTelemetryData = carTelemetryData;
    }

    public ButtonStatus getButtonStatus() {
        return buttonStatus;
    }

    public void setButtonStatus(ButtonStatus buttonStatus) {
        this.buttonStatus = buttonStatus;
    }

    @Override
    /**
     * part instant part delayed
     */
    public PacketList[] saveToDB(PacketList[] histPacketLists, DSLContext db) {

        CarTelemetryData tData = carTelemetryData.get(getHeader().getPlayerCarIndex());
        Savelist proc = new Savelist();
        
        // save int8 data
        proc.setDtype(DBConst.INT8);
        proc.setNamelist("gear"+DBConst.COMMA+"steer");
        proc.setDatalist(tData.getGear()+DBConst.COMMA+tData.getSteer());
        proc.setArrivetime(LocalDateTime.now());
        proc.setSessionuid(getHeader().getSessionUID().longValue());
        proc.setSessiontime((double)getHeader().getSessionTime());
        proc.execute(db.configuration());
        
        // save uint8 data
        StringBuilder dataList = new StringBuilder();
        StringBuilder nameList = new StringBuilder();
        proc.setDtype(DBConst.UINT8);
        nameList.append("brake").append(DBConst.COMMA);
        dataList.append(tData.getBrake()).append(DBConst.COMMA);
        nameList.append("drs").append(DBConst.COMMA);
        dataList.append(tData.isDrs()? 1:0).append(DBConst.COMMA);
        nameList.append("throttle");
        dataList.append(tData.getThrottle());
        proc.setDatalist(dataList.toString());
        proc.setNamelist(nameList.toString());
        proc.execute(db.configuration());
        
        // save uint16 data
        proc.setDtype(DBConst.UINT16);
        proc.setDatalist(tData.getSpeed()+DBConst.COMMA+tData.getEngineRpm()+DBConst.COMMA+tData.getEngineTemperature());
        proc.setNamelist("speed"+DBConst.COMMA+"engineRPM"+DBConst.COMMA+"engineTemperature");
        proc.execute(db.configuration());
        
        return histPacketLists;
    }

}
