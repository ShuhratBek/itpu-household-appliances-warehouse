package org.itpu.fopjava_course_work.controller;

import org.itpu.fopjava_course_work.criteria.BlenderSearchCriteria;
import org.itpu.fopjava_course_work.criteria.SearchCriteria;
import org.itpu.fopjava_course_work.entity.Blender;
import org.itpu.fopjava_course_work.service.ApplianceService;

public class BlenderController extends AbstractController<Blender> {

    public BlenderController(ApplianceService applianceService) {
        super(applianceService);
    }

    @Override
    protected SearchCriteria<Blender> createCriteria() {
        return new BlenderSearchCriteria();
    }
}