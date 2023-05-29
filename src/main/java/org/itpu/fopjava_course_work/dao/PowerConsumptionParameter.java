package org.itpu.fopjava_course_work.dao;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.entity.PowerConsumable;
import org.itpu.fopjava_course_work.exception.InvalidParameterArguments;

public record PowerConsumptionParameter<A extends
        Appliance<A> & PowerConsumable<A>>(int targetPowerConsumption)
        implements Parameter<A> {
    public PowerConsumptionParameter {
        if (targetPowerConsumption <= 0) {
            throw new InvalidParameterArguments("Power consumption can not be less or equal to 0");
        }
    }

    @Override
    public boolean test(A appliance) {
        return appliance != null && appliance.getPowerConsumption() ==
                targetPowerConsumption;
    }
}