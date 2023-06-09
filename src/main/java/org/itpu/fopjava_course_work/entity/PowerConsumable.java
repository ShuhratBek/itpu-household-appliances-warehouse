package org.itpu.fopjava_course_work.entity;

public interface PowerConsumable<SELF> {
    int getPowerConsumption();

    SELF setPowerConsumption(int powerConsumption);
}