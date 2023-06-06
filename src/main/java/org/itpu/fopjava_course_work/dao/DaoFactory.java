package org.itpu.fopjava_course_work.dao;

import org.itpu.fopjava_course_work.entity.*;

public enum DaoFactory {
    INSTANCE;

    @SuppressWarnings("unchecked")
    public <A extends Appliance<A>> ApplianceDAO<A> getApplianceDAO(Class<A> applianceClass) {
        if (AirConditioner.class.equals(applianceClass)) {
            return (ApplianceDAO<A>) new AirConditionerDAO();
        }

        if (Blender.class.equals(applianceClass)) {
            return (ApplianceDAO<A>) new BlenderDAO();
        }

        if (ClothesSteamer.class.equals(applianceClass)) {
            return (ApplianceDAO<A>) new ClothesSteamerDAO();
        }

        if (CoffeeMaker.class.equals(applianceClass)) {
            return (ApplianceDAO<A>) new CoffeeMakerDAO();
        }

        if (Dishwasher.class.equals(applianceClass)) {
            return (ApplianceDAO<A>) new DishwasherDAO();
        }

        if (Dryer.class.equals(applianceClass)) {
            return (ApplianceDAO<A>) new DryerDAO();
        }

        if (ElectricKettle.class.equals(applianceClass)) {
            return (ApplianceDAO<A>) new ElectricKettleDAO();
        }
        return null;
    }
}
