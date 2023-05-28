package org.itpu.fopjava_course_work.entity;

public interface SpeedAdjustable<SELF> {
    int getSpeedSettings();
    SELF setSpeedSettings(int speedSettings);
}
