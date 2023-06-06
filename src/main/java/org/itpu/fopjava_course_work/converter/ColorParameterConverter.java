package org.itpu.fopjava_course_work.converter;

import org.itpu.fopjava_course_work.parameter.ColorParameter;
import org.itpu.fopjava_course_work.parameter.Parameter;
import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.exception.ParameterConversionException;

public class ColorParameterConverter<A extends Appliance<A>> extends AbstractParameterConverter<A> {
    public ColorParameterConverter() {
        super("color");
    }
    @Override
    protected Parameter<A> internalConvert(String request) throws ParameterConversionException {
        if (request == null || request.isEmpty()) {
            throw new ParameterConversionException("Invalid color parameter: " + request);
        }
        return new ColorParameter<>(request);
    }
}