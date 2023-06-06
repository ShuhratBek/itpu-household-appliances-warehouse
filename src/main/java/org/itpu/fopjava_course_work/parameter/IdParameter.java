package org.itpu.fopjava_course_work.parameter;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.exception.InvalidParameterArguments;

public record IdParameter<A extends Appliance<A>>(int id) implements Parameter<A> {
    public IdParameter {
        if (id <= 0) {
            throw new InvalidParameterArguments("ID parameter must be a positive integer");
        }
    }

    @Override
    public boolean test(A appliance) {
        return appliance != null && id == appliance.getId();
    }
}