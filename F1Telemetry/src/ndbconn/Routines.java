/*
 * This file is generated by jOOQ.
 */
package ndbconn;


import java.time.LocalDateTime;

import ndbconn.routines.Savefloat;
import ndbconn.routines.Savefloatlist;
import ndbconn.routines.Saveint16;
import ndbconn.routines.Saveint32;
import ndbconn.routines.Saveint8;
import ndbconn.routines.Saveint8list;
import ndbconn.routines.Savelist;

import org.jooq.Configuration;


/**
 * Convenience access to all stored procedures and functions in NewF1DB
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Routines {

    /**
     * Call <code>NewF1DB.saveFloat</code>
     */
    public static void savefloat(Configuration configuration, Double datain, String dname, Long sessionuid, Double sessiontime, LocalDateTime arrivetime) {
        Savefloat p = new Savefloat();
        p.setDatain(datain);
        p.setDname(dname);
        p.setSessionuid(sessionuid);
        p.setSessiontime(sessiontime);
        p.setArrivetime(arrivetime);

        p.execute(configuration);
    }

    /**
     * Call <code>NewF1DB.saveFloatList</code>
     */
    public static void savefloatlist(Configuration configuration, String datalist, String namelist, Long sessionuid, Double sessiontime, LocalDateTime arrivetime) {
        Savefloatlist p = new Savefloatlist();
        p.setDatalist(datalist);
        p.setNamelist(namelist);
        p.setSessionuid(sessionuid);
        p.setSessiontime(sessiontime);
        p.setArrivetime(arrivetime);

        p.execute(configuration);
    }

    /**
     * Call <code>NewF1DB.saveInt16</code>
     */
    public static void saveint16(Configuration configuration, Short datain, String dname, Long sessionuid, Double sessiontime, LocalDateTime arrivetime) {
        Saveint16 p = new Saveint16();
        p.setDatain(datain);
        p.setDname(dname);
        p.setSessionuid(sessionuid);
        p.setSessiontime(sessiontime);
        p.setArrivetime(arrivetime);

        p.execute(configuration);
    }

    /**
     * Call <code>NewF1DB.saveInt32</code>
     */
    public static void saveint32(Configuration configuration, Integer datain, String dname, Long sessionuid, Double sessiontime, LocalDateTime arrivetime) {
        Saveint32 p = new Saveint32();
        p.setDatain(datain);
        p.setDname(dname);
        p.setSessionuid(sessionuid);
        p.setSessiontime(sessiontime);
        p.setArrivetime(arrivetime);

        p.execute(configuration);
    }

    /**
     * Call <code>NewF1DB.saveInt8</code>
     */
    public static void saveint8(Configuration configuration, Byte datain, String dname, Long sessionuid, Double sessiontime, LocalDateTime arrivetime) {
        Saveint8 p = new Saveint8();
        p.setDatain(datain);
        p.setDname(dname);
        p.setSessionuid(sessionuid);
        p.setSessiontime(sessiontime);
        p.setArrivetime(arrivetime);

        p.execute(configuration);
    }

    /**
     * Call <code>NewF1DB.saveInt8List</code>
     */
    public static void saveint8list(Configuration configuration, String datalist, String namelist, Long sessionuid, Double sessiontime, LocalDateTime arrivetime) {
        Saveint8list p = new Saveint8list();
        p.setDatalist(datalist);
        p.setNamelist(namelist);
        p.setSessionuid(sessionuid);
        p.setSessiontime(sessiontime);
        p.setArrivetime(arrivetime);

        p.execute(configuration);
    }

    /**
     * Call <code>NewF1DB.saveList</code>
     */
    public static void savelist(Configuration configuration, String datalist, String namelist, Long sessionuid, Double sessiontime, LocalDateTime arrivetime, Byte dtype) {
        Savelist p = new Savelist();
        p.setDatalist(datalist);
        p.setNamelist(namelist);
        p.setSessionuid(sessionuid);
        p.setSessiontime(sessiontime);
        p.setArrivetime(arrivetime);
        p.setDtype(dtype);

        p.execute(configuration);
    }
}
