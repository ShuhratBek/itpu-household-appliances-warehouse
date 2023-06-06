package org.itpu.fopjava_course_work.parameter;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.exception.InvalidParameterArguments;

public record WidthParameter<A extends Appliance<A>>(double width) implements Parameter<A> {
    public WidthParameter {
        if (width <= 0) {
            throw new InvalidParameterArguments("Width parameter must be a positive value");
        }
    }

    @Override
    public boolean test(A appliance) {
        return appliance != null && width == appliance.getWidth();
    }
}