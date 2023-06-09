package org.itpu.fopjava_course_work.dao;

import org.itpu.fopjava_course_work.entity.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DAOFactoryTest {

    @Test
    void shouldReturnNullWhenUnknownClassIsPassed() {
        class DummyAppliance extends Appliance<DummyAppliance> {
        }
        ApplianceDAO<DummyAppliance> dao =
                DaoFactory.INSTANCE.getApplianceDAO(DummyAppliance.class);
        assertNull(dao);
    }

    @Test
    void shouldReturnAirConditionerDao() {
        ApplianceDAO<AirConditioner> dao = DaoFactory.INSTANCE.getApplianceDAO(AirConditioner.class);
        assertNotNull(dao);
        assertTrue(dao instanceof AirConditionerDAO);
    }

    @Test
    void shouldReturnBlenderDao() {
        ApplianceDAO<Blender> dao = DaoFactory.INSTANCE.getApplianceDAO(Blender.class);
        assertNotNull(dao);
        assertTrue(dao instanceof BlenderDAO);
    }

    @Test
    void shouldReturnClothesSteamerDao() {
        ApplianceDAO<ClothesSteamer> dao = DaoFactory.INSTANCE.getApplianceDAO(ClothesSteamer.class);
        assertNotNull(dao);
        assertTrue(dao instanceof ClothesSteamerDAO);
    }

    @Test
    void shouldReturnCoffeeMakerDao() {
        ApplianceDAO<CoffeeMaker> dao = DaoFactory.INSTANCE.getApplianceDAO(CoffeeMaker.class);
        assertNotNull(dao);
        assertTrue(dao instanceof CoffeeMakerDAO);
    }

    @Test
    void shouldReturnDishwasherDao() {
        ApplianceDAO<Dishwasher> dao = DaoFactory.INSTANCE.getApplianceDAO(Dishwasher.class);
        assertNotNull(dao);
        assertTrue(dao instanceof DishwasherDAO);
    }

    @Test
    void shouldReturnDryerDao() {
        ApplianceDAO<Dryer> dao = DaoFactory.INSTANCE.getApplianceDAO(Dryer.class);
        assertNotNull(dao);
        assertTrue(dao instanceof DryerDAO);
    }

    @Test
    void shouldReturnElectricKettleDao() {
        ApplianceDAO<ElectricKettle> dao = DaoFactory.INSTANCE.getApplianceDAO(ElectricKettle.class);
        assertNotNull(dao);
        assertTrue(dao instanceof ElectricKettleDAO);
    }
}
