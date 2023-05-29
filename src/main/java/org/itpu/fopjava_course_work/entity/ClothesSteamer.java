package org.itpu.fopjava_course_work.entity;

import java.util.Objects;

public class ClothesSteamer extends Appliance<ClothesSteamer> implements PowerConsumable<ClothesSteamer>, WaterTankCapable<ClothesSteamer>, SteamTimeProvider<ClothesSteamer> {
    private int powerConsumption;
    private double waterTankCapacity;
    private int steamTime;

    /**
     * @return
     */
    @Override
    public int getPowerConsumption() {
        return powerConsumption;
    }

    /**
     * @param powerConsumption
     * @return
     */
    @Override
    public ClothesSteamer setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
        return this;
    }

    /**
     * @return
     */
    @Override
    public double getWaterTankCapacity() {
        return waterTankCapacity;
    }

    /**
     * @param waterTankCapacity
     * @return
     */
    @Override
    public ClothesSteamer setWaterTankCapacity(double waterTankCapacity) {
        this.waterTankCapacity = waterTankCapacity;
        return this;
    }

    /**
     * @return
     */
    @Override
    public int getSteamTime() {
        return steamTime;
    }

    /**
     * @param steamTime
     * @return
     */
    @Override
    public ClothesSteamer setSteamTime(int steamTime) {
        this.steamTime = steamTime;
        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(powerConsumption, waterTankCapacity, steamTime);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        ClothesSteamer other = (ClothesSteamer) obj;
        return powerConsumption == other.powerConsumption
                && Double.doubleToLongBits(waterTankCapacity) == Double.doubleToLongBits(other.waterTankCapacity)
                && steamTime == other.steamTime;
    }

    @Override
    public String toString() {
        return "ClothesSteamer [powerConsumption=" + powerConsumption
                + ", waterTankCapacity=" + waterTankCapacity
                + ", steamTime=" + steamTime
                + super.toString() + "]";
    }
}
