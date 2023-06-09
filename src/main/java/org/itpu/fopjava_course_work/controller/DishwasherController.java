package org.itpu.fopjava_course_work.controller;

import org.itpu.fopjava_course_work.criteria.DishwasherSearchCriteria;
import org.itpu.fopjava_course_work.criteria.SearchCriteria;
import org.itpu.fopjava_course_work.entity.Dishwasher;
import org.itpu.fopjava_course_work.service.ApplianceService;

public class DishwasherController extends AbstractController<Dishwasher> {

    public DishwasherController(ApplianceService applianceService) {
        super(applianceService);
    }

    @Override
    protected SearchCriteria<Dishwasher> createCriteria() {
        return new DishwasherSearchCriteria();
    }
}