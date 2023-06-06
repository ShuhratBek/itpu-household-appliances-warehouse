package org.itpu.fopjava_course_work.controller;

import org.itpu.fopjava_course_work.criteria.SearchCriteria;
import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.service.ApplianceService;
import java.util.Collection;
import java.util.Map;

public abstract class ConcreteController<A extends Appliance<A>> {
    protected final ApplianceService applianceService;

    public ConcreteController(ApplianceService applianceService) {
        this.applianceService = applianceService;
    }

    protected abstract SearchCriteria<A> createCriteria();
    protected abstract Collection<A> findAll();
    protected abstract Collection<A> find(Map<String, String> parameters);
}
