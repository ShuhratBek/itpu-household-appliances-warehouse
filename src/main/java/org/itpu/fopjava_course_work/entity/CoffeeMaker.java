package org.itpu.fopjava_course_work.entity;

public class CoffeeMaker extends Appliance<CoffeeMaker> implements CapacityOfCupAware<CoffeeMaker>, PowerConsumable<CoffeeMaker> {
    private int capacity;
    private int powerConsumption;
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
    public CoffeeMaker setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
        return this;
    }

    /**
     * @return
     */
    @Override
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity
     * @return
     */
    @Override
    public CoffeeMaker setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    @Override
    public String toString() {
        return "CoffeeMaker{" + String.join(", ", commonFields(), "powerConsumption=" + powerConsumption, "capacity=" + capacity) + "}";
    }
}
