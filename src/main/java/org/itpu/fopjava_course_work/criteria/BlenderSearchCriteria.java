package org.itpu.fopjava_course_work.criteria;

import org.itpu.fopjava_course_work.entity.Blender;

public class BlenderSearchCriteria extends AbstractCriteria<Blender> {
    @Override
    public Class<Blender> getApplianceType() {
        return Blender.class;
    }
}
