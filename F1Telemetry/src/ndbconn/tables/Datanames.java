/*
 * This file is generated by jOOQ.
 */
package ndbconn.tables;


import java.util.Arrays;
import java.util.List;

import ndbconn.Keys;
import ndbconn.Newf1db;
import ndbconn.tables.records.DatanamesRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * A table to store different names of the data stored in the data table. 
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Datanames extends TableImpl<DatanamesRecord> {

    private static final long serialVersionUID = 178977980;

    /**
     * The reference instance of <code>NewF1DB.DataNames</code>
     */
    public static final Datanames DATANAMES = new Datanames();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DatanamesRecord> getRecordType() {
        return DatanamesRecord.class;
    }

    /**
     * The column <code>NewF1DB.DataNames.idName</code>.
     */
    public final TableField<DatanamesRecord, Short> IDNAME = createField(DSL.name("idName"), org.jooq.impl.SQLDataType.SMALLINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>NewF1DB.DataNames.name</code>.
     */
    public final TableField<DatanamesRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR(45).defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * Create a <code>NewF1DB.DataNames</code> table reference
     */
    public Datanames() {
        this(DSL.name("DataNames"), null);
    }

    /**
     * Create an aliased <code>NewF1DB.DataNames</code> table reference
     */
    public Datanames(String alias) {
        this(DSL.name(alias), DATANAMES);
    }

    /**
     * Create an aliased <code>NewF1DB.DataNames</code> table reference
     */
    public Datanames(Name alias) {
        this(alias, DATANAMES);
    }

    private Datanames(Name alias, Table<DatanamesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Datanames(Name alias, Table<DatanamesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("A table to store different names of the data stored in the data table. "), TableOptions.table());
    }

    public <O extends Record> Datanames(Table<O> child, ForeignKey<O, DatanamesRecord> key) {
        super(child, key, DATANAMES);
    }

    @Override
    public Schema getSchema() {
        return Newf1db.NEWF1DB;
    }

    @Override
    public Identity<DatanamesRecord, Short> getIdentity() {
        return Keys.IDENTITY_DATANAMES;
    }

    @Override
    public UniqueKey<DatanamesRecord> getPrimaryKey() {
        return Keys.KEY_DATANAMES_PRIMARY;
    }

    @Override
    public List<UniqueKey<DatanamesRecord>> getKeys() {
        return Arrays.<UniqueKey<DatanamesRecord>>asList(Keys.KEY_DATANAMES_PRIMARY, Keys.KEY_DATANAMES_NAME_UNIQUE);
    }

    @Override
    public Datanames as(String alias) {
        return new Datanames(DSL.name(alias), this);
    }

    @Override
    public Datanames as(Name alias) {
        return new Datanames(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Datanames rename(String name) {
        return new Datanames(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Datanames rename(Name name) {
        return new Datanames(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Short, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
