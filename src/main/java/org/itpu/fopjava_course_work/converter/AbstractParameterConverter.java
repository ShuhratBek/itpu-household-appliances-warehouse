package org.itpu.fopjava_course_work.converter;

import org.itpu.fopjava_course_work.parameter.Parameter;
import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.exception.ParameterConversionException;

public abstract class AbstractParameterConverter<A extends Appliance<A>>
        implements ParameterConverter<A> {
    private final String parameterName;

    protected AbstractParameterConverter(String parameterName) {
        this.parameterName = parameterName;
    }

    @Override
    public Parameter<A> convert(String request) {
        return internalConvert(request);
    }

    protected abstract Parameter<A> internalConvert(String request)
            throws ParameterConversionException;

    @Override
    public String parameterName() {
        return parameterName;
    }
}