package com.eh7n.f1telemetry.data;

import java.util.List;

import com.eh7n.f1telemetry.data.elements.ParticipantData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jooq.DSLContext;

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
    public PacketList[] saveToDB(PacketList[] histPacketLists, DSLContext dbContext) {
//        throw new UnsupportedperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        System.out.println("No operation for participant packet!");
        return histPacketLists;
    }
        
}
