package org.itpu.fopjava_course_work.parameter;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.exception.InvalidParameterArguments;

public record TypeParameter<A extends Appliance<A>>(String type) implements Parameter<A> {
    public TypeParameter {
        if (type == null || type.isEmpty()) {
            throw new InvalidParameterArguments("Type parameter cannot be null or empty");
        }
    }

    @Override
    public boolean test(A appliance) {
        return appliance != null && type.equals(appliance.getType());
    }
}