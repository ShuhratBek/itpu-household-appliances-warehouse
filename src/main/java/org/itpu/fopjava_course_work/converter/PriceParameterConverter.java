package org.itpu.fopjava_course_work.converter;

import org.itpu.fopjava_course_work.parameter.Parameter;
import org.itpu.fopjava_course_work.parameter.PriceParameter;
import org.itpu.fopjava_course_work.dao.Range;
import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.exception.ParameterConversionException;

public class PriceParameterConverter<A extends Appliance<A>> extends AbstractParameterConverter<A> {
    public PriceParameterConverter() {
        super("price");
    }

    @Override
    protected Parameter<A> internalConvert(String request) throws ParameterConversionException {
        try {
            String[] values = request.split("-");
            if (values.length != 2) {
                throw new ParameterConversionException("Invalid price range format: " + request);
            }

            long minPrice = Long.parseLong(values[0]);
            long maxPrice = Long.parseLong(values[1]);

            return new PriceParameter<>(new Range<>(minPrice, maxPrice));
        } catch (NumberFormatException e) {
            throw new ParameterConversionException("Invalid price format: " + request);
        }
    }
}
