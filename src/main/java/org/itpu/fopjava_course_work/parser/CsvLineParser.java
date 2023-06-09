package org.itpu.fopjava_course_work.parser;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.entity.ApplianceFactory;

import java.util.List;

public class CsvLineParser<T extends Appliance<T>> {
    private final ApplianceFactory<T> factory;
    private final List<CsvFieldParser<T>> fieldParsers;

    public CsvLineParser(ApplianceFactory<T> factory, List<CsvFieldParser<T>> fieldParsers) {
        this.factory = factory;
        this.fieldParsers = fieldParsers;
    }

    public T parseLine(String csvLine) {
        T instance = factory.createInstance();
        String[] values = csvLine.split(",");
        for (int i = 0; i < Math.min(values.length, fieldParsers.size()); i++) {
            fieldParsers.get(i).parseAndSet(instance, values[i]);
        }
        return instance;
    }
}