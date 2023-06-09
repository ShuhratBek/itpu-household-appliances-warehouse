package org.itpu.fopjava_course_work.entity;

public interface WashingProgramProvider<SELF> {
    int getWashingPrograms();

    SELF setWashingPrograms(int washingPrograms);
}
