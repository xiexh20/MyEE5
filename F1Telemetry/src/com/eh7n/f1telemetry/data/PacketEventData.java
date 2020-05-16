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

public class PacketEventData extends Packet {

//    private static final int packetID = 3;  // the packet id for event packet
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
     * first extract data, and then save to history if session start: add an
     * entry to table SessionInfos set the endTime when an end event received
     */
    public PacketList[] saveToDB(PacketList[] histPacketLists, DSLContext db) {
        return histPacketLists;
    }
    
        // bug: if you restart the session the session UID will not change. 
        //UID for start event is the UID of previous session, 0 means no previous session. 
        //The SEND packet UID is the real UID for this session. 

//        LocalDateTime dateTime = LocalDateTime.now();
//        setTimestamp(dateTime);
////        System.out.println("Time:" + dateTime + toJSON());
//        
//        Sessioninfos si = Tables.SESSIONINFOS;
//        // check if the UID exist
//        Result<Record> result = db.select()
//                .from(Tables.SESSIONINFOS)
//                .where(Tables.SESSIONINFOS.SESSIONUID.eq(getHeader().getSessionUID().longValue()))
//                .fetch();
//        if (eventCode.equals("SSTA")) {
////            if (result.size() > 0) {
////                // this is a restarted seesion
////                dbContext.update(Tables.SESSIONINFOS)
////                        .set(Tables.SESSIONINFOS.STARTTIME, dateTime)
////                        .where(Tables.SESSIONINFOS.SESSIONUID.eq(getHeader().getSessionUID().longValue()))
////                        .execute();
////            } else {
////                // new session start: insert an entry in table SessionInfos
////                dbContext.insertInto(Tables.SESSIONINFOS, Tables.SESSIONINFOS.SESSIONUID, Tables.SESSIONINFOS.STARTTIME)
////                        .values(getHeader().getSessionUID().longValue(), dateTime)
////                        .execute();
////
////            }
//
//            // add to history list
//            PacketList newList[] = addToHistLists(histPacketLists);
////            System.out.println("New list size:" + newList[getHeader().getPacketId()].getPackets().size());
//            return newList;
//        } else {
//            // session end: try to update an entry in table SessionInfos
//            // get the start time
//            LocalDateTime startTime = null;
//            if(histPacketLists[getHeader().getPacketId()].getPackets().size()>0){
//                startTime = histPacketLists[getHeader().getPacketId()].getPackets().get(0).getTimestamp();
//            }
//                    
//            if (result.size() > 0) {
//                // this session exist
//                db.update(Tables.SESSIONINFOS)
//                        .set(Tables.SESSIONINFOS.STARTTIME, startTime)
//                        .set(Tables.SESSIONINFOS.ENDTIME, dateTime)
//                        .where(Tables.SESSIONINFOS.SESSIONUID.eq(getHeader().getSessionUID().longValue()))
//                        .execute();
//            } else {
//                // this session does not exist
//                db.insertInto(Tables.SESSIONINFOS, Tables.SESSIONINFOS.SESSIONUID, Tables.SESSIONINFOS.ENDTIME, si.STARTTIME)
//                        .values(getHeader().getSessionUID().longValue(), dateTime, startTime)
//                        .execute();
//            }
//
//            // empty the history list for event packet
//            histPacketLists[getHeader().getPacketId()].getPackets().clear();
//            return histPacketLists;
//        }
//    }

    
}
