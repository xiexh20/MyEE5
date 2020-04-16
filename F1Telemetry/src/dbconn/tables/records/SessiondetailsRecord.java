/*
 * This file is generated by jOOQ.
 */
package dbconn.tables.records;


import dbconn.tables.Sessiondetails;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * Detailed informations about the track settings. 
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SessiondetailsRecord extends UpdatableRecordImpl<SessiondetailsRecord> implements Record6<Integer, Byte, Short, Integer, Integer, Byte> {

    private static final long serialVersionUID = -2020936828;

    /**
     * Setter for <code>F1GameDB.SessionDetails.sessionId</code>.
     */
    public void setSessionid(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>F1GameDB.SessionDetails.sessionId</code>.
     */
    public Integer getSessionid() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>F1GameDB.SessionDetails.laps</code>.
     */
    public void setLaps(Byte value) {
        set(1, value);
    }

    /**
     * Getter for <code>F1GameDB.SessionDetails.laps</code>.
     */
    public Byte getLaps() {
        return (Byte) get(1);
    }

    /**
     * Setter for <code>F1GameDB.SessionDetails.trackId</code>.
     */
    public void setTrackid(Short value) {
        set(2, value);
    }

    /**
     * Getter for <code>F1GameDB.SessionDetails.trackId</code>.
     */
    public Short getTrackid() {
        return (Short) get(2);
    }

    /**
     * Setter for <code>F1GameDB.SessionDetails.trackLength</code>.
     */
    public void setTracklength(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>F1GameDB.SessionDetails.trackLength</code>.
     */
    public Integer getTracklength() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>F1GameDB.SessionDetails.sessionDuration</code>.
     */
    public void setSessionduration(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>F1GameDB.SessionDetails.sessionDuration</code>.
     */
    public Integer getSessionduration() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>F1GameDB.SessionDetails.era</code>.
     */
    public void setEra(Byte value) {
        set(5, value);
    }

    /**
     * Getter for <code>F1GameDB.SessionDetails.era</code>.
     */
    public Byte getEra() {
        return (Byte) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, Byte, Short, Integer, Integer, Byte> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Integer, Byte, Short, Integer, Integer, Byte> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Sessiondetails.SESSIONDETAILS.SESSIONID;
    }

    @Override
    public Field<Byte> field2() {
        return Sessiondetails.SESSIONDETAILS.LAPS;
    }

    @Override
    public Field<Short> field3() {
        return Sessiondetails.SESSIONDETAILS.TRACKID;
    }

    @Override
    public Field<Integer> field4() {
        return Sessiondetails.SESSIONDETAILS.TRACKLENGTH;
    }

    @Override
    public Field<Integer> field5() {
        return Sessiondetails.SESSIONDETAILS.SESSIONDURATION;
    }

    @Override
    public Field<Byte> field6() {
        return Sessiondetails.SESSIONDETAILS.ERA;
    }

    @Override
    public Integer component1() {
        return getSessionid();
    }

    @Override
    public Byte component2() {
        return getLaps();
    }

    @Override
    public Short component3() {
        return getTrackid();
    }

    @Override
    public Integer component4() {
        return getTracklength();
    }

    @Override
    public Integer component5() {
        return getSessionduration();
    }

    @Override
    public Byte component6() {
        return getEra();
    }

    @Override
    public Integer value1() {
        return getSessionid();
    }

    @Override
    public Byte value2() {
        return getLaps();
    }

    @Override
    public Short value3() {
        return getTrackid();
    }

    @Override
    public Integer value4() {
        return getTracklength();
    }

    @Override
    public Integer value5() {
        return getSessionduration();
    }

    @Override
    public Byte value6() {
        return getEra();
    }

    @Override
    public SessiondetailsRecord value1(Integer value) {
        setSessionid(value);
        return this;
    }

    @Override
    public SessiondetailsRecord value2(Byte value) {
        setLaps(value);
        return this;
    }

    @Override
    public SessiondetailsRecord value3(Short value) {
        setTrackid(value);
        return this;
    }

    @Override
    public SessiondetailsRecord value4(Integer value) {
        setTracklength(value);
        return this;
    }

    @Override
    public SessiondetailsRecord value5(Integer value) {
        setSessionduration(value);
        return this;
    }

    @Override
    public SessiondetailsRecord value6(Byte value) {
        setEra(value);
        return this;
    }

    @Override
    public SessiondetailsRecord values(Integer value1, Byte value2, Short value3, Integer value4, Integer value5, Byte value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SessiondetailsRecord
     */
    public SessiondetailsRecord() {
        super(Sessiondetails.SESSIONDETAILS);
    }

    /**
     * Create a detached, initialised SessiondetailsRecord
     */
    public SessiondetailsRecord(Integer sessionid, Byte laps, Short trackid, Integer tracklength, Integer sessionduration, Byte era) {
        super(Sessiondetails.SESSIONDETAILS);

        set(0, sessionid);
        set(1, laps);
        set(2, trackid);
        set(3, tracklength);
        set(4, sessionduration);
        set(5, era);
    }
}
