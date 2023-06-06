package org.itpu.fopjava_course_work.converter;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.exception.ParameterConversionException;
import org.itpu.fopjava_course_work.parameter.Parameter;
import org.itpu.fopjava_course_work.parameter.WidthParameter;

public class WidthParameterConverter<A extends Appliance<A>> extends AbstractParameterConverter<A> {
    public WidthParameterConverter() {
        super("width");
    }

    @Override
    protected Parameter<A> internalConvert(String request) throws ParameterConversionException {
        try {
            double width = Double.parseDouble(request);
            if (width <= 0) {
                throw new ParameterConversionException("Invalid width parameter: " + request);
            }
            return new WidthParameter<>(width);
        } catch (NumberFormatException e) {
            throw new ParameterConversionException("Invalid width parameter: " + request, e);
        }
    }
}
