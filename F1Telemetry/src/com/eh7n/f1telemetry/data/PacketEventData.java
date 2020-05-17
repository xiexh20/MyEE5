package com.eh7n.f1telemetry.data;

import dbconn.Tables;
import dbconn.tables.Sessioninfos;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.HashMap;
import ndbconn.tables.records.DatanamesRecord;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

/**
 * 
 * @author Eric, source: https://github.com/eh7n/f1-2018_telemetry.git
 * adapted by Xianghui Xie, May, 2020.
 */

public class PacketEventData extends Packet {

    private String eventCode;
    

    public PacketEventData() {
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }
    
    

    @Override
    /**
     * currently no data in this packet is saved in database
     */
    public PacketList[] saveToDB(PacketList[] histPacketLists, DSLContext db) {
        return histPacketLists;
    }
}
