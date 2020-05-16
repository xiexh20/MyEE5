package com.eh7n.f1telemetry.data;

import java.util.List;

import com.eh7n.f1telemetry.data.elements.CarStatusData;
import dbconn.Tables;
import dbconn.tables.Carstatusdata;
import java.util.HashMap;
import ndbconn.tables.records.DatanamesRecord;
import org.jooq.DSLContext;
import org.jooq.Result;

public class PacketCarStatusData extends Packet {

    private List<CarStatusData> carStatuses;

    private static final int UPDATEPERIOD = 10;

    public PacketCarStatusData() {
    }

    public List<CarStatusData> getCarStatuses() {
        return carStatuses;
    }

    public void setCarStatuses(List<CarStatusData> carStatuses) {
        this.carStatuses = carStatuses;
    }

    @Override
    public PacketList[] saveToDB(PacketList[] histPacketLists, DSLContext dbContext, HashMap<String, Short> nameIdMap) {

        PacketList[] newLists = addToHistLists(histPacketLists);        // add to history buffer
        int histPacketsCount = newLists[getHeader().getPacketId()].size();
        if (histPacketsCount == UPDATEPERIOD) {
            Carstatusdata CST = Tables.CARSTATUSDATA;   // abriviate for table CarStatusData
            CarStatusData csData = carStatuses.get(getHeader().getPlayerCarIndex());

            dbContext.insertInto(CST, CST.SESSIONID, CST.SESSIONTIME, CST.FUELINTANK,
                    CST.FRONTLEFTWINGDAMAGE, CST.FRONTRIGHTWINGDAMAGE, CST.REARWINGDAMAGE,
                    CST.ENGINEDAMAGE, CST.GEARBOXDAMAGE, CST.EXHAUSTDAMAGE,
                    CST.TYRERLDAMAGE, CST.TYRERRDAMAGE, CST.TYREFLDAMAGE, CST.TYREFRDAMAGE)
                    .values(getHeader().getSessionUID().longValue(),
                            (double) getHeader().getSessionTime(),
                            (double) csData.getFuelInTank(),
                            (short) csData.getFrontLeftWingDamage(),
                            (short) csData.getFrontRightWingDamage(),
                            (short) csData.getRearWingDamage(),
                            (short) csData.getEngineDamage(),
                            (short) csData.getGearBoxDamage(),
                            (short) csData.getExhaustDamage(),
                            (short) csData.getTiresDamage().getRearLeft().intValue(),
                            (short) csData.getTiresDamage().getRearRight().intValue(),
                            (short) csData.getTiresDamage().getFrontLeft().intValue(),
                            (short) csData.getTiresDamage().getFrontRight().intValue()
                    )
                    .execute();
            // empty the lap list buffer
            newLists[getHeader().getPacketId()].clear();

        }
        return newLists;
    }

}
