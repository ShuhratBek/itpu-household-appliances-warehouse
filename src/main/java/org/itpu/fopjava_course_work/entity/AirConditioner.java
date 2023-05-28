package org.itpu.fopjava_course_work.entity;

public class AirConditioner extends Appliance<AirConditioner> implements CoolingCapable<AirConditioner>, HeatingCapable<AirConditioner>, PowerConsumable<AirConditioner>, NoiseLevelAware<AirConditioner>, EnergyEfficiencyRatable<AirConditioner> {

    int coolingCapacity;
    int heatingCapacity;
    int powerConsumption;
    int noiseLevel;
    String energyEfficiencyRating;

    /**
     * @return
     */
    @Override
    public int getCoolingCapacity() {
        return coolingCapacity;
    }

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

    public AirConditioner setEnergyEfficiencyRating(String energyEfficiencyRating) {
        this.energyEfficiencyRating = energyEfficiencyRating;
        return this;
    }
}
