package com.eh7n.f1telemetry.data;

import java.util.List;

import com.eh7n.f1telemetry.data.elements.LapData;
import org.jooq.DSLContext;

public class PacketLapData extends Packet {
	
	private List<LapData> lapDataList;
	
	public PacketLapData() {}
	
	public List<LapData> getLapDataList() {
		return lapDataList;
	}
	
	public void setLapDataList(List<LapData> lapDataList) {
		this.lapDataList = lapDataList;
	}

    @Override
    public PacketList[] saveToDB(PacketList[] histPacketLists, DSLContext dbContext) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        System.out.println("Not implemented yet for PacketLapData.");
        return histPacketLists;
    }

}
