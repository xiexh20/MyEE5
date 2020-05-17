package com.eh7n.f1telemetry.data;

import java.util.List;

import com.eh7n.f1telemetry.data.elements.CarSetupData;
import java.util.HashMap;
import ndbconn.tables.records.DatanamesRecord;
import org.jooq.DSLContext;
import org.jooq.Result;

/**
 * 
 * @author Eric, source: https://github.com/eh7n/f1-2018_telemetry.git
 * adapted by Xianghui Xie, May, 2020.
 */
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
    /**
     * currently no parameter in this packet is saved in database
     */
    public PacketList[] saveToDB(PacketList[] histPacketLists, DSLContext db) {
        return histPacketLists;
    }

}
