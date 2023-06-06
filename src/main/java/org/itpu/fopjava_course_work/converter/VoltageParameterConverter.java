package org.itpu.fopjava_course_work.converter;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.exception.ParameterConversionException;
import org.itpu.fopjava_course_work.parameter.Parameter;
import org.itpu.fopjava_course_work.parameter.VoltageParameter;

public class VoltageParameterConverter<A extends Appliance<A>> extends AbstractParameterConverter<A> {
    public VoltageParameterConverter() {
        super("voltage");
    }
    @Override
    protected Parameter<A> internalConvert(String request) throws ParameterConversionException {
        if (request == null || request.isEmpty()) {
            throw new ParameterConversionException("Invalid voltage parameter: " + request);
        }
        return new VoltageParameter<>(request);
    }
}