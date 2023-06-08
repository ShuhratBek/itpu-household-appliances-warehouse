package org.itpu.fopjava_course_work.dao;

import org.itpu.fopjava_course_work.entity.*;

public enum DaoFactory {
    INSTANCE;

    @SuppressWarnings("unchecked")
    public <T extends Appliance<T>> ApplianceDAO<T> getApplianceDAO(Class<T> applianceClass) {
        if (AirConditioner.class.equals(applianceClass)) {
            return (ApplianceDAO<T>) new AirConditionerDAO();
        }

        if (Blender.class.equals(applianceClass)) {
            return (ApplianceDAO<T>) new BlenderDAO();
        }

        if (ClothesSteamer.class.equals(applianceClass)) {
            return (ApplianceDAO<T>) new ClothesSteamerDAO();
        }

        if (CoffeeMaker.class.equals(applianceClass)) {
            return (ApplianceDAO<T>) new CoffeeMakerDAO();
        }

        if (Dishwasher.class.equals(applianceClass)) {
            return (ApplianceDAO<T>) new DishwasherDAO();
        }

        if (Dryer.class.equals(applianceClass)) {
            return (ApplianceDAO<T>) new DryerDAO();
        }

        if (ElectricKettle.class.equals(applianceClass)) {
            return (ApplianceDAO<T>) new ElectricKettleDAO();
        }
        return null;
    }
}
