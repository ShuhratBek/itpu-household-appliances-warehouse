package org.itpu.fopjava_course_work.parameter;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.exception.InvalidParameterArguments;

public record ModelNameParameter<A extends Appliance<A>>(String modelName) implements Parameter<A> {
    public ModelNameParameter {
        if (modelName == null || modelName.isEmpty()) {
            throw new InvalidParameterArguments("ModelName parameter cannot be null or empty");
        }
    }

    @Override
    public boolean test(A appliance) {
        return appliance != null && modelName.equals(appliance.getModelName());
    }
}