package org.itpu.fopjava_course_work.dao;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.exception.InvalidParameterArguments;

public record PriceParameter<A extends Appliance<A>>(Range<Long> range)
        implements Parameter<A> {
    public PriceParameter {
        if (range.from() < 0L) {
            throw new InvalidParameterArguments("Price can't be less than 0, but was " +
                    range.from());
        }
    }

    @Override
    public boolean test(A appliance) {
        return range.isIn(appliance.getPrice());
    }
}
