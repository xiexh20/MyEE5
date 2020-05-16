/*
 * This file is generated by jOOQ.
 */
package ndbconn.tables.records;


import java.time.LocalDateTime;

import ndbconn.tables.Packets;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * A table to store common packet information, to avoid reductancy in data 
 * table. This table provides timestamp information for the user to reconstruct 
 * a complete session. 
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PacketsRecord extends UpdatableRecordImpl<PacketsRecord> implements Record3<Integer, LocalDateTime, Double> {

    private static final long serialVersionUID = -1612841761;

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
     * Setter for <code>NewF1DB.Packets.arriveTime</code>.
     */
    public void setArrivetime(LocalDateTime value) {
        set(1, value);
    }

    /**
     * Getter for <code>NewF1DB.Packets.arriveTime</code>.
     */
    public LocalDateTime getArrivetime() {
        return (LocalDateTime) get(1);
    }

    /**
     * Setter for <code>NewF1DB.Packets.sessionTime</code>.
     */
    public void setSessiontime(Double value) {
        set(2, value);
    }

    /**
     * Getter for <code>NewF1DB.Packets.sessionTime</code>.
     */
    public Double getSessiontime() {
        return (Double) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, LocalDateTime, Double> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Integer, LocalDateTime, Double> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Packets.PACKETS.IDPACKET;
    }

    @Override
    public Field<LocalDateTime> field2() {
        return Packets.PACKETS.ARRIVETIME;
    }

    @Override
    public Field<Double> field3() {
        return Packets.PACKETS.SESSIONTIME;
    }

    @Override
    public Integer component1() {
        return getIdpacket();
    }

    @Override
    public LocalDateTime component2() {
        return getArrivetime();
    }

    @Override
    public Double component3() {
        return getSessiontime();
    }

    @Override
    public Integer value1() {
        return getIdpacket();
    }

    @Override
    public LocalDateTime value2() {
        return getArrivetime();
    }

    @Override
    public Double value3() {
        return getSessiontime();
    }

    @Override
    public PacketsRecord value1(Integer value) {
        setIdpacket(value);
        return this;
    }

    @Override
    public PacketsRecord value2(LocalDateTime value) {
        setArrivetime(value);
        return this;
    }

    @Override
    public PacketsRecord value3(Double value) {
        setSessiontime(value);
        return this;
    }

    @Override
    public PacketsRecord values(Integer value1, LocalDateTime value2, Double value3) {
        value1(value1);
        value2(value2);
        value3(value3);
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
    public PacketsRecord(Integer idpacket, LocalDateTime arrivetime, Double sessiontime) {
        super(Packets.PACKETS);

        set(0, idpacket);
        set(1, arrivetime);
        set(2, sessiontime);
    }
}
