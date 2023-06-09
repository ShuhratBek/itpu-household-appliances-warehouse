package org.itpu.fopjava_course_work.controller;

import org.itpu.fopjava_course_work.criteria.DishwasherSearchCriteria;
import org.itpu.fopjava_course_work.criteria.SearchCriteria;
import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.service.ApplianceService;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DishwasherControllerTest {
    ApplianceService service = new ApplianceService() {
        @Override
        public <T extends Appliance<T>> Collection<T> find(SearchCriteria<T> criteria) {
            return null;
        }
    };

    @Test
    void shouldCreateCriteria() {
        DishwasherController controller = new DishwasherController(service);

        DishwasherSearchCriteria criteria = (DishwasherSearchCriteria) controller.createCriteria();
        assertEquals("DishwasherSearchCriteria", criteria.getClass().getSimpleName());
    }
}
