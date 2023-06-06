package org.itpu.fopjava_course_work.dao;

import org.itpu.fopjava_course_work.criteria.SearchCriteria;
import org.itpu.fopjava_course_work.entity.Appliance;

import java.util.Collection;

public interface ApplianceDAO<A extends Appliance<A>> {
    Collection<A> find(SearchCriteria<A> criteria);
}