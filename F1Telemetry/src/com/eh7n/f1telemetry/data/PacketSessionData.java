package com.eh7n.f1telemetry.data;

import java.util.List;

import com.eh7n.f1telemetry.data.elements.Era;
import com.eh7n.f1telemetry.data.elements.MarshalZone;
import com.eh7n.f1telemetry.data.elements.SafetyCarStatus;
import com.eh7n.f1telemetry.data.elements.SessionType;
import com.eh7n.f1telemetry.data.elements.Weather;
import dbconn.Tables;
import dbconn.tables.Sessioninfos;
import java.util.HashMap;
import ndbconn.tables.records.DatanamesRecord;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

public class PacketSessionData extends Packet {

    private Weather weather;
    private int trackTemperature;
    private int airTemperature;
    private int totalLaps;
    private int trackLength;
    private SessionType sessionType;
    private int trackId;
    private Era era;
    private int sessionTimeLeft;
    private int sessionDuration;
    private int pitSpeedLimit;
    private boolean gamePaused;
    private boolean spectating;
    private int spectatorCarIndex;
    private boolean sliProNativeSupport;
    private int numMarshalZones;
    private List<MarshalZone> marshalZones;
    private SafetyCarStatus safetyCarStatus;
    private boolean networkGame;

    private static final int UPDATEPERIOD = 4;

    public PacketSessionData() {
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public int getTrackTemperature() {
        return trackTemperature;
    }

    public void setTrackTemperature(int trackTemperature) {
        this.trackTemperature = trackTemperature;
    }

    public int getAirTemperature() {
        return airTemperature;
    }

    public void setAirTemperature(int airTemperature) {
        this.airTemperature = airTemperature;
    }

    public int getTotalLaps() {
        return totalLaps;
    }

    public void setTotalLaps(int totalLaps) {
        this.totalLaps = totalLaps;
    }

    public int getTrackLength() {
        return trackLength;
    }

    public void setTrackLength(int trackLength) {
        this.trackLength = trackLength;
    }

    public SessionType getSessionType() {
        return sessionType;
    }

    public void setSessionType(SessionType sessionType) {
        this.sessionType = sessionType;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public Era getEra() {
        return era;
    }

    public void setEra(Era era) {
        this.era = era;
    }

    public int getSessionTimeLeft() {
        return sessionTimeLeft;
    }

    public void setSessionTimeLeft(int sessionTimeLeft) {
        this.sessionTimeLeft = sessionTimeLeft;
    }

    public int getSessionDuration() {
        return sessionDuration;
    }

    public void setSessionDuration(int sessionDuration) {
        this.sessionDuration = sessionDuration;
    }

    public int getPitSpeedLimit() {
        return pitSpeedLimit;
    }

    public void setPitSpeedLimit(int pitSpeedLimit) {
        this.pitSpeedLimit = pitSpeedLimit;
    }

    public boolean isGamePaused() {
        return gamePaused;
    }

    public void setGamePaused(boolean gamePaused) {
        this.gamePaused = gamePaused;
    }

    public boolean isSpectating() {
        return spectating;
    }

    public void setSpectating(boolean spectating) {
        this.spectating = spectating;
    }

    public int getSpectatorCarIndex() {
        return spectatorCarIndex;
    }

    public void setSpectatorCarIndex(int spectatorCarIndex) {
        this.spectatorCarIndex = spectatorCarIndex;
    }

    public boolean isSliProNativeSupport() {
        return sliProNativeSupport;
    }

    public void setSliProNativeSupport(boolean sliProNativeSupport) {
        this.sliProNativeSupport = sliProNativeSupport;
    }

    public int getNumMarshalZones() {
        return numMarshalZones;
    }

    public void setNumMarshalZones(int numMarshalZones) {
        this.numMarshalZones = numMarshalZones;
    }

    public List<MarshalZone> getMarshalZones() {
        return marshalZones;
    }

    public void setMarshalZones(List<MarshalZone> marshalZones) {
        this.marshalZones = marshalZones;
    }

    public SafetyCarStatus getSafetyCarStatus() {
        return safetyCarStatus;
    }

    public void setSafetyCarStatus(SafetyCarStatus safetyCarStatus) {
        this.safetyCarStatus = safetyCarStatus;
    }

    public boolean isNetworkGame() {
        return networkGame;
    }

    public void setNetworkGame(boolean networkGame) {
        this.networkGame = networkGame;
    }

    @Override
    /**
     * update an entry in SessionInfos using session UID do not update history
     * packet list
     */
    public PacketList[] saveToDB(PacketList[] histPacketLists, DSLContext db) {
//        PacketList[] newLists = addToHistLists(histPacketLists);        // add to history buffer
//        int histPacketsCount = newLists[getHeader().getPacketId()].size();
//        if (histPacketsCount == UPDATEPERIOD) {
//            Sessioninfos si = Tables.SESSIONINFOS;  // abrv for table SessionInfos
//            Result<Record> result = db.select()
//                    .from(si)
//                    .where(si.SESSIONUID.eq(getHeader().getSessionUID().longValue()))
//                    .fetch();
//            if (result.size() > 0) {
//                // only update existing entry 
//                db.update(si)
//                        .set(si.TRACKID, (short) getTrackId())
//                        .set(si.PITSPEEDLIMIT, getPitSpeedLimit())
//                        .set(si.DURATION, getSessionDuration())
//                        .set(si.TOTALLAPS, (short) getTotalLaps())
//                        .set(si.TRACKLENGTH, getTrackLength())
//                        .where(si.SESSIONUID.eq(getHeader().getSessionUID().longValue()))
//                        .execute();
//            } else {
//                // insert a new entry
//                db.insertInto(si, si.SESSIONUID, si.TRACKID, si.PITSPEEDLIMIT, si.DURATION, si.TOTALLAPS, si.TRACKLENGTH)
//                        .values(getHeader().getSessionUID().longValue(),
//                                (short) getTrackId(), getPitSpeedLimit(),
//                                getSessionDuration(), (short) getTotalLaps(),
//                                getTrackLength())
//                        .execute();
//
//            }
//        }

        return histPacketLists;
    }

}
