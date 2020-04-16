/*
 * This file is generated by jOOQ.
 */
package dbconn.tables.records;


import dbconn.tables.Sessionstatistics;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * Statistic information about how the player controllers the game, such as 
 * what buttons are pressed, temperature, etc. 
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SessionstatisticsRecord extends UpdatableRecordImpl<SessionstatisticsRecord> implements Record6<Integer, Integer, Byte, Short, LocalDateTime, Integer> {

    private static final long serialVersionUID = -1224194663;

    /**
     * Setter for <code>F1GameDB.SessionStatistics.sessionId</code>.
     */
    public void setSessionid(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>F1GameDB.SessionStatistics.sessionId</code>.
     */
    public Integer getSessionid() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>F1GameDB.SessionStatistics.speedUp</code>.
     */
    public void setSpeedup(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>F1GameDB.SessionStatistics.speedUp</code>.
     */
    public Integer getSpeedup() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>F1GameDB.SessionStatistics.packetFreq</code>.
     */
    public void setPacketfreq(Byte value) {
        set(2, value);
    }

    /**
     * Getter for <code>F1GameDB.SessionStatistics.packetFreq</code>.
     */
    public Byte getPacketfreq() {
        return (Byte) get(2);
    }

    /**
     * Setter for <code>F1GameDB.SessionStatistics.maxTemp</code>.
     */
    public void setMaxtemp(Short value) {
        set(3, value);
    }

    /**
     * Getter for <code>F1GameDB.SessionStatistics.maxTemp</code>.
     */
    public Short getMaxtemp() {
        return (Short) get(3);
    }

    /**
     * Setter for <code>F1GameDB.SessionStatistics.hottestTime</code>.
     */
    public void setHottesttime(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>F1GameDB.SessionStatistics.hottestTime</code>.
     */
    public LocalDateTime getHottesttime() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>F1GameDB.SessionStatistics.brakingTime</code>.
     */
    public void setBrakingtime(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>F1GameDB.SessionStatistics.brakingTime</code>.
     */
    public Integer getBrakingtime() {
        return (Integer) get(5);
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
    public Row6<Integer, Integer, Byte, Short, LocalDateTime, Integer> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Integer, Integer, Byte, Short, LocalDateTime, Integer> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Sessionstatistics.SESSIONSTATISTICS.SESSIONID;
    }

    @Override
    public Field<Integer> field2() {
        return Sessionstatistics.SESSIONSTATISTICS.SPEEDUP;
    }

    @Override
    public Field<Byte> field3() {
        return Sessionstatistics.SESSIONSTATISTICS.PACKETFREQ;
    }

    @Override
    public Field<Short> field4() {
        return Sessionstatistics.SESSIONSTATISTICS.MAXTEMP;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return Sessionstatistics.SESSIONSTATISTICS.HOTTESTTIME;
    }

    @Override
    public Field<Integer> field6() {
        return Sessionstatistics.SESSIONSTATISTICS.BRAKINGTIME;
    }

    @Override
    public Integer component1() {
        return getSessionid();
    }

    @Override
    public Integer component2() {
        return getSpeedup();
    }

    @Override
    public Byte component3() {
        return getPacketfreq();
    }

    @Override
    public Short component4() {
        return getMaxtemp();
    }

    @Override
    public LocalDateTime component5() {
        return getHottesttime();
    }

    @Override
    public Integer component6() {
        return getBrakingtime();
    }

    @Override
    public Integer value1() {
        return getSessionid();
    }

    @Override
    public Integer value2() {
        return getSpeedup();
    }

    @Override
    public Byte value3() {
        return getPacketfreq();
    }

    @Override
    public Short value4() {
        return getMaxtemp();
    }

    @Override
    public LocalDateTime value5() {
        return getHottesttime();
    }

    @Override
    public Integer value6() {
        return getBrakingtime();
    }

    @Override
    public SessionstatisticsRecord value1(Integer value) {
        setSessionid(value);
        return this;
    }

    @Override
    public SessionstatisticsRecord value2(Integer value) {
        setSpeedup(value);
        return this;
    }

    @Override
    public SessionstatisticsRecord value3(Byte value) {
        setPacketfreq(value);
        return this;
    }

    @Override
    public SessionstatisticsRecord value4(Short value) {
        setMaxtemp(value);
        return this;
    }

    @Override
    public SessionstatisticsRecord value5(LocalDateTime value) {
        setHottesttime(value);
        return this;
    }

    @Override
    public SessionstatisticsRecord value6(Integer value) {
        setBrakingtime(value);
        return this;
    }

    @Override
    public SessionstatisticsRecord values(Integer value1, Integer value2, Byte value3, Short value4, LocalDateTime value5, Integer value6) {
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
     * Create a detached SessionstatisticsRecord
     */
    public SessionstatisticsRecord() {
        super(Sessionstatistics.SESSIONSTATISTICS);
    }

    /**
     * Create a detached, initialised SessionstatisticsRecord
     */
    public SessionstatisticsRecord(Integer sessionid, Integer speedup, Byte packetfreq, Short maxtemp, LocalDateTime hottesttime, Integer brakingtime) {
        super(Sessionstatistics.SESSIONSTATISTICS);

        set(0, sessionid);
        set(1, speedup);
        set(2, packetfreq);
        set(3, maxtemp);
        set(4, hottesttime);
        set(5, brakingtime);
    }
}
