/*
 * This file is generated by jOOQ.
 */
package dbconn.tables;


import dbconn.F1gamedb;
import dbconn.Keys;
import dbconn.tables.records.TracksRecord;

import java.util.Arrays;
import java.util.List;

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
 * Tracks information specified by F1 2018.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tracks extends TableImpl<TracksRecord> {

    private static final long serialVersionUID = 1935555951;

    /**
     * The reference instance of <code>F1GameDB.Tracks</code>
     */
    public static final Tracks TRACKS = new Tracks();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TracksRecord> getRecordType() {
        return TracksRecord.class;
    }

    /**
     * The column <code>F1GameDB.Tracks.idTrack</code>.
     */
    public final TableField<TracksRecord, Short> IDTRACK = createField(DSL.name("idTrack"), org.jooq.impl.SQLDataType.SMALLINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>F1GameDB.Tracks.trackName</code>.
     */
    public final TableField<TracksRecord, String> TRACKNAME = createField(DSL.name("trackName"), org.jooq.impl.SQLDataType.VARCHAR(50).defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * Create a <code>F1GameDB.Tracks</code> table reference
     */
    public Tracks() {
        this(DSL.name("Tracks"), null);
    }

    /**
     * Create an aliased <code>F1GameDB.Tracks</code> table reference
     */
    public Tracks(String alias) {
        this(DSL.name(alias), TRACKS);
    }

    /**
     * Create an aliased <code>F1GameDB.Tracks</code> table reference
     */
    public Tracks(Name alias) {
        this(alias, TRACKS);
    }

    private Tracks(Name alias, Table<TracksRecord> aliased) {
        this(alias, aliased, null);
    }

    private Tracks(Name alias, Table<TracksRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Tracks information specified by F1 2018."), TableOptions.table());
    }

    public <O extends Record> Tracks(Table<O> child, ForeignKey<O, TracksRecord> key) {
        super(child, key, TRACKS);
    }

    @Override
    public Schema getSchema() {
        return F1gamedb.F1GAMEDB;
    }

    @Override
    public Identity<TracksRecord, Short> getIdentity() {
        return Keys.IDENTITY_TRACKS;
    }

    @Override
    public UniqueKey<TracksRecord> getPrimaryKey() {
        return Keys.KEY_TRACKS_PRIMARY;
    }

    @Override
    public List<UniqueKey<TracksRecord>> getKeys() {
        return Arrays.<UniqueKey<TracksRecord>>asList(Keys.KEY_TRACKS_PRIMARY);
    }

    @Override
    public Tracks as(String alias) {
        return new Tracks(DSL.name(alias), this);
    }

    @Override
    public Tracks as(Name alias) {
        return new Tracks(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Tracks rename(String name) {
        return new Tracks(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Tracks rename(Name name) {
        return new Tracks(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Short, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
