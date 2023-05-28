package org.itpu.fopjava_course_work.entity;

public class Dryer extends Appliance<Dryer> implements CapacityAware<Dryer>, PowerConsumable<Dryer>, BoilTimeProvider<Dryer>, MaterialProvider<Dryer> {
    private String material;
    private double boilTime;
    private int powerConsumption;
    private double capacity;

    /**
     * @return
     */
    @Override
    public double getBoilTime() {
        return boilTime;
    }

    /**
     * @param boilTime
     * @return
     */
    @Override
    public Dryer setBoilTime(double boilTime) {
        this.boilTime = boilTime;
        return this;
    }

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
    public Dryer setCapacity(double capacity) {
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
    public Dryer setMaterial(String material) {
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
    public Dryer setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
        return this;
    }
    @Override
    public String toString() {
        return "Dryer{" + String.join(", ", commonFields(), "material=" + material, "boilTime=" + boilTime, "powerConsumption=" + powerConsumption, "capacity=" + capacity) + "}";
    }
}
