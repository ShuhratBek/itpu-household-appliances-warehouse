package org.itpu.fopjava_course_work.entity;

import java.util.Objects;

public class ElectricKettle extends Appliance<ElectricKettle> implements MaterialProvider<ElectricKettle>, CapacityAware<ElectricKettle>, PowerConsumable<ElectricKettle> {
    private double capacity;
    private String material;
    private int powerConsumption;
    /**
     * @return
     */
    @Override
    public double getCapacity() {
        return capacity;
    }

    /**
     * @param capacity
     * @return
     */
    @Override
    public ElectricKettle setCapacity(double capacity) {
        this.capacity = capacity;
        return this;
    }

    /**
     * @return
     */
    @Override
    public String getMaterial() {
        return material;
    }

    /**
     * @param material
     * @return
     */
    @Override
    public ElectricKettle setMaterial(String material) {
        this.material = material;
        return this;
    }

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
    public ElectricKettle setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(capacity, material, powerConsumption);
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
        ElectricKettle other = (ElectricKettle) obj;
        return capacity == other.capacity
                && Objects.equals(material, other.material)
                && powerConsumption == other.powerConsumption;
    }

    @Override
    public String toString() {
        return "Dryer [capacity=" + capacity
                + ", material=" + material
                + ", powerConsumption=" + powerConsumption
                + super.toString() + "]";
    }
}
