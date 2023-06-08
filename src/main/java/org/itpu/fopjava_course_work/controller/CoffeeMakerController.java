package org.itpu.fopjava_course_work.controller;

import org.itpu.fopjava_course_work.criteria.CoffeeMakerSearchCriteria;
import org.itpu.fopjava_course_work.criteria.SearchCriteria;
import org.itpu.fopjava_course_work.entity.CoffeeMaker;
import org.itpu.fopjava_course_work.service.ApplianceService;

public class CoffeeMakerController extends AbstractController<CoffeeMaker> {

    public CoffeeMakerController(ApplianceService applianceService) {
        super(applianceService);
    }

    @Override
    protected SearchCriteria<CoffeeMaker> createCriteria() {
        return new CoffeeMakerSearchCriteria();
    }
}