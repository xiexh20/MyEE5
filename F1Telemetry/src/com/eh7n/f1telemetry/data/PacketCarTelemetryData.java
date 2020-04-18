package com.eh7n.f1telemetry.data;

import java.util.List;

import com.eh7n.f1telemetry.data.elements.ButtonStatus;
import com.eh7n.f1telemetry.data.elements.CarTelemetryData;
import org.jooq.DSLContext;

public class PacketCarTelemetryData extends Packet {

    private List<CarTelemetryData> carTelemetryData;
    private ButtonStatus buttonStatus; // TODO, create a representation of this data properly

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
    public PacketList[] saveToDB(PacketList[] histPacketLists, DSLContext dbContext) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        System.out.println("Not implemented yet for PacketLapData.");
        return histPacketLists;
    }

}
