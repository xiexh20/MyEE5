/*
 * This file is generated by jOOQ.
 */
package ndbconn.tables.records;


import ndbconn.tables.Int32data;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * A table to store data from UDP packets that have int32 type.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Int32dataRecord extends UpdatableRecordImpl<Int32dataRecord> implements Record5<Integer, Short, Integer, Integer, Integer> {

    private static final long serialVersionUID = -1607143956;

    /**
     * Setter for <code>NewF1DB.Int32Data.idData</code>.
     */
    public void setIddata(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>NewF1DB.Int32Data.idData</code>.
     */
    public Integer getIddata() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>NewF1DB.Int32Data.dataName</code>.
     */
    public void setDataname(Short value) {
        set(1, value);
    }

    /**
     * Getter for <code>NewF1DB.Int32Data.dataName</code>.
     */
    public Short getDataname() {
        return (Short) get(1);
    }

    /**
     * Setter for <code>NewF1DB.Int32Data.data</code>.
     */
    public void setData(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>NewF1DB.Int32Data.data</code>.
     */
    public Integer getData() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>NewF1DB.Int32Data.packetId</code>.
     */
    public void setPacketid(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>NewF1DB.Int32Data.packetId</code>.
     */
    public Integer getPacketid() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>NewF1DB.Int32Data.sessionId</code>.
     */
    public void setSessionid(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>NewF1DB.Int32Data.sessionId</code>.
     */
    public Integer getSessionid() {
        return (Integer) get(4);
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
    public Row5<Integer, Short, Integer, Integer, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Integer, Short, Integer, Integer, Integer> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Int32data.INT32DATA.IDDATA;
    }

    @Override
    public Field<Short> field2() {
        return Int32data.INT32DATA.DATANAME;
    }

    @Override
    public Field<Integer> field3() {
        return Int32data.INT32DATA.DATA;
    }

    @Override
    public Field<Integer> field4() {
        return Int32data.INT32DATA.PACKETID;
    }

    @Override
    public Field<Integer> field5() {
        return Int32data.INT32DATA.SESSIONID;
    }

    @Override
    public Integer component1() {
        return getIddata();
    }

    @Override
    public Short component2() {
        return getDataname();
    }

    @Override
    public Integer component3() {
        return getData();
    }

    @Override
    public Integer component4() {
        return getPacketid();
    }

    @Override
    public Integer component5() {
        return getSessionid();
    }

    @Override
    public Integer value1() {
        return getIddata();
    }

    @Override
    public Short value2() {
        return getDataname();
    }

    @Override
    public Integer value3() {
        return getData();
    }

    @Override
    public Integer value4() {
        return getPacketid();
    }

    @Override
    public Integer value5() {
        return getSessionid();
    }

    @Override
    public Int32dataRecord value1(Integer value) {
        setIddata(value);
        return this;
    }

    @Override
    public Int32dataRecord value2(Short value) {
        setDataname(value);
        return this;
    }

    @Override
    public Int32dataRecord value3(Integer value) {
        setData(value);
        return this;
    }

    @Override
    public Int32dataRecord value4(Integer value) {
        setPacketid(value);
        return this;
    }

    @Override
    public Int32dataRecord value5(Integer value) {
        setSessionid(value);
        return this;
    }

    @Override
    public Int32dataRecord values(Integer value1, Short value2, Integer value3, Integer value4, Integer value5) {
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
     * Create a detached Int32dataRecord
     */
    public Int32dataRecord() {
        super(Int32data.INT32DATA);
    }

    /**
     * Create a detached, initialised Int32dataRecord
     */
    public Int32dataRecord(Integer iddata, Short dataname, Integer data, Integer packetid, Integer sessionid) {
        super(Int32data.INT32DATA);

        set(0, iddata);
        set(1, dataname);
        set(2, data);
        set(3, packetid);
        set(4, sessionid);
    }
}
