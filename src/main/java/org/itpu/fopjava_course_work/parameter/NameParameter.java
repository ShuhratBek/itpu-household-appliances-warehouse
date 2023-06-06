package org.itpu.fopjava_course_work.parameter;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.exception.InvalidParameterArguments;

public record NameParameter<A extends Appliance<A>>(String name) implements Parameter<A> {
    public NameParameter {
        if (name == null || name.isEmpty()) {
            throw new InvalidParameterArguments("Name parameter cannot be null or empty");
        }
    }

    @Override
    public boolean test(A appliance) {
        return appliance != null && name.equals(appliance.getName());
    }
}