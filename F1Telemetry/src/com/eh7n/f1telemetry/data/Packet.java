package com.eh7n.f1telemetry.data;

import com.eh7n.f1telemetry.data.elements.Header;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import ndbconn.tables.records.DatanamesRecord;
import org.jooq.DSLContext;
import org.jooq.Result;

public abstract class Packet {

    private Header header;
    private LocalDateTime timestamp;

    public void setTimestamp(LocalDateTime time) {
        timestamp = time;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public String toJSON() {
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(this);
        } catch (Exception e) {
            //TODO: Handle this exception
        }
        return json;
    }

    /**
     * analyze packet, extract useful information and save to database, must be
     * override by subclasses
     *
     * @param histPacketLists
     * @param dbContext
     * @param dNameList: the data name list, include id and name from database
     * @return
     */
    public abstract PacketList[] saveToDB(PacketList[] histPacketLists, DSLContext db);
    
    

    /**
     * save this packet to different list based on packet type, data table is linked with Packets, Names and Sessions table, 
     * to keep reference integrity, the following steps show be followed
     * 1. Get the session id in table Sessions
     * 2. Get the packet id in table Packets
     * 3. Get the name if from the name HashMap
     * 4. Insert data into the db
     * @param histPacketLists
     * @return
     */
    public PacketList[] addToHistLists(PacketList[] histPacketLists) {
        int packetId = header.getPacketId();
        histPacketLists[packetId].add(this);
        return histPacketLists;
    }
    
    /**
     * get the session id in database for this session UID
     * step 1: query the database to see if 
     * @param dbconn: the database connection context
     * @return the id of the session UID in table Sessions
     */
    public int getSessionID(DSLContext dbconn)
    {
        
        return -1;
        
    }
    
    /**
     * get the packet id in table Packets
     * @param dbconn
     * @return 
     */
    public int getPacketID(DSLContext dbconn)
    {
        return -1;
    }
            

}
