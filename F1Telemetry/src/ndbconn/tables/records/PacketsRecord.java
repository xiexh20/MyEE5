/*
 * This file is generated by jOOQ.
 */
package ndbconn.tables.records;


import java.time.LocalDateTime;

import ndbconn.tables.Packets;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * A table to store common packet information, to avoid reductancy in data 
 * table. This table provides timestamp information for the user to reconstruct 
 * a complete session. 
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PacketsRecord extends UpdatableRecordImpl<PacketsRecord> implements Record5<Integer, Long, Byte, LocalDateTime, Double> {

    private static final long serialVersionUID = -613150847;

    /**
     * Setter for <code>NewF1DB.Packets.idPacket</code>.
     */
    public void setIdpacket(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>NewF1DB.Packets.idPacket</code>.
     */
    public Integer getIdpacket() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>NewF1DB.Packets.sessionUID</code>.
     */
    public void setSessionuid(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>NewF1DB.Packets.sessionUID</code>.
     */
    public Long getSessionuid() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>NewF1DB.Packets.packetType</code>.
     */
    public void setPackettype(Byte value) {
        set(2, value);
    }

    /**
     * Getter for <code>NewF1DB.Packets.packetType</code>.
     */
    public Byte getPackettype() {
        return (Byte) get(2);
    }

    /**
     * Setter for <code>NewF1DB.Packets.arriveTime</code>.
     */
    public void setArrivetime(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>NewF1DB.Packets.arriveTime</code>.
     */
    public LocalDateTime getArrivetime() {
        return (LocalDateTime) get(3);
    }

    /**
     * Setter for <code>NewF1DB.Packets.sessionTime</code>.
     */
    public void setSessiontime(Double value) {
        set(4, value);
    }

    /**
     * Getter for <code>NewF1DB.Packets.sessionTime</code>.
     */
    public Double getSessiontime() {
        return (Double) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, Long, Byte, LocalDateTime, Double> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Integer, Long, Byte, LocalDateTime, Double> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Packets.PACKETS.IDPACKET;
    }

    @Override
    public Field<Long> field2() {
        return Packets.PACKETS.SESSIONUID;
    }

    @Override
    public Field<Byte> field3() {
        return Packets.PACKETS.PACKETTYPE;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return Packets.PACKETS.ARRIVETIME;
    }

    @Override
    public Field<Double> field5() {
        return Packets.PACKETS.SESSIONTIME;
    }

    @Override
    public Integer component1() {
        return getIdpacket();
    }

    @Override
    public Long component2() {
        return getSessionuid();
    }

    @Override
    public Byte component3() {
        return getPackettype();
    }

    @Override
    public LocalDateTime component4() {
        return getArrivetime();
    }

    @Override
    public Double component5() {
        return getSessiontime();
    }

    @Override
    public Integer value1() {
        return getIdpacket();
    }

    @Override
    public Long value2() {
        return getSessionuid();
    }

    @Override
    public Byte value3() {
        return getPackettype();
    }

    @Override
    public LocalDateTime value4() {
        return getArrivetime();
    }

    @Override
    public Double value5() {
        return getSessiontime();
    }

    @Override
    public PacketsRecord value1(Integer value) {
        setIdpacket(value);
        return this;
    }

    @Override
    public PacketsRecord value2(Long value) {
        setSessionuid(value);
        return this;
    }

    @Override
    public PacketsRecord value3(Byte value) {
        setPackettype(value);
        return this;
    }

    @Override
    public PacketsRecord value4(LocalDateTime value) {
        setArrivetime(value);
        return this;
    }

    @Override
    public PacketsRecord value5(Double value) {
        setSessiontime(value);
        return this;
    }

    @Override
    public PacketsRecord values(Integer value1, Long value2, Byte value3, LocalDateTime value4, Double value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PacketsRecord
     */
    public PacketsRecord() {
        super(Packets.PACKETS);
    }

    /**
     * Create a detached, initialised PacketsRecord
     */
    public PacketsRecord(Integer idpacket, Long sessionuid, Byte packettype, LocalDateTime arrivetime, Double sessiontime) {
        super(Packets.PACKETS);

        set(0, idpacket);
        set(1, sessionuid);
        set(2, packettype);
        set(3, arrivetime);
        set(4, sessiontime);
    }
}
