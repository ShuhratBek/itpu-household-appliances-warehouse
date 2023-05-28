package org.itpu.fopjava_course_work.entity;

public class Refrigerator extends Appliance<Refrigerator> {
    @Override
    public String toString() {
        return "Refrigerator{" + String.join(", ", commonFields()) + "}";
    }
}
