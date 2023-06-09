package org.itpu.fopjava_course_work.parser;

@FunctionalInterface
public interface CsvFieldParser<T> {
    void parseAndSet(T obj, String value);
}
