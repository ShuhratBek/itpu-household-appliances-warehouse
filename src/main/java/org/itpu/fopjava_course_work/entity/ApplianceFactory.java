package org.itpu.fopjava_course_work.entity;

public interface ApplianceFactory<A extends Appliance<?>> {
    A createInstance();
}