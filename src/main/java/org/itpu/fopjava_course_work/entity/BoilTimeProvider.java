package org.itpu.fopjava_course_work.entity;

public interface BoilTimeProvider<SELF> {
    double getBoilTime();

    SELF setBoilTime(double boilTime);
}
