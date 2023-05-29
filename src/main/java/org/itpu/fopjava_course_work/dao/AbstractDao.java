package org.itpu.fopjava_course_work.dao;

import org.itpu.fopjava_course_work.criteria.SearchCriteria;
import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.parser.CsvLineParser;
import org.itpu.fopjava_course_work.parser.CsvFieldParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.*;

public abstract class AbstractDao<A extends Appliance<A>> implements ApplianceDAO<A> {
    private final String csvPath;
    private final CsvLineParser<A> parser;

    protected AbstractDao(String path, CsvLineParser<A> parser) {
        this.csvPath = path;
        this.parser = parser;
    }

    private BufferedReader getBufferedReader(String path) throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    @Override
    public Collection<A> find(SearchCriteria<A> criteria) {
        List<A> results = new ArrayList<>();
        try (BufferedReader reader = getBufferedReader(csvPath)) {
            // Skip the first line (header)
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                A appliance = parser.parseLine(line);
                if (criteria.test(appliance)) {
                    results.add(appliance);
                }
            }
        } catch (IOException e) {
            // Handle file reading and parsing exceptions
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public Collection<A> findAll() {
        List<A> results = new ArrayList<>();
        try (BufferedReader reader = getBufferedReader(csvPath)) {
            // Skip the first line (header)
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                A appliance = parser.parseLine(line);
                results.add(appliance);
            }
        } catch (IOException e) {
            // Handle file reading and parsing exceptions
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