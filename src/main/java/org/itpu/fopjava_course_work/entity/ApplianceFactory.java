package org.itpu.fopjava_course_work.entity;

public interface ApplianceFactory<T extends Appliance<?>> {
    T createInstance();
}