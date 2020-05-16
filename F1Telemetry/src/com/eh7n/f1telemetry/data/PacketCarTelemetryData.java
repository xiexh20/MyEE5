package com.eh7n.f1telemetry.data;

import java.util.List;

import com.eh7n.f1telemetry.data.elements.ButtonStatus;
import com.eh7n.f1telemetry.data.elements.CarTelemetryData;
import com.eh7n.f1telemetry.data.elements.TableDataType;
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
        proc.setDtype(TableDataType.INT8);
        StringBuilder dataList = new StringBuilder();
        StringBuilder nameList = new StringBuilder();
        
        nameList.append("brake").append(DBConst.COMMA);
        dataList.append(tData.getBrake()).append(DBConst.COMMA);
        nameList.append("drs").append(DBConst.COMMA);
        dataList.append(tData.isDrs()? 1:0).append(DBConst.COMMA);
        nameList.append("steer").append(DBConst.COMMA);
        dataList.append(tData.getSteer()).append(DBConst.COMMA);
        nameList.append("throttle");
        dataList.append(tData.getThrottle());
        
        proc.setDatalist(dataList.toString());
        proc.setNamelist(nameList.toString());
        proc.setArrivetime(LocalDateTime.now());
        proc.setSessionuid(getHeader().getSessionUID().longValue());
        proc.setSessiontime((double)getHeader().getSessionTime());
        proc.execute(db.configuration());
        
        proc.setDtype(DBConst.INT16);
        proc.setDatalist(tData.getSpeed()+"");
        proc.setNamelist("speed");
        proc.execute(db.configuration());
        
        
        return histPacketLists;
    }

}
