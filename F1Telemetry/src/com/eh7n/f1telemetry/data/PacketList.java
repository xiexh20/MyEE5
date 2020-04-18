/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eh7n.f1telemetry.data;

import java.util.ArrayList;

/**
 * this class stores a list of packet
 * @author 25691
 */
public class PacketList extends ArrayList {
    private ArrayList<Packet> packetList;
    
    public PacketList()
    {
        packetList = new ArrayList<Packet>();
    }
    
    public ArrayList<Packet> getPackets()
    {
        return packetList;
    }
    
}
