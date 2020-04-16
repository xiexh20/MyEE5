/*
 * This file is generated by jOOQ.
 */
package dbconn.tables.records;


import dbconn.tables.Players;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * Store information of players, specified by user. 
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PlayersRecord extends UpdatableRecordImpl<PlayersRecord> implements Record2<Integer, String> {

    private static final long serialVersionUID = 782662845;

    /**
     * Setter for <code>F1GameDB.Players.idPlayer</code>.
     */
    public void setIdplayer(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>F1GameDB.Players.idPlayer</code>.
     */
    public Integer getIdplayer() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>F1GameDB.Players.playerName</code>.
     */
    public void setPlayername(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>F1GameDB.Players.playerName</code>.
     */
    public String getPlayername() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Integer, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Players.PLAYERS.IDPLAYER;
    }

    @Override
    public Field<String> field2() {
        return Players.PLAYERS.PLAYERNAME;
    }

    @Override
    public Integer component1() {
        return getIdplayer();
    }

    @Override
    public String component2() {
        return getPlayername();
    }

    @Override
    public Integer value1() {
        return getIdplayer();
    }

    @Override
    public String value2() {
        return getPlayername();
    }

    @Override
    public PlayersRecord value1(Integer value) {
        setIdplayer(value);
        return this;
    }

    @Override
    public PlayersRecord value2(String value) {
        setPlayername(value);
        return this;
    }

    @Override
    public PlayersRecord values(Integer value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PlayersRecord
     */
    public PlayersRecord() {
        super(Players.PLAYERS);
    }

    /**
     * Create a detached, initialised PlayersRecord
     */
    public PlayersRecord(Integer idplayer, String playername) {
        super(Players.PLAYERS);

        set(0, idplayer);
        set(1, playername);
    }
}
