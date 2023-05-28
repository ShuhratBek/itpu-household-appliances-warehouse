package org.itpu.fopjava_course_work.entity;

public class Blender extends Appliance<Blender> implements PowerConsumable<Blender>, SpeedAdjustable<Blender>, CapacityAware<Blender> {

    int powerConsumption;
    int speedSettings;
    double capacity;

    /**
     * @return
     */
    @Override
    public int getPowerConsumption() {
        return powerConsumption;
    }

    public Blender setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
        return this;
    }

    /**
     * @return
     */
    @Override
    public int getSpeedSettings() {
        return speedSettings;
    }

    /**
     * @param speedSettings
     * @return
     */
    @Override
    public Blender setSpeedSettings(int speedSettings) {
        this.speedSettings = speedSettings;
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
    public Blender setCapacity(double capacity) {
        this.capacity = capacity;
        return this;
    }

    @Override
    public String toString() {
        return "Blender{" + String.join(", ", commonFields(), "powerConsumption=" + powerConsumption, "speedSettings=" + speedSettings, "capacity=" + capacity) + "}";
    }
}
