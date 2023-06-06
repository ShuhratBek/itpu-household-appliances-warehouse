package org.itpu.fopjava_course_work.converter;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.exception.ParameterConversionException;
import org.itpu.fopjava_course_work.parameter.HeightParameter;
import org.itpu.fopjava_course_work.parameter.Parameter;

public class HeightParameterConverter<A extends Appliance<A>> extends AbstractParameterConverter<A> {
    public HeightParameterConverter() {
        super("height");
    }

    @Override
    protected Parameter<A> internalConvert(String request) throws ParameterConversionException {
        try {
            double height = Double.parseDouble(request);
            if (height <= 0) {
                throw new ParameterConversionException("Invalid height parameter: " + request);
            }
            return new HeightParameter<>(height);
        } catch (NumberFormatException e) {
            throw new ParameterConversionException("Invalid height parameter: " + request, e);
        }
    }
}
