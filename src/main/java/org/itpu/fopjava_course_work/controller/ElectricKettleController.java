package org.itpu.fopjava_course_work.controller;

import org.itpu.fopjava_course_work.criteria.ElectricKettleSearchCriteria;
import org.itpu.fopjava_course_work.criteria.SearchCriteria;
import org.itpu.fopjava_course_work.entity.ElectricKettle;
import org.itpu.fopjava_course_work.service.ApplianceService;

public class ElectricKettleController extends AbstractController<ElectricKettle> {

    public ElectricKettleController(ApplianceService applianceService) {
        super(applianceService);
    }

    @Override
    protected SearchCriteria<ElectricKettle> createCriteria() {
        return new ElectricKettleSearchCriteria();
    }
}