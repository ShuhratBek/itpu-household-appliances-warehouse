package org.itpu.fopjava_course_work.entity;

public interface NoiseLevelAware<SELF> {
    int getNoiseLevel();
    SELF setNoiseLevel(int noiseLevel);
}
