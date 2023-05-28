package org.itpu.fopjava_course_work.entity;

public interface HeatingCapable<SELF> {
    int getHeatingCapacity();

    SELF setHeatingCapacity(int heatingCapacity);
}
