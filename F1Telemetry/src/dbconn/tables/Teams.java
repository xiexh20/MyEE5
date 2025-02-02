/*
 * This file is generated by jOOQ.
 */
package dbconn.tables;


import dbconn.F1gamedb;
import dbconn.Keys;
import dbconn.tables.records.TeamsRecord;

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
 * Store information of all teams specified by F1 2018.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Teams extends TableImpl<TeamsRecord> {

    private static final long serialVersionUID = 954745723;

    /**
     * The reference instance of <code>F1GameDB.Teams</code>
     */
    public static final Teams TEAMS = new Teams();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TeamsRecord> getRecordType() {
        return TeamsRecord.class;
    }

    /**
     * The column <code>F1GameDB.Teams.idTeam</code>.
     */
    public final TableField<TeamsRecord, Short> IDTEAM = createField(DSL.name("idTeam"), org.jooq.impl.SQLDataType.SMALLINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>F1GameDB.Teams.teamName</code>.
     */
    public final TableField<TeamsRecord, String> TEAMNAME = createField(DSL.name("teamName"), org.jooq.impl.SQLDataType.VARCHAR(50).defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * Create a <code>F1GameDB.Teams</code> table reference
     */
    public Teams() {
        this(DSL.name("Teams"), null);
    }

    /**
     * Create an aliased <code>F1GameDB.Teams</code> table reference
     */
    public Teams(String alias) {
        this(DSL.name(alias), TEAMS);
    }

    /**
     * Create an aliased <code>F1GameDB.Teams</code> table reference
     */
    public Teams(Name alias) {
        this(alias, TEAMS);
    }

    private Teams(Name alias, Table<TeamsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Teams(Name alias, Table<TeamsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Store information of all teams specified by F1 2018."), TableOptions.table());
    }

    public <O extends Record> Teams(Table<O> child, ForeignKey<O, TeamsRecord> key) {
        super(child, key, TEAMS);
    }

    @Override
    public Schema getSchema() {
        return F1gamedb.F1GAMEDB;
    }

    @Override
    public Identity<TeamsRecord, Short> getIdentity() {
        return Keys.IDENTITY_TEAMS;
    }

    @Override
    public UniqueKey<TeamsRecord> getPrimaryKey() {
        return Keys.KEY_TEAMS_PRIMARY;
    }

    @Override
    public List<UniqueKey<TeamsRecord>> getKeys() {
        return Arrays.<UniqueKey<TeamsRecord>>asList(Keys.KEY_TEAMS_PRIMARY);
    }

    @Override
    public Teams as(String alias) {
        return new Teams(DSL.name(alias), this);
    }

    @Override
    public Teams as(Name alias) {
        return new Teams(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Teams rename(String name) {
        return new Teams(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Teams rename(Name name) {
        return new Teams(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Short, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
