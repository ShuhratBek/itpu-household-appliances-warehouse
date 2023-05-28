package org.itpu.fopjava_course_work.entity;

public class AirConditioner extends Appliance<AirConditioner> implements CoolingCapable<AirConditioner>, HeatingCapable<AirConditioner>, PowerConsumable<AirConditioner>, NoiseLevelAware<AirConditioner>, EnergyEfficiencyRatable<AirConditioner> {

    private int coolingCapacity;
    private int heatingCapacity;
    private int powerConsumption;
    private int noiseLevel;
    private String energyEfficiencyRating;

    /**
     * @return
     */
    @Override
    public int getCoolingCapacity() {
        return coolingCapacity;
    }

    @Override
    public AirConditioner setCoolingCapacity(int coolingCapacity) {
        this.coolingCapacity = coolingCapacity;
        return this;
    }

    /**
     * @return
     */
    @Override
    public int getHeatingCapacity() {
        return heatingCapacity;
    }

    @Override
    public AirConditioner setHeatingCapacity(int heatingCapacity) {
        this.heatingCapacity = heatingCapacity;
        return this;
    }

    /**
     * @return
     */
    @Override
    public int getPowerConsumption() {
        return powerConsumption;
    }

    @Override
    public AirConditioner setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
        return this;
    }

    /**
     * @return
     */
    @Override
    public int getNoiseLevel() {
        return noiseLevel;
    }

    @Override
    public AirConditioner setNoiseLevel(int noiseLevel) {
        this.noiseLevel = noiseLevel;
        return this;
    }

    /**
     * @return
     */
    @Override
    public String getEnergyEfficiencyRating() {
        return energyEfficiencyRating;
    }

    @Override
    public AirConditioner setEnergyEfficiencyRating(String energyEfficiencyRating) {
        this.energyEfficiencyRating = energyEfficiencyRating;
        return this;
    }

    @Override
    public String toString() {
        return "AirConditioner{" + String.join(", ", commonFields(), "coolingCapacity=" + coolingCapacity, "heatingCapacity=" + heatingCapacity, "powerConsumption=" + powerConsumption, "noiseLevel=" + noiseLevel, "energyEfficiencyRating=" + energyEfficiencyRating) + "}";
    }
}
