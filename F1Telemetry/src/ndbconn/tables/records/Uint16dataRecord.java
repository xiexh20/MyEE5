/*
 * This file is generated by jOOQ.
 */
package ndbconn.tables.records;


import ndbconn.tables.Uint16data;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.UShort;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Uint16dataRecord extends UpdatableRecordImpl<Uint16dataRecord> implements Record5<Integer, UShort, Short, Integer, Integer> {

    private static final long serialVersionUID = -1801422347;

    /**
     * Setter for <code>NewF1DB.UInt16Data.idData</code>.
     */
    public void setIddata(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>NewF1DB.UInt16Data.idData</code>.
     */
    public Integer getIddata() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>NewF1DB.UInt16Data.data</code>.
     */
    public void setData(UShort value) {
        set(1, value);
    }

    /**
     * Getter for <code>NewF1DB.UInt16Data.data</code>.
     */
    public UShort getData() {
        return (UShort) get(1);
    }

    /**
     * Setter for <code>NewF1DB.UInt16Data.dataName</code>.
     */
    public void setDataname(Short value) {
        set(2, value);
    }

    /**
     * Getter for <code>NewF1DB.UInt16Data.dataName</code>.
     */
    public Short getDataname() {
        return (Short) get(2);
    }

    /**
     * Setter for <code>NewF1DB.UInt16Data.packetId</code>.
     */
    public void setPacketid(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>NewF1DB.UInt16Data.packetId</code>.
     */
    public Integer getPacketid() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>NewF1DB.UInt16Data.sessionId</code>.
     */
    public void setSessionid(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>NewF1DB.UInt16Data.sessionId</code>.
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
    public Row5<Integer, UShort, Short, Integer, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Integer, UShort, Short, Integer, Integer> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Uint16data.UINT16DATA.IDDATA;
    }

    @Override
    public Field<UShort> field2() {
        return Uint16data.UINT16DATA.DATA;
    }

    @Override
    public Field<Short> field3() {
        return Uint16data.UINT16DATA.DATANAME;
    }

    @Override
    public Field<Integer> field4() {
        return Uint16data.UINT16DATA.PACKETID;
    }

    @Override
    public Field<Integer> field5() {
        return Uint16data.UINT16DATA.SESSIONID;
    }

    @Override
    public Integer component1() {
        return getIddata();
    }

    @Override
    public UShort component2() {
        return getData();
    }

    @Override
    public Short component3() {
        return getDataname();
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
    public UShort value2() {
        return getData();
    }

    @Override
    public Short value3() {
        return getDataname();
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
    public Uint16dataRecord value1(Integer value) {
        setIddata(value);
        return this;
    }

    @Override
    public Uint16dataRecord value2(UShort value) {
        setData(value);
        return this;
    }

    @Override
    public Uint16dataRecord value3(Short value) {
        setDataname(value);
        return this;
    }

    @Override
    public Uint16dataRecord value4(Integer value) {
        setPacketid(value);
        return this;
    }

    @Override
    public Uint16dataRecord value5(Integer value) {
        setSessionid(value);
        return this;
    }

    @Override
    public Uint16dataRecord values(Integer value1, UShort value2, Short value3, Integer value4, Integer value5) {
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
     * Create a detached Uint16dataRecord
     */
    public Uint16dataRecord() {
        super(Uint16data.UINT16DATA);
    }

    /**
     * Create a detached, initialised Uint16dataRecord
     */
    public Uint16dataRecord(Integer iddata, UShort data, Short dataname, Integer packetid, Integer sessionid) {
        super(Uint16data.UINT16DATA);

        set(0, iddata);
        set(1, data);
        set(2, dataname);
        set(3, packetid);
        set(4, sessionid);
    }
}
