package org.itpu.fopjava_course_work.entity;

public interface MaterialProvider<SELF> {
    String getMaterial();

    SELF setMaterial(String material);
}
