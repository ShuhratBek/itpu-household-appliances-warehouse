package org.itpu.fopjava_course_work.entity;

public interface SteamTimeProvider<SELF> {
    int getSteamTime();

    SELF setSteamTime(int steamTime);
}
