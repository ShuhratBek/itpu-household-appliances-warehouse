package org.itpu.fopjava_course_work.parameter;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.exception.InvalidParameterArguments;

public record VoltageParameter<A extends Appliance<A>>(String voltage) implements Parameter<A> {
    public VoltageParameter {
        if (voltage == null || voltage.isEmpty()) {
            throw new InvalidParameterArguments("Voltage parameter cannot be null or empty");
        }
    }

    @Override
    public boolean test(A appliance) {
        return appliance != null && voltage.equals(appliance.getVoltage());
    }
}