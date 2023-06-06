package org.itpu.fopjava_course_work.converter;

import org.itpu.fopjava_course_work.parameter.Parameter;
import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.exception.ParameterConversionException;

public interface ParameterConverter<A extends Appliance<A>> {
    Parameter<A> convert(String request) throws ParameterConversionException;
    String parameterName();
}
