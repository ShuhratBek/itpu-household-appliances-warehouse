package org.itpu.fopjava_course_work.entity;

public interface WaterTankCapable<SELF> {
    double getWaterTankCapacity();

    SELF setWaterTankCapacity(double waterTankCapacity);
}
