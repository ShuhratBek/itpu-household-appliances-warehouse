package org.itpu.fopjava_course_work.criteria;

import org.itpu.fopjava_course_work.entity.CoffeeMaker;

public class CoffeeMakerSearchCriteria extends AbstractCriteria<CoffeeMaker> {
    @Override
    public Class<CoffeeMaker> getApplianceType() {
        return CoffeeMaker.class;
    }
}
