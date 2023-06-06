package org.itpu.fopjava_course_work.entity;

import java.util.Objects;

public class Blender extends Appliance<Blender> implements PowerConsumable<Blender>, SpeedAdjustable<Blender>, CapacityAware<Blender> {

    int powerConsumption;
    int speedSettings;
    double capacity;

    @Override
    public int getPowerConsumption() {
        return powerConsumption;
    }

    public Blender setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
        return this;
    }

    @Override
    public int getSpeedSettings() {
        return speedSettings;
    }

    @Override
    public Blender setSpeedSettings(int speedSettings) {
        this.speedSettings = speedSettings;
        return this;
    }

    @Override
    public double getCapacity() {
        return capacity;
    }

    @Override
    public Blender setCapacity(double capacity) {
        this.capacity = capacity;
        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(powerConsumption, speedSettings, capacity);
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
        Blender other = (Blender) obj;
        return powerConsumption == other.powerConsumption
                && speedSettings == other.speedSettings
                && Double.doubleToLongBits(capacity) == Double.doubleToLongBits(other.powerConsumption);
    }

    @Override
    public String toString() {
        return "Blender [powerConsumption=" + powerConsumption
                + ", speedSettings=" + speedSettings
                + ", capacity=" + capacity
                + super.toString() + "]";
    }
}
