package org.itpu.fopjava_course_work.entity;

public interface PlaceSettingProvider<SELF> {
    int getPlaceSettings();

    SELF setPlaceSettings(int placeSettings);
}
