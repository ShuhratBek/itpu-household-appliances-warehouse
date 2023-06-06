package org.itpu.fopjava_course_work.parameter;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.exception.InvalidParameterArguments;

public record HeightParameter<A extends Appliance<A>>(double height) implements Parameter<A> {
    public HeightParameter {
        if (height <= 0) {
            throw new InvalidParameterArguments("Height parameter must be a positive value");
        }
    }

    @Override
    public boolean test(A appliance) {
        return appliance != null && height == appliance.getHeight();
    }
}