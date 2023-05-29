package org.itpu.fopjava_course_work.entity;

import java.util.Objects;

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
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(coolingCapacity, heatingCapacity, powerConsumption, noiseLevel, energyEfficiencyRating);
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
        AirConditioner other = (AirConditioner) obj;
        return coolingCapacity == other.coolingCapacity
                && heatingCapacity == other.heatingCapacity
                && powerConsumption == other.powerConsumption
                && noiseLevel == other.noiseLevel
                && Objects.equals(energyEfficiencyRating, other.energyEfficiencyRating);
    }

    @Override
    public String toString() {
        return "AirConditioner [coolingCapacity=" + coolingCapacity
                + ", heatingCapacity=" + heatingCapacity
                + ", powerConsumption=" + powerConsumption
                + ", noiseLevel=" + noiseLevel
                + ", energyEfficiencyRating=" + energyEfficiencyRating
                + super.toString() + "]";
    }
}
