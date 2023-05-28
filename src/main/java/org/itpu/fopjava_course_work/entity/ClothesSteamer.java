package org.itpu.fopjava_course_work.entity;

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
}
