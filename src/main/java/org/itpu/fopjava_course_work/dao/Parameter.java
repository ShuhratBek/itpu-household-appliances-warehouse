package org.itpu.fopjava_course_work.dao;

import org.itpu.fopjava_course_work.entity.Appliance;

public interface Parameter<A extends Appliance<A>> {
    boolean test(A appliance);
}