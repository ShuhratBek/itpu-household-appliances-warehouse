package org.itpu.fopjava_course_work.controller;

import org.itpu.fopjava_course_work.criteria.AirConditionerSearchCriteria;
import org.itpu.fopjava_course_work.criteria.SearchCriteria;
import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.service.ApplianceService;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AirConditionerControllerTest {
    ApplianceService service = new ApplianceService() {
        @Override
        public <T extends Appliance<T>> Collection<T> find(SearchCriteria<T> criteria) {
            return null;
        }
    };

    @Test
    void shouldCreateCriteria() {
        AirConditionerController controller = new AirConditionerController(service);

        AirConditionerSearchCriteria criteria = (AirConditionerSearchCriteria) controller.createCriteria();
        assertEquals("AirConditionerSearchCriteria", criteria.getClass().getSimpleName());
    }
}
