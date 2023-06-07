package org.itpu.fopjava_course_work.criteria;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.validators.FieldValidator;

public interface SearchCriteria<A extends Appliance<A>> {
    Class<A> getApplianceType();
    SearchCriteria<A> add(Class<A> clazz, FieldValidator fieldValidator);
    boolean test(A appliance);
}