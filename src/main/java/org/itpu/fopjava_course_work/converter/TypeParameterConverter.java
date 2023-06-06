package org.itpu.fopjava_course_work.converter;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.exception.ParameterConversionException;
import org.itpu.fopjava_course_work.parameter.Parameter;
import org.itpu.fopjava_course_work.parameter.TypeParameter;

public class TypeParameterConverter<A extends Appliance<A>> extends AbstractParameterConverter<A> {
    public TypeParameterConverter() {
        super("type");
    }
    @Override
    protected Parameter<A> internalConvert(String request) throws ParameterConversionException {
        if (request == null || request.isEmpty()) {
            throw new ParameterConversionException("Invalid type parameter: " + request);
        }
        return new TypeParameter<>(request);
    }
}