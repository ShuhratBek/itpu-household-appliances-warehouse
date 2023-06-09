package org.itpu.fopjava_course_work.controller;

import org.itpu.fopjava_course_work.criteria.ElectricKettleSearchCriteria;
import org.itpu.fopjava_course_work.criteria.SearchCriteria;
import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.service.ApplianceService;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElectricKettleControllerTest {
    ApplianceService service = new ApplianceService() {
        @Override
        public <T extends Appliance<T>> Collection<T> find(SearchCriteria<T> criteria) {
            return null;
        }
    };

    @Test
    void shouldCreateCriteria() {
        ElectricKettleController controller = new ElectricKettleController(service);

        ElectricKettleSearchCriteria criteria = (ElectricKettleSearchCriteria) controller.createCriteria();
        assertEquals("ElectricKettleSearchCriteria", criteria.getClass().getSimpleName());
    }
}
