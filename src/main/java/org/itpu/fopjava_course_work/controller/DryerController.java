package org.itpu.fopjava_course_work.controller;

import org.itpu.fopjava_course_work.criteria.DryerSearchCriteria;
import org.itpu.fopjava_course_work.criteria.SearchCriteria;
import org.itpu.fopjava_course_work.entity.Dryer;
import org.itpu.fopjava_course_work.service.ApplianceService;

public class DryerController extends ConcreteController<Dryer> {

    public DryerController(ApplianceService applianceService) {
        super(applianceService);
    }

    @Override
    protected SearchCriteria<Dryer> createCriteria() {
        return new DryerSearchCriteria();
    }
}