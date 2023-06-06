package org.itpu.fopjava_course_work.converter;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.exception.ParameterConversionException;
import org.itpu.fopjava_course_work.parameter.Parameter;
import org.itpu.fopjava_course_work.parameter.QuantityParameter;

public class QuantityParameterConverter<A extends Appliance<A>> extends AbstractParameterConverter<A> {
    public QuantityParameterConverter() {
        super("quantity");
    }
    @Override
    protected Parameter<A> internalConvert(String request) throws ParameterConversionException {
        try {
            if (request == null || request.isEmpty()) {
                throw new ParameterConversionException("Invalid quantity parameter: " + request);
            }
            int Id = Integer.parseInt(request);
            return new QuantityParameter<>(Id);
        } catch (NumberFormatException e) {
            throw new ParameterConversionException("Invalid quantity format: " + request);
        }
    }
}