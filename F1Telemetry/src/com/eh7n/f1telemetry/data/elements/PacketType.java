/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eh7n.f1telemetry.data.elements;

/**
 *
 * @author 25691
 */
public enum PacketType {
    
    MOTION,
    SESSION,
    LAPDATA,
    EVENT,
    PARTICIPANT,
    CARSETUP,
    CARTELEMETRY,
    CARSTATUS,
    UNKNOWN;
    
    public static PacketType fromID(int id){
        switch(id){
            case 0: 
                return PacketType.MOTION;
            case 1:
                return PacketType.SESSION;
            case 2: 
                return PacketType.LAPDATA;
            case 3: 
                return PacketType.EVENT;
            case 4:
                return PacketType.PARTICIPANT;
            case 5:
                return PacketType.CARSETUP;
            case 6:
                return PacketType.CARTELEMETRY;
            case 7:
                return PacketType.CARSTATUS;
            default :
                return PacketType.UNKNOWN;
        }
                
    }
    
}
