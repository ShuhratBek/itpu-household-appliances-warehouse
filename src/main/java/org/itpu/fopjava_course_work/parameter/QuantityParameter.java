package org.itpu.fopjava_course_work.parameter;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.exception.InvalidParameterArguments;

public record QuantityParameter<A extends Appliance<A>>(int quantity) implements Parameter<A> {
    public QuantityParameter {
        if (quantity <= 0) {
            throw new InvalidParameterArguments("Quantity parameter must be a positive integer");
        }
    }

    @Override
    public boolean test(A appliance) {
        return appliance != null && quantity == appliance.getQuantity();
    }
}