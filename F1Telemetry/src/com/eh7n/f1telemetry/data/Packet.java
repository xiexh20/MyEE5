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
    public abstract PacketList[] saveToDB(PacketList[] histPacketLists, DSLContext dbContext, HashMap<String, Short> nameIdMap);
    
    

    /**
     * save this packet to different list based on packet type
     *
     * @param histPacketLists
     * @return
     */
    public PacketList[] addToHistLists(PacketList[] histPacketLists) {
        int packetId = header.getPacketId();
        histPacketLists[packetId].add(this);
        return histPacketLists;
    }

}
