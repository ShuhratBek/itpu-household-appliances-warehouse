package org.itpu.fopjava_course_work.dao;

import org.itpu.fopjava_course_work.criteria.SearchCriteria;
import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.parser.CsvLineParser;
import org.itpu.fopjava_course_work.parser.CsvFieldParser;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.*;

public abstract class AbstractDao<T extends Appliance<T>> implements ApplianceDAO<T> {
    private final String csvPath;
    private final CsvLineParser<T> parser;

    protected AbstractDao(String path, CsvLineParser<T> parser) {
        this.csvPath = path;
        this.parser = parser;
    }

    private BufferedReader getBufferedReader(String path) throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
        if (inputStream == null) {
            throw new FileNotFoundException("Resource file not found: " + path);
        }
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    @Override
    public Collection<T> find(SearchCriteria<T> criteria) {
        List<T> results = new ArrayList<>();
        try (BufferedReader reader = getBufferedReader(csvPath)) {
            // Skip the first line (header)
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                T appliance = parser.parseLine(line);
                if (criteria.test(appliance)) {
                    results.add(appliance);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }

    public static <T> CsvFieldParser<T> forInt(BiConsumer<T, Integer> setter) {
        return (obj, value) -> setter.accept(obj, Integer.parseInt(value));
    }

    public static <T> CsvFieldParser<T> forLong(BiConsumer<T, Long> setter) {
        return (obj, value) -> setter.accept(obj, Long.parseLong(value));
    }

    public static <T> CsvFieldParser<T> forDouble(BiConsumer<T, Double> setter) {
        return (obj, value) -> setter.accept(obj, Double.parseDouble(value));
    }

    public static <T> CsvFieldParser<T> forString(BiConsumer<T, String> setter) {
        return setter::accept;
    }
}