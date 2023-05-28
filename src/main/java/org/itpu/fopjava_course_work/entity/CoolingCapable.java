package org.itpu.fopjava_course_work.entity;

public interface CoolingCapable<SELF> {
    int getCoolingCapacity();

    SELF setCoolingCapacity(int coolingCapacity);
}
