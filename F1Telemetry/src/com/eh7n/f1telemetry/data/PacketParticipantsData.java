package com.eh7n.f1telemetry.data;

import java.util.List;

import com.eh7n.f1telemetry.data.elements.ParticipantData;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import ndbconn.tables.records.DatanamesRecord;
import org.jooq.DSLContext;
import org.jooq.Result;

/**
 * 
 * @author Eric, source: https://github.com/eh7n/f1-2018_telemetry.git
 * adapted by Xianghui Xie, May, 2020.
 */

public class PacketParticipantsData extends Packet {
	
	private int numCars;
	private List<ParticipantData> participants;
	
	public PacketParticipantsData() {}
	
	public int getNumCars() {
		return numCars;
	}
	public void setNumCars(int numCars) {
		this.numCars = numCars;
	}
	public List<ParticipantData> getParticipants() {
		return participants;
	}
	public void setParticipants(List<ParticipantData> participants) {
		this.participants = participants;
	}
        
        @Override
        public String toJSON() {
            ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(this);
                        System.out.println("xiexh for debug:");
                        for(int i = 0;i<numCars;i++){
                            System.out.println(participants.get(i).toString());
                        }
                    
               
               
                        
		}catch(Exception e) {
			//TODO: Handle this exception
		}
		return json;
        }

    @Override
    /**
     * currently no data in this packet is stored in database
     */
    public PacketList[] saveToDB(PacketList[] histPacketLists, DSLContext db) {
        return histPacketLists;
    }
        
}
