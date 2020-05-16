package com.eh7n.f1telemetry.data;

import java.util.List;

import com.eh7n.f1telemetry.data.elements.CarMotionData;
import com.eh7n.f1telemetry.data.elements.WheelData;
import dbconn.Tables;
import dbconn.tables.Motiondata;
import java.util.HashMap;
import ndbconn.tables.records.DatanamesRecord;
import org.jooq.DSLContext;
import org.jooq.Result;

public class PacketMotionData extends Packet {

    private List<CarMotionData> carMotionDataList;
    private WheelData<Float> suspensionPosition;
    private WheelData<Float> suspensionVelocity;
    private WheelData<Float> suspensionAcceleration;
    private WheelData<Float> wheelSpeed;
    private WheelData<Float> wheelSlip;
    private float localVelocityX;
    private float localVelocityY;
    private float localVelocityZ;
    private float angularVelocityX;
    private float angularVelocityY;
    private float angularVelocityZ;
    private float angularAccelerationX;
    private float angularAccelerationY;
    private float angularAccelerationZ;
    private float frontWheelsAngle;

    public PacketMotionData() {
    }

    public List<CarMotionData> getCarMotionDataList() {
        return carMotionDataList;
    }

    public void setCarMotionDataList(List<CarMotionData> carMotionDataList) {
        this.carMotionDataList = carMotionDataList;
    }

    public WheelData<Float> getSuspensionPosition() {
        return suspensionPosition;
    }

    public void setSuspensionPosition(WheelData<Float> suspensionPosition) {
        this.suspensionPosition = suspensionPosition;
    }

    public WheelData<Float> getSuspensionVelocity() {
        return suspensionVelocity;
    }

    public void setSuspensionVelocity(WheelData<Float> suspensionVelocity) {
        this.suspensionVelocity = suspensionVelocity;
    }

    public WheelData<Float> getSuspensionAcceleration() {
        return suspensionAcceleration;
    }

    public void setSuspensionAcceleration(WheelData<Float> suspensionAcceleration) {
        this.suspensionAcceleration = suspensionAcceleration;
    }

    public WheelData<Float> getWheelSpeed() {
        return wheelSpeed;
    }

    public void setWheelSpeed(WheelData<Float> wheelSpeed) {
        this.wheelSpeed = wheelSpeed;
    }

    public WheelData<Float> getWheelSlip() {
        return wheelSlip;
    }

    public void setWheelSlip(WheelData<Float> wheelSlip) {
        this.wheelSlip = wheelSlip;
    }

    public float getLocalVelocityX() {
        return localVelocityX;
    }

    public void setLocalVelocityX(float localVelocityX) {
        this.localVelocityX = localVelocityX;
    }

    public float getLocalVelocityY() {
        return localVelocityY;
    }

    public void setLocalVelocityY(float localVelocityY) {
        this.localVelocityY = localVelocityY;
    }

    public float getLocalVelocityZ() {
        return localVelocityZ;
    }

    public void setLocalVelocityZ(float localVelocityZ) {
        this.localVelocityZ = localVelocityZ;
    }

    public float getAngularVelocityX() {
        return angularVelocityX;
    }

    public void setAngularVelocityX(float angularVelocityX) {
        this.angularVelocityX = angularVelocityX;
    }

    public float getAngularVelocityY() {
        return angularVelocityY;
    }

    public void setAngularVelocityY(float angularVelocityY) {
        this.angularVelocityY = angularVelocityY;
    }

    public float getAngularVelocityZ() {
        return angularVelocityZ;
    }

    public void setAngularVelocityZ(float angularVelocityZ) {
        this.angularVelocityZ = angularVelocityZ;
    }

    public float getAngularAccelerationX() {
        return angularAccelerationX;
    }

    public void setAngularAccelerationX(float angularAccelerationX) {
        this.angularAccelerationX = angularAccelerationX;
    }

    public float getAngularAccelerationY() {
        return angularAccelerationY;
    }

    public void setAngularAccelerationY(float angularAccelerationY) {
        this.angularAccelerationY = angularAccelerationY;
    }

    public float getAngularAccelerationZ() {
        return angularAccelerationZ;
    }

    public void setAngularAccelerationZ(float angularAccelerationZ) {
        this.angularAccelerationZ = angularAccelerationZ;
    }

    public float getFrontWheelsAngle() {
        return frontWheelsAngle;
    }

    public void setFrontWheelsAngle(float frontWheelsAngle) {
        this.frontWheelsAngle = frontWheelsAngle;
    }
    
    @Override
    /**
     * all instantaneous data, just save to database
     */
    public PacketList[] saveToDB(PacketList[] histPacketLists, DSLContext dbContext, HashMap<String, Short> nameIdMap) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        System.out.println("Not implemented yet for Motion Pakcet.");
        int playerIndex = getHeader().getPlayerCarIndex();
        CarMotionData motionData = carMotionDataList.get(playerIndex);
        Motiondata T = Tables.MOTIONDATA;   // abrv. for the table MotionData
        dbContext.insertInto(T, T.SESSIONID, T.SESSIONTIME, 
                T.WORLDVELOCITYX, T.WORLDVELOCITYY, T.WORLDVELOCITYZ,
                T.GFORCELATERAL, T.GFORCELONGITUDINAL, T.GFORCEVERTICAL,
                T.YAW, T.PITCH, T.ROLL,
                T.SUSPENSIONPOSITIONRL, 
                T.SUSPENSIONPOSITIONRR, 
                T.SUSPENSIONPOSITIONFL,
                T.SUSPENSIONPOSITIONFR,
                T.SUSPENSIONVELOCITYRL,
                T.SUSPENSIONVELOCITYRR,
                T.SUSPENSIONVELOCITYFL,
                T.SUSPENSIONVELOCITYFR,
                T.SUSPENSIONACCELERATIONRL,
                T.SUSPENSIONACCELERATIONRR,
                T.SUSPENSIONACCELERATIONFL,
                T.SUSPENSIONACCELERATIONFR,
                T.WHEELSLIPRL, T.WHEELSLIPRR, T.WHEELSLIPFL, T.WHEELSLIPFR,
                T.FRONTWHEELSANGLE)
                .values(getHeader().getSessionUID().longValue(), 
                        (double)getHeader().getSessionTime(), 
                        (double)motionData.getWorldVelocityX(),
                        (double)motionData.getWorldVelocityY(),
                        (double)motionData.getWorldVelocityZ(),
                        (double)motionData.getgForceLateral(),
                        (double)motionData.getgForceLongitudinal(),
                        (double)motionData.getgForceVertical(),
                        (double)motionData.getYaw(),
                        (double)motionData.getPitch(),
                        (double)motionData.getRoll(),
                        suspensionPosition.getRearLeft().doubleValue(),
                        suspensionPosition.getRearRight().doubleValue(),
                        suspensionPosition.getFrontLeft().doubleValue(),
                        suspensionPosition.getFrontRight().doubleValue(),
                        suspensionVelocity.getRearLeft().doubleValue(),
                        suspensionVelocity.getRearRight().doubleValue(),
                        suspensionVelocity.getFrontLeft().doubleValue(),
                        suspensionVelocity.getFrontRight().doubleValue(),
                        suspensionAcceleration.getRearLeft().doubleValue(),
                        suspensionAcceleration.getRearRight().doubleValue(),
                        suspensionAcceleration.getFrontLeft().doubleValue(),
                        suspensionAcceleration.getFrontRight().doubleValue(),
                        wheelSlip.getRearLeft().doubleValue(),
                        wheelSlip.getRearRight().doubleValue(),
                        wheelSlip.getFrontLeft().doubleValue(),
                        wheelSlip.getFrontRight().doubleValue(),
                        frontWheelsAngle)
                .execute();

        return histPacketLists;     // do not add MotionPacket into the list
    }

}
