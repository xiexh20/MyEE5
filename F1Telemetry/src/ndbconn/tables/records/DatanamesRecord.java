/*
 * This file is generated by jOOQ.
 */
package ndbconn.tables.records;


import ndbconn.tables.Datanames;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * A table to store different names of the data stored in the data table. 
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DatanamesRecord extends UpdatableRecordImpl<DatanamesRecord> implements Record2<Short, String> {

    private static final long serialVersionUID = 495564132;

    /**
     * Setter for <code>NewF1DB.DataNames.idName</code>.
     */
    public void setIdname(Short value) {
        set(0, value);
    }

    /**
     * Getter for <code>NewF1DB.DataNames.idName</code>.
     */
    public Short getIdname() {
        return (Short) get(0);
    }

    /**
     * Setter for <code>NewF1DB.DataNames.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>NewF1DB.DataNames.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Short> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Short, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Short, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Short> field1() {
        return Datanames.DATANAMES.IDNAME;
    }

    @Override
    public Field<String> field2() {
        return Datanames.DATANAMES.NAME;
    }

    @Override
    public Short component1() {
        return getIdname();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public Short value1() {
        return getIdname();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public DatanamesRecord value1(Short value) {
        setIdname(value);
        return this;
    }

    @Override
    public DatanamesRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public DatanamesRecord values(Short value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DatanamesRecord
     */
    public DatanamesRecord() {
        super(Datanames.DATANAMES);
    }

    /**
     * Create a detached, initialised DatanamesRecord
     */
    public DatanamesRecord(Short idname, String name) {
        super(Datanames.DATANAMES);

        set(0, idname);
        set(1, name);
    }
}
