package org.itpu.fopjava_course_work.parameter;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.exception.InvalidParameterArguments;

public record BrandParameter<A extends Appliance<A>>(String brand) implements Parameter<A> {
    public BrandParameter {
        if (brand == null || brand.isEmpty()) {
            throw new InvalidParameterArguments("Brand parameter cannot be null or empty");
        }
    }

    @Override
    public boolean test(A appliance) {
        return appliance != null && brand.equals(appliance.getBrand());
    }
}