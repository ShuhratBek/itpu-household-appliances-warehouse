package org.itpu.fopjava_course_work.parameter;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.exception.InvalidParameterArguments;

public record WeightParameter<A extends Appliance<A>>(double weight) implements Parameter<A> {
    public WeightParameter {
        if (weight <= 0) {
            throw new InvalidParameterArguments("Weight parameter must be a positive value");
        }
    }

    @Override
    public boolean test(A appliance) {
        return appliance != null && weight == appliance.getWeight();
    }
}