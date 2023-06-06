package org.itpu.fopjava_course_work.converter;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.exception.ParameterConversionException;
import org.itpu.fopjava_course_work.parameter.ModelNameParameter;
import org.itpu.fopjava_course_work.parameter.Parameter;

public class ModelNameParameterConverter<A extends Appliance<A>> extends AbstractParameterConverter<A> {
    public ModelNameParameterConverter() {
        super("modelName");
    }
    @Override
    protected Parameter<A> internalConvert(String request) throws ParameterConversionException {
        if (request == null || request.isEmpty()) {
            throw new ParameterConversionException("Invalid modelName parameter: " + request);
        }
        return new ModelNameParameter<>(request);
    }
}