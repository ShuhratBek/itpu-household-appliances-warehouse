package org.itpu.fopjava_course_work.converter;

import org.itpu.fopjava_course_work.parameter.IdParameter;
import org.itpu.fopjava_course_work.parameter.Parameter;
import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.exception.ParameterConversionException;

public class IdParameterConverter<A extends Appliance<A>> extends AbstractParameterConverter<A> {
    public IdParameterConverter() {
        super("id");
    }
    @Override
    protected Parameter<A> internalConvert(String request) throws ParameterConversionException {
        try {
            if (request == null || request.isEmpty()) {
                throw new ParameterConversionException("Invalid Id parameter: " + request);
            }
            int Id = Integer.parseInt(request);
            return new IdParameter<>(Id);
        } catch (NumberFormatException e) {
            throw new ParameterConversionException("Invalid Id format: " + request);
        }
    }
}