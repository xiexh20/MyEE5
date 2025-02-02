/*
 * This file is generated by jOOQ.
 */
package dbconn;


import dbconn.tables.Carstatusdata;
import dbconn.tables.Cartelemetry;
import dbconn.tables.Drivers;
import dbconn.tables.Extractedlapdata;
import dbconn.tables.Heatmapdata;
import dbconn.tables.Instantlapdata;
import dbconn.tables.Motiondata;
import dbconn.tables.Nationalities;
import dbconn.tables.Players;
import dbconn.tables.Sessioninfos;
import dbconn.tables.Teams;
import dbconn.tables.Tracks;


/**
 * Convenience access to all tables in F1GameDB
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * Necessary informaiton from CarStatus packet. Not needed to update quickly, 1Hz should be good enough. 
     */
    public static final Carstatusdata CARSTATUSDATA = Carstatusdata.CARSTATUSDATA;

    /**
     * From packet telmetry, should be updated as fast as possible
     */
    public static final Cartelemetry CARTELEMETRY = Cartelemetry.CARTELEMETRY;

    /**
     * Store names of all drivers specified by F1 2018.
     */
    public static final Drivers DRIVERS = Drivers.DRIVERS;

    /**
     * Lap data not updated frequently, i.e. extracted from several packets. 
     */
    public static final Extractedlapdata EXTRACTEDLAPDATA = Extractedlapdata.EXTRACTEDLAPDATA;

    /**
     * Data needed to generate a heat map of the car. Update ratio 1Hz is good enough. 
     */
    public static final Heatmapdata HEATMAPDATA = Heatmapdata.HEATMAPDATA;

    /**
     *  Lap Data that should be saved instantaneously. 
     */
    public static final Instantlapdata INSTANTLAPDATA = Instantlapdata.INSTANTLAPDATA;

    /**
     * This table includes necessary entries in Motion packet and some entries from other packet that requires instataneous update. The frequency should be as fast as possible. 
     */
    public static final Motiondata MOTIONDATA = Motiondata.MOTIONDATA;

    /**
     * Information of natinalities specified by F1 2018.
     */
    public static final Nationalities NATIONALITIES = Nationalities.NATIONALITIES;

    /**
     * Store information of players, specified by user. 
     */
    public static final Players PLAYERS = Players.PLAYERS;

    /**
     * General information for this session
     */
    public static final Sessioninfos SESSIONINFOS = Sessioninfos.SESSIONINFOS;

    /**
     * Store information of all teams specified by F1 2018.
     */
    public static final Teams TEAMS = Teams.TEAMS;

    /**
     * Tracks information specified by F1 2018.
     */
    public static final Tracks TRACKS = Tracks.TRACKS;
}
