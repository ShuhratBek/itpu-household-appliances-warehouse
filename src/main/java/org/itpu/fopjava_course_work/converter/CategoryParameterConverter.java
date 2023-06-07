package org.itpu.fopjava_course_work.converter;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.exception.ParameterConversionException;
import org.itpu.fopjava_course_work.parameter.CategoryParameter;
import org.itpu.fopjava_course_work.parameter.Parameter;

public class CategoryParameterConverter<A extends Appliance<A>> extends AbstractParameterConverter<A> {
    public CategoryParameterConverter() {
        super("category");
    }
    @Override
    protected Parameter<A> internalConvert(String request) throws ParameterConversionException {
        if (request == null || request.isEmpty()) {
            throw new ParameterConversionException("Invalid category parameter: " + request);
        }
        return new CategoryParameter<>(request);
    }
}