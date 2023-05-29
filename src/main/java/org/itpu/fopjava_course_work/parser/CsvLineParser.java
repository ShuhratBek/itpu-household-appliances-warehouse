package org.itpu.fopjava_course_work.parser;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.entity.ApplianceFactory;
import java.util.List;

public class CsvLineParser <A extends Appliance<A>> {
    private final ApplianceFactory<A> factory;
    private final List<CsvFieldParser<A>> fieldParsers;

    public CsvLineParser(ApplianceFactory<A> factory, List<CsvFieldParser<A>> fieldParsers) {
        this.factory = factory;
        this.fieldParsers = fieldParsers;
    }

    public A parseLine(String csvLine) {
        A instance = factory.createInstance();
        String[] values = csvLine.split(",");
        for (int i = 0; i < Math.min(values.length, fieldParsers.size()); i++) {
            fieldParsers.get(i).parseAndSet(instance, values[i]);
        }
        return instance;
    }
}