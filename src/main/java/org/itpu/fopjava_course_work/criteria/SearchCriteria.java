package org.itpu.fopjava_course_work.criteria;

import org.itpu.fopjava_course_work.dao.Parameter;
import org.itpu.fopjava_course_work.entity.Appliance;

public interface SearchCriteria<A extends Appliance<A>> {
    Class<A> getApplianceType();
    <P extends Parameter<A>> SearchCriteria<A> add(P parameter);
    boolean test(A appliance);
}