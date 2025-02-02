/*
 * This file is generated by jOOQ.
 */
package ndbconn.tables;


import java.util.Arrays;
import java.util.List;

import ndbconn.Indexes;
import ndbconn.Keys;
import ndbconn.Newf1db;
import ndbconn.tables.records.Int32dataRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * A table to store data from UDP packets that have int32 type.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Int32data extends TableImpl<Int32dataRecord> {

    private static final long serialVersionUID = -349036214;

    /**
     * The reference instance of <code>NewF1DB.Int32Data</code>
     */
    public static final Int32data INT32DATA = new Int32data();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Int32dataRecord> getRecordType() {
        return Int32dataRecord.class;
    }

    /**
     * The column <code>NewF1DB.Int32Data.idData</code>.
     */
    public final TableField<Int32dataRecord, Integer> IDDATA = createField(DSL.name("idData"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>NewF1DB.Int32Data.dataName</code>.
     */
    public final TableField<Int32dataRecord, Short> DATANAME = createField(DSL.name("dataName"), org.jooq.impl.SQLDataType.SMALLINT.defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.SMALLINT)), this, "");

    /**
     * The column <code>NewF1DB.Int32Data.data</code>.
     */
    public final TableField<Int32dataRecord, Integer> DATA = createField(DSL.name("data"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>NewF1DB.Int32Data.packetId</code>.
     */
    public final TableField<Int32dataRecord, Integer> PACKETID = createField(DSL.name("packetId"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>NewF1DB.Int32Data.sessionId</code>.
     */
    public final TableField<Int32dataRecord, Integer> SESSIONID = createField(DSL.name("sessionId"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * Create a <code>NewF1DB.Int32Data</code> table reference
     */
    public Int32data() {
        this(DSL.name("Int32Data"), null);
    }

    /**
     * Create an aliased <code>NewF1DB.Int32Data</code> table reference
     */
    public Int32data(String alias) {
        this(DSL.name(alias), INT32DATA);
    }

    /**
     * Create an aliased <code>NewF1DB.Int32Data</code> table reference
     */
    public Int32data(Name alias) {
        this(alias, INT32DATA);
    }

    private Int32data(Name alias, Table<Int32dataRecord> aliased) {
        this(alias, aliased, null);
    }

    private Int32data(Name alias, Table<Int32dataRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("A table to store data from UDP packets that have int32 type."), TableOptions.table());
    }

    public <O extends Record> Int32data(Table<O> child, ForeignKey<O, Int32dataRecord> key) {
        super(child, key, INT32DATA);
    }

    @Override
    public Schema getSchema() {
        return Newf1db.NEWF1DB;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.INT32DATA_INT32TONAME_IDX, Indexes.INT32DATA_INT32TOPACKET_IDX, Indexes.INT32DATA_INT32TOSESSION_IDX);
    }

    @Override
    public Identity<Int32dataRecord, Integer> getIdentity() {
        return Keys.IDENTITY_INT32DATA;
    }

    @Override
    public UniqueKey<Int32dataRecord> getPrimaryKey() {
        return Keys.KEY_INT32DATA_PRIMARY;
    }

    @Override
    public List<UniqueKey<Int32dataRecord>> getKeys() {
        return Arrays.<UniqueKey<Int32dataRecord>>asList(Keys.KEY_INT32DATA_PRIMARY);
    }

    @Override
    public List<ForeignKey<Int32dataRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<Int32dataRecord, ?>>asList(Keys.INT32TONAME, Keys.INT32TOPACKET, Keys.INT32TOSESSION);
    }

    public Datanames datanames() {
        return new Datanames(this, Keys.INT32TONAME);
    }

    public Packets packets() {
        return new Packets(this, Keys.INT32TOPACKET);
    }

    public Sessions sessions() {
        return new Sessions(this, Keys.INT32TOSESSION);
    }

    @Override
    public Int32data as(String alias) {
        return new Int32data(DSL.name(alias), this);
    }

    @Override
    public Int32data as(Name alias) {
        return new Int32data(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Int32data rename(String name) {
        return new Int32data(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Int32data rename(Name name) {
        return new Int32data(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, Short, Integer, Integer, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
