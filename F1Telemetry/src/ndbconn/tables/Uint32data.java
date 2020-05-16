/*
 * This file is generated by jOOQ.
 */
package ndbconn.tables;


import java.util.Arrays;
import java.util.List;

import ndbconn.Indexes;
import ndbconn.Keys;
import ndbconn.Newf1db;
import ndbconn.tables.records.Uint32dataRecord;

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
import org.jooq.types.UInteger;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Uint32data extends TableImpl<Uint32dataRecord> {

    private static final long serialVersionUID = 1275490316;

    /**
     * The reference instance of <code>NewF1DB.UInt32Data</code>
     */
    public static final Uint32data UINT32DATA = new Uint32data();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Uint32dataRecord> getRecordType() {
        return Uint32dataRecord.class;
    }

    /**
     * The column <code>NewF1DB.UInt32Data.idData</code>.
     */
    public final TableField<Uint32dataRecord, Integer> IDDATA = createField(DSL.name("idData"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>NewF1DB.UInt32Data.data</code>.
     */
    public final TableField<Uint32dataRecord, UInteger> DATA = createField(DSL.name("data"), org.jooq.impl.SQLDataType.INTEGERUNSIGNED.defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.INTEGERUNSIGNED)), this, "");

    /**
     * The column <code>NewF1DB.UInt32Data.dataName</code>.
     */
    public final TableField<Uint32dataRecord, Short> DATANAME = createField(DSL.name("dataName"), org.jooq.impl.SQLDataType.SMALLINT.defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.SMALLINT)), this, "");

    /**
     * The column <code>NewF1DB.UInt32Data.packetId</code>.
     */
    public final TableField<Uint32dataRecord, Integer> PACKETID = createField(DSL.name("packetId"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>NewF1DB.UInt32Data.sessionId</code>.
     */
    public final TableField<Uint32dataRecord, Integer> SESSIONID = createField(DSL.name("sessionId"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * Create a <code>NewF1DB.UInt32Data</code> table reference
     */
    public Uint32data() {
        this(DSL.name("UInt32Data"), null);
    }

    /**
     * Create an aliased <code>NewF1DB.UInt32Data</code> table reference
     */
    public Uint32data(String alias) {
        this(DSL.name(alias), UINT32DATA);
    }

    /**
     * Create an aliased <code>NewF1DB.UInt32Data</code> table reference
     */
    public Uint32data(Name alias) {
        this(alias, UINT32DATA);
    }

    private Uint32data(Name alias, Table<Uint32dataRecord> aliased) {
        this(alias, aliased, null);
    }

    private Uint32data(Name alias, Table<Uint32dataRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Uint32data(Table<O> child, ForeignKey<O, Uint32dataRecord> key) {
        super(child, key, UINT32DATA);
    }

    @Override
    public Schema getSchema() {
        return Newf1db.NEWF1DB;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.UINT32DATA_UINT32TONAME_IDX, Indexes.UINT32DATA_UINT32TOPACKET_IDX, Indexes.UINT32DATA_UINT32TOSESSION_IDX);
    }

    @Override
    public Identity<Uint32dataRecord, Integer> getIdentity() {
        return Keys.IDENTITY_UINT32DATA;
    }

    @Override
    public UniqueKey<Uint32dataRecord> getPrimaryKey() {
        return Keys.KEY_UINT32DATA_PRIMARY;
    }

    @Override
    public List<UniqueKey<Uint32dataRecord>> getKeys() {
        return Arrays.<UniqueKey<Uint32dataRecord>>asList(Keys.KEY_UINT32DATA_PRIMARY);
    }

    @Override
    public List<ForeignKey<Uint32dataRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<Uint32dataRecord, ?>>asList(Keys.UINT32TONAME, Keys.UINT32TOPACKET, Keys.UINT32TOSESSION);
    }

    public Datanames datanames() {
        return new Datanames(this, Keys.UINT32TONAME);
    }

    public Packets packets() {
        return new Packets(this, Keys.UINT32TOPACKET);
    }

    public Sessions sessions() {
        return new Sessions(this, Keys.UINT32TOSESSION);
    }

    @Override
    public Uint32data as(String alias) {
        return new Uint32data(DSL.name(alias), this);
    }

    @Override
    public Uint32data as(Name alias) {
        return new Uint32data(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Uint32data rename(String name) {
        return new Uint32data(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Uint32data rename(Name name) {
        return new Uint32data(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, UInteger, Short, Integer, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
