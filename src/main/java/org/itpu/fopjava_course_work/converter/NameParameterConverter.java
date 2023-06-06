package org.itpu.fopjava_course_work.converter;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.exception.ParameterConversionException;
import org.itpu.fopjava_course_work.parameter.NameParameter;
import org.itpu.fopjava_course_work.parameter.Parameter;

public class NameParameterConverter<A extends Appliance<A>> extends AbstractParameterConverter<A> {
    public NameParameterConverter() {
        super("name");
    }
    @Override
    protected Parameter<A> internalConvert(String request) throws ParameterConversionException {
        if (request == null || request.isEmpty()) {
            throw new ParameterConversionException("Invalid name parameter: " + request);
        }
        return new NameParameter<>(request);
    }
}