package org.itpu.fopjava_course_work.dao;

import org.itpu.fopjava_course_work.entity.Appliance;

public interface RecordBuilder<A extends Appliance<A>> {
    A build(String[] fields);
}
