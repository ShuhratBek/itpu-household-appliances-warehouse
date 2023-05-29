package org.itpu.fopjava_course_work.entity;

import java.util.Objects;

public class Dishwasher extends Appliance<Dishwasher> implements PlaceSettingProvider<Dishwasher>, EnergyEfficiencyRatable<Dishwasher>, WashingProgramProvider<Dishwasher> {
    private String energyEfficiencyRating;
    private int placeSettings;
    private int washingPrograms;
    /**
     * @return
     */
    @Override
    public String getEnergyEfficiencyRating() {
        return energyEfficiencyRating;
    }

    /**
     * @param energyEfficiencyRating
     * @return
     */
    @Override
    public Dishwasher setEnergyEfficiencyRating(String energyEfficiencyRating) {
        this.energyEfficiencyRating = energyEfficiencyRating;
        return this;
    }

    /**
     * @return
     */
    @Override
    public int getPlaceSettings() {
        return placeSettings;
    }

    /**
     * @param placeSettings
     * @return
     */
    @Override
    public Dishwasher setPlaceSettings(int placeSettings) {
        this.placeSettings = placeSettings;
        return this;
    }

    /**
     * @return
     */
    @Override
    public int getWashingPrograms() {
        return washingPrograms;
    }

    /**
     * @param washingPrograms
     * @return
     */
    @Override
    public Dishwasher setWashingPrograms(int washingPrograms) {
        this.washingPrograms = washingPrograms;
        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(energyEfficiencyRating, placeSettings, washingPrograms);
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
        Dishwasher other = (Dishwasher) obj;
        return Objects.equals(energyEfficiencyRating, other.energyEfficiencyRating)
                && placeSettings == other.placeSettings
                && washingPrograms == other.washingPrograms;
    }

    @Override
    public String toString() {
        return "Dishwasher [energyEfficiencyRating=" + energyEfficiencyRating
                + ", placeSettings=" + placeSettings
                + ", washingPrograms=" + washingPrograms
                + super.toString() + "]";
    }
}
