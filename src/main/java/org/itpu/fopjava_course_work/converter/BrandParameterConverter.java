package org.itpu.fopjava_course_work.converter;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.exception.ParameterConversionException;
import org.itpu.fopjava_course_work.parameter.BrandParameter;
import org.itpu.fopjava_course_work.parameter.Parameter;

public class BrandParameterConverter<A extends Appliance<A>> extends AbstractParameterConverter<A> {
    public BrandParameterConverter() {
        super("brand");
    }
    @Override
    protected Parameter<A> internalConvert(String request) throws ParameterConversionException {
        if (request == null || request.isEmpty()) {
            throw new ParameterConversionException("Invalid brand parameter: " + request);
        }
        return new BrandParameter<>(request);
    }
}