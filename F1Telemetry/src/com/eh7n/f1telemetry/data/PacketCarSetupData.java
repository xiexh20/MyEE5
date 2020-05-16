package com.eh7n.f1telemetry.data;

import java.util.List;

import com.eh7n.f1telemetry.data.elements.CarSetupData;
import java.util.HashMap;
import ndbconn.tables.records.DatanamesRecord;
import org.jooq.DSLContext;
import org.jooq.Result;

public class PacketCarSetupData extends Packet {

    private List<CarSetupData> carSetups;

    public PacketCarSetupData() {
    }

    public List<CarSetupData> getCarSetups() {
        return carSetups;
    }

    public void setCarSetups(List<CarSetupData> carSetups) {
        this.carSetups = carSetups;
    }

    @Override
    public PacketList[] saveToDB(PacketList[] histPacketLists, DSLContext db) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        System.out.println("Not implemented yet for CarSetupData.");
        return histPacketLists;
    }

}
