package org.itpu.fopjava_course_work.entity;

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
}
