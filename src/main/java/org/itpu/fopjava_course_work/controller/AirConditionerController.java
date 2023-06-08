package org.itpu.fopjava_course_work.controller;

import org.itpu.fopjava_course_work.criteria.AirConditionerSearchCriteria;
import org.itpu.fopjava_course_work.criteria.SearchCriteria;
import org.itpu.fopjava_course_work.entity.AirConditioner;
import org.itpu.fopjava_course_work.service.ApplianceService;

public class AirConditionerController extends AbstractController<AirConditioner> {
    public AirConditionerController(ApplianceService applianceService) {
        super(applianceService);
    }

    @Override
    protected SearchCriteria<AirConditioner> createCriteria() {
        return new AirConditionerSearchCriteria();
    }
}