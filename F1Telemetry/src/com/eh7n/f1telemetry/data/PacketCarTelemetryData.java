package com.eh7n.f1telemetry.data;

import java.util.List;

import com.eh7n.f1telemetry.data.elements.ButtonStatus;
import com.eh7n.f1telemetry.data.elements.CarTelemetryData;
import dbconn.Tables;
import dbconn.tables.Cartelemetry;
import dbconn.tables.Heatmapdata;
import org.jooq.DSLContext;

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
    public PacketList[] saveToDB(PacketList[] histPacketLists, DSLContext dbContext) {

        PacketList[] newLists = addToHistLists(histPacketLists);        // add to history buffer
        Cartelemetry CT = Tables.CARTELEMETRY;
        CarTelemetryData tData = carTelemetryData.get(getHeader().getPlayerCarIndex());
        byte drs = 0;
        if (tData.isDrs()) {
            drs = 1;
        }

        dbContext.insertInto(CT, CT.SESSIONID, CT.SESSIONTIME, CT.SPEED,
                CT.THROTTLE, CT.STEER, CT.BRAKE, CT.GEAR, CT.DRS)
                .values(getHeader().getSessionUID().longValue(),
                        (double) getHeader().getSessionTime(),
                        tData.getSpeed(),
                        (short) tData.getThrottle(),
                        (short) tData.getSteer(),
                        (short) tData.getBrake(),
                        (byte) tData.getGear(),
                        drs)
                .execute();

        int histPacketsCount = newLists[getHeader().getPacketId()].size();
        if (histPacketsCount == UPDATEPERIOD) {
            // get the last element(curret packet) and save to database
            Heatmapdata HT = Tables.HEATMAPDATA;
            dbContext.insertInto(HT, HT.SESSIONID, HT.SESSIONTIME, HT.ENGINE,
                    HT.BRAKERL, HT.BRAKERR, HT.BRAKEFL, HT.BRAKEFR,
                    HT.TYRERLSURFACE, HT.TYRERRSURFACE, HT.TYREFLSURFACE, HT.TYREFRSURFACE,
                    HT.TYRERLINNER, HT.TYRERRINNER, HT.TYREFLINNER, HT.TYREFRINNER)
                    .values(getHeader().getSessionUID().longValue(),
                            (double) getHeader().getSessionTime(),
                            tData.getEngineTemperature(),
                            tData.getBrakeTemperature().getRearLeft(),
                            tData.getBrakeTemperature().getRearRight(),
                            tData.getBrakeTemperature().getFrontLeft(),
                            tData.getBrakeTemperature().getFrontRight(),
                            tData.getTireSurfaceTemperature().getRearLeft(),
                            tData.getTireSurfaceTemperature().getRearRight(),
                            tData.getTireSurfaceTemperature().getFrontLeft(),
                            tData.getTireSurfaceTemperature().getFrontRight(),
                            tData.getTireInnerTemperature().getRearLeft(),
                            tData.getTireInnerTemperature().getRearRight(),
                            tData.getTireInnerTemperature().getFrontLeft(),
                            tData.getTireInnerTemperature().getFrontRight())
                    .execute();
            // empty the lap list buffer
            newLists[getHeader().getPacketId()].clear();
        }

        return histPacketLists;
    }

}
