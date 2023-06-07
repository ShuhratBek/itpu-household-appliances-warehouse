package org.itpu.fopjava_course_work.controller;

import org.itpu.fopjava_course_work.criteria.ClothesSteamerSearchCriteria;
import org.itpu.fopjava_course_work.criteria.SearchCriteria;
import org.itpu.fopjava_course_work.entity.ClothesSteamer;
import org.itpu.fopjava_course_work.service.ApplianceService;

public class ClothesSteamerController extends ConcreteController<ClothesSteamer> {

    public ClothesSteamerController(ApplianceService applianceService) {
        super(applianceService);
    }


    @Override
    protected SearchCriteria<ClothesSteamer> createCriteria() {
        return new ClothesSteamerSearchCriteria();
    }
}