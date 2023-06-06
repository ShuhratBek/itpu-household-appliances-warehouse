package org.itpu.fopjava_course_work.parameter;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.exception.InvalidParameterArguments;

public record DepthParameter<A extends Appliance<A>>(double depth) implements Parameter<A> {
    public DepthParameter {
        if (depth <= 0) {
            throw new InvalidParameterArguments("Depth parameter must be a positive value");
        }
    }

    @Override
    public boolean test(A appliance) {
        return appliance != null && depth == appliance.getDepth();
    }
}