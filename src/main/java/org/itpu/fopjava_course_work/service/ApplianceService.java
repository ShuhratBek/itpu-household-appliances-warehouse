package org.itpu.fopjava_course_work.service;

import org.itpu.fopjava_course_work.criteria.SearchCriteria;
import org.itpu.fopjava_course_work.entity.Appliance;

import java.util.Collection;

public interface ApplianceService {
    <T extends Appliance<T>> Collection<T> find(SearchCriteria<T> criteria);
}