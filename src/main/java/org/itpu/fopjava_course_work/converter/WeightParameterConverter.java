package org.itpu.fopjava_course_work.converter;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.exception.ParameterConversionException;
import org.itpu.fopjava_course_work.parameter.WeightParameter;
import org.itpu.fopjava_course_work.parameter.Parameter;

public class WeightParameterConverter<A extends Appliance<A>> extends AbstractParameterConverter<A> {
    public WeightParameterConverter() {
        super("weight");
    }

    @Override
    protected Parameter<A> internalConvert(String request) throws ParameterConversionException {
        try {
            double weight = Double.parseDouble(request);
            if (weight <= 0) {
                throw new ParameterConversionException("Invalid weight parameter: " + request);
            }
            return new WeightParameter<>(weight);
        } catch (NumberFormatException e) {
            throw new ParameterConversionException("Invalid weight parameter: " + request, e);
        }
    }
}
