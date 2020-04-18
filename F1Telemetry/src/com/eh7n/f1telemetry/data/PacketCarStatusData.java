package com.eh7n.f1telemetry.data;

import java.util.List;

import com.eh7n.f1telemetry.data.elements.CarStatusData;
import org.jooq.DSLContext;

public class PacketCarStatusData extends Packet {

    private List<CarStatusData> carStatuses;

    public PacketCarStatusData() {
    }

    public List<CarStatusData> getCarStatuses() {
        return carStatuses;
    }

    public void setCarStatuses(List<CarStatusData> carStatuses) {
        this.carStatuses = carStatuses;
    }

    @Override
    public PacketList[] saveToDB(PacketList[] histPacketLists, DSLContext dbContext) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        System.out.println("Not implemented yet for CarStatusData.");
        return histPacketLists;
    }

}
