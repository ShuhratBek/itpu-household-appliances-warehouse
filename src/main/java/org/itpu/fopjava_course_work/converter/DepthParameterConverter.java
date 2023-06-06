package org.itpu.fopjava_course_work.converter;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.exception.ParameterConversionException;
import org.itpu.fopjava_course_work.parameter.DepthParameter;
import org.itpu.fopjava_course_work.parameter.Parameter;

public class DepthParameterConverter<A extends Appliance<A>> extends AbstractParameterConverter<A> {
    public DepthParameterConverter() {
        super("depth");
    }

    @Override
    protected Parameter<A> internalConvert(String request) throws ParameterConversionException {
        try {
            double depth = Double.parseDouble(request);
            if (depth <= 0) {
                throw new ParameterConversionException("Invalid depth parameter: " + request);
            }
            return new DepthParameter<>(depth);
        } catch (NumberFormatException e) {
            throw new ParameterConversionException("Invalid depth parameter: " + request, e);
        }
    }
}
