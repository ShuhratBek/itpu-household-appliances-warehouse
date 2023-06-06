package org.itpu.fopjava_course_work.parameter;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.exception.InvalidParameterArguments;
public record ColorParameter<A extends Appliance<A>>(String color) implements Parameter<A> {
    public ColorParameter {
        if (color == null || color.isEmpty()) {
            throw new InvalidParameterArguments("Color parameter cannot be null or empty");
        }
    }

    @Override
    public boolean test(A appliance) {
        return appliance != null && color.equals(appliance.getColor());
    }
}