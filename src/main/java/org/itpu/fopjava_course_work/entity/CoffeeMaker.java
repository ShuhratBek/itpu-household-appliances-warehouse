package org.itpu.fopjava_course_work.entity;

import java.util.Objects;

public class CoffeeMaker extends Appliance<CoffeeMaker> implements CapacityOfCupAware<CoffeeMaker>, PowerConsumable<CoffeeMaker> {
    private int capacityOfCup;
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
    public int getCapacityOfCup() {
        return capacityOfCup;
    }

    /**
     * @param capacityOfCup
     * @return
     */
    @Override
    public CoffeeMaker setCapacityOfCup(int capacityOfCup) {
        this.capacityOfCup = capacityOfCup;
        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(powerConsumption, capacityOfCup);
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
        CoffeeMaker other = (CoffeeMaker) obj;
        return powerConsumption == other.powerConsumption
                && capacityOfCup == other.capacityOfCup;
    }

    @Override
    public String toString() {
        return "CoffeeMaker [powerConsumption=" + powerConsumption
                + ", capacityOfCup=" + capacityOfCup
                + super.toString() + "]";
    }
}
