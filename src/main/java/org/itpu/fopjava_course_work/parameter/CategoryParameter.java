package org.itpu.fopjava_course_work.parameter;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.exception.InvalidParameterArguments;

public record CategoryParameter<A extends Appliance<A>>(String category) implements Parameter<A> {
    public CategoryParameter {
        if (category == null || category.isEmpty()) {
            throw new InvalidParameterArguments("Name parameter cannot be null or empty");
        }
    }

    @Override
    public boolean test(A appliance) {
        return appliance != null && category.equals(appliance.getCategory());
    }
}