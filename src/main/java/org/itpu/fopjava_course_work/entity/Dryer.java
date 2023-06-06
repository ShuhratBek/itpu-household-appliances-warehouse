package org.itpu.fopjava_course_work.entity;

import java.util.Objects;

public class Dryer extends Appliance<Dryer> implements CapacityAware<Dryer>, PowerConsumable<Dryer>, BoilTimeProvider<Dryer>, MaterialProvider<Dryer> {
    private String material;
    private double boilTime;
    private int powerConsumption;
    private double capacity;

    @Override
    public double getBoilTime() {
        return boilTime;
    }

    @Override
    public Dryer setBoilTime(double boilTime) {
        this.boilTime = boilTime;
        return this;
    }

    @Override
    public double getCapacity() {
        return capacity;
    }

    @Override
    public Dryer setCapacity(double capacity) {
        this.capacity = capacity;
        return this;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public Dryer setMaterial(String material) {
        this.material = material;
        return this;
    }

    @Override
    public int getPowerConsumption() {
        return powerConsumption;
    }

    @Override
    public Dryer setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(material, boilTime, powerConsumption, capacity);
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
        Dryer other = (Dryer) obj;
        return Objects.equals(material, other.material)
                && Double.doubleToLongBits(boilTime) == Double.doubleToLongBits(other.boilTime)
                && powerConsumption == other.powerConsumption
                && capacity == other.capacity;
    }

    @Override
    public String toString() {
        return "Dryer [material=" + material
                + ", boilTime=" + boilTime
                + ", powerConsumption=" + powerConsumption
                + ", capacity=" + capacity
                + super.toString() + "]";
    }
}
