package org.itpu.fopjava_course_work.criteria;

import org.itpu.fopjava_course_work.entity.ClothesSteamer;

public class ClothesSteamerSearchCriteria extends AbstractCriteria<ClothesSteamer> {
    @Override
    public Class<ClothesSteamer> getApplianceType() {
        return ClothesSteamer.class;
    }
}
