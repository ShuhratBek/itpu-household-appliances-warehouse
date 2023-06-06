package org.itpu.fopjava_course_work.exception;

public class ParameterConversionException extends RuntimeException {
    public ParameterConversionException(String message) {
        super(message);
    }

    public ParameterConversionException(String message, Throwable cause) {
        super(message, cause);
    }
}