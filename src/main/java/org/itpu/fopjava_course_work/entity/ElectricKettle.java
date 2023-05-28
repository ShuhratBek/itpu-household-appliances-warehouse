package org.itpu.fopjava_course_work.entity;

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
    public String toString() {
        return "ElectricKettle{" + String.join(", ", commonFields(), "capacity=" + capacity, "material=" + material, "powerConsumption=" + powerConsumption) + "}";
    }
}
