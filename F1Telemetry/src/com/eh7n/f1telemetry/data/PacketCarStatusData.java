package com.eh7n.f1telemetry.data;

import java.util.List;

import com.eh7n.f1telemetry.data.elements.CarStatusData;
import dbconn.Tables;
import dbconn.tables.Carstatusdata;
import java.util.HashMap;
import ndbconn.tables.records.DatanamesRecord;
import org.jooq.DSLContext;
import org.jooq.Result;

/**
 * 
 * @author Eric, source: https://github.com/eh7n/f1-2018_telemetry.git
 * adapted by Xianghui Xie, May, 2020.
 */

public class PacketCarStatusData extends Packet {

    private List<CarStatusData> carStatuses;

    private static final int UPDATEPERIOD = 10;

    public PacketCarStatusData() {
    }

    public List<CarStatusData> getCarStatuses() {
        return carStatuses;
    }

    public void setCarStatuses(List<CarStatusData> carStatuses) {
        this.carStatuses = carStatuses;
    }

    @Override
    /**
     * currently no data in this packet is saved to the database
     */
    public PacketList[] saveToDB(PacketList[] histPacketLists, DSLContext db) {

        return histPacketLists;
                
    }

}
