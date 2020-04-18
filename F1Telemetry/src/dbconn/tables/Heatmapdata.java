/*
 * This file is generated by jOOQ.
 */
package dbconn.tables;


import dbconn.F1gamedb;
import dbconn.Keys;
import dbconn.tables.records.HeatmapdataRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row16;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * Data needed to generate a heat map of the car. Update ratio 1Hz is good 
 * enough. 
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Heatmapdata extends TableImpl<HeatmapdataRecord> {

    private static final long serialVersionUID = 1015318796;

    /**
     * The reference instance of <code>F1GameDB.HeatMapData</code>
     */
    public static final Heatmapdata HEATMAPDATA = new Heatmapdata();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<HeatmapdataRecord> getRecordType() {
        return HeatmapdataRecord.class;
    }

    /**
     * The column <code>F1GameDB.HeatMapData.idHeatMapData</code>.
     */
    public final TableField<HeatmapdataRecord, Integer> IDHEATMAPDATA = createField(DSL.name("idHeatMapData"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>F1GameDB.HeatMapData.sessionId</code>.
     */
    public final TableField<HeatmapdataRecord, Long> SESSIONID = createField(DSL.name("sessionId"), org.jooq.impl.SQLDataType.BIGINT.defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>F1GameDB.HeatMapData.sessionTime</code>.
     */
    public final TableField<HeatmapdataRecord, Double> SESSIONTIME = createField(DSL.name("sessionTime"), org.jooq.impl.SQLDataType.FLOAT.defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.FLOAT)), this, "");

    /**
     * The column <code>F1GameDB.HeatMapData.brakeRL</code>.
     */
    public final TableField<HeatmapdataRecord, Integer> BRAKERL = createField(DSL.name("brakeRL"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>F1GameDB.HeatMapData.brakeRR</code>.
     */
    public final TableField<HeatmapdataRecord, Integer> BRAKERR = createField(DSL.name("brakeRR"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>F1GameDB.HeatMapData.brakeFL</code>.
     */
    public final TableField<HeatmapdataRecord, Integer> BRAKEFL = createField(DSL.name("brakeFL"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>F1GameDB.HeatMapData.brakeFR</code>.
     */
    public final TableField<HeatmapdataRecord, Integer> BRAKEFR = createField(DSL.name("brakeFR"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>F1GameDB.HeatMapData.tyreRLSurface</code>.
     */
    public final TableField<HeatmapdataRecord, Integer> TYRERLSURFACE = createField(DSL.name("tyreRLSurface"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>F1GameDB.HeatMapData.tyreRRSurface</code>.
     */
    public final TableField<HeatmapdataRecord, Integer> TYRERRSURFACE = createField(DSL.name("tyreRRSurface"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>F1GameDB.HeatMapData.tyreFLSurface</code>.
     */
    public final TableField<HeatmapdataRecord, Integer> TYREFLSURFACE = createField(DSL.name("tyreFLSurface"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>F1GameDB.HeatMapData.tyreFRSurface</code>.
     */
    public final TableField<HeatmapdataRecord, Integer> TYREFRSURFACE = createField(DSL.name("tyreFRSurface"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>F1GameDB.HeatMapData.engine</code>.
     */
    public final TableField<HeatmapdataRecord, Integer> ENGINE = createField(DSL.name("engine"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>F1GameDB.HeatMapData.tyreRLInner</code>.
     */
    public final TableField<HeatmapdataRecord, Integer> TYRERLINNER = createField(DSL.name("tyreRLInner"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>F1GameDB.HeatMapData.tyreRRInner</code>.
     */
    public final TableField<HeatmapdataRecord, Integer> TYRERRINNER = createField(DSL.name("tyreRRInner"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>F1GameDB.HeatMapData.tyreFLInner</code>.
     */
    public final TableField<HeatmapdataRecord, Integer> TYREFLINNER = createField(DSL.name("tyreFLInner"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>F1GameDB.HeatMapData.tyreFRInner</code>.
     */
    public final TableField<HeatmapdataRecord, Integer> TYREFRINNER = createField(DSL.name("tyreFRInner"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * Create a <code>F1GameDB.HeatMapData</code> table reference
     */
    public Heatmapdata() {
        this(DSL.name("HeatMapData"), null);
    }

    /**
     * Create an aliased <code>F1GameDB.HeatMapData</code> table reference
     */
    public Heatmapdata(String alias) {
        this(DSL.name(alias), HEATMAPDATA);
    }

    /**
     * Create an aliased <code>F1GameDB.HeatMapData</code> table reference
     */
    public Heatmapdata(Name alias) {
        this(alias, HEATMAPDATA);
    }

    private Heatmapdata(Name alias, Table<HeatmapdataRecord> aliased) {
        this(alias, aliased, null);
    }

    private Heatmapdata(Name alias, Table<HeatmapdataRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Data needed to generate a heat map of the car. Update ratio 1Hz is good enough. "), TableOptions.table());
    }

    public <O extends Record> Heatmapdata(Table<O> child, ForeignKey<O, HeatmapdataRecord> key) {
        super(child, key, HEATMAPDATA);
    }

    @Override
    public Schema getSchema() {
        return F1gamedb.F1GAMEDB;
    }

    @Override
    public Identity<HeatmapdataRecord, Integer> getIdentity() {
        return Keys.IDENTITY_HEATMAPDATA;
    }

    @Override
    public UniqueKey<HeatmapdataRecord> getPrimaryKey() {
        return Keys.KEY_HEATMAPDATA_PRIMARY;
    }

    @Override
    public List<UniqueKey<HeatmapdataRecord>> getKeys() {
        return Arrays.<UniqueKey<HeatmapdataRecord>>asList(Keys.KEY_HEATMAPDATA_PRIMARY);
    }

    @Override
    public Heatmapdata as(String alias) {
        return new Heatmapdata(DSL.name(alias), this);
    }

    @Override
    public Heatmapdata as(Name alias) {
        return new Heatmapdata(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Heatmapdata rename(String name) {
        return new Heatmapdata(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Heatmapdata rename(Name name) {
        return new Heatmapdata(name, null);
    }

    // -------------------------------------------------------------------------
    // Row16 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row16<Integer, Long, Double, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fieldsRow() {
        return (Row16) super.fieldsRow();
    }
}
