package org.itpu.fopjava_course_work.criteria;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.validators.FieldValidator;

public interface SearchCriteria<T extends Appliance<T>> {
    Class<T> getApplianceType();
    SearchCriteria<T> add(Class<T> clazz, FieldValidator fieldValidator);
    boolean test(T appliance);
}