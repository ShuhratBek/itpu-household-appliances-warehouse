package org.itpu.fopjava_course_work.entity;

public interface CapacityAware<SELF> {
    double getCapacity();

    SELF setCapacity(double capacity);
}
