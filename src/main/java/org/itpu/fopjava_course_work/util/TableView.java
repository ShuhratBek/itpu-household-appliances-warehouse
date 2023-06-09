package org.itpu.fopjava_course_work.util;

import org.itpu.fopjava_course_work.entity.Appliance;

import java.lang.reflect.Field;
import java.util.*;

public class TableView {
    public static void printTable(List<Appliance<?>> appliances) {
        Set<String> keys = new LinkedHashSet<>();

        // Get fields from the parent class (Appliance)
        Class<?> parentClass = Appliance.class;
        Field[] parentFields = parentClass.getDeclaredFields();

        for (Field field : parentFields) {
            keys.add(field.getName().trim());
        }

        // Get fields from the concrete subclasses
        for (Appliance<?> appliance : appliances) {
            Class<?> applianceClass = appliance.getClass();
            Field[] fields = applianceClass.getDeclaredFields();

            for (Field field : fields) {
                keys.add(field.getName().trim());
            }
        }

        // Prepare the values for each property
        List<List<String>> rows = new ArrayList<>();
        Map<String, Integer> columnWidths = new HashMap<>();

        // Determine the initial column widths based on the header names
        for (String key : keys) {
            int columnWidth = key.length();
            columnWidths.put(key, columnWidth);
        }

        for (Appliance<?> appliance : appliances) {
            List<String> row = new ArrayList<>();
            for (String key : keys) {
                try {
                    Field field;
                    Object value;
                    if (Arrays.stream(parentFields).anyMatch(f -> f.getName().equals(key))) {
                        field = parentClass.getDeclaredField(key);
                        field.setAccessible(true);
                        value = field.get(appliance);
                    } else {
                        field = appliance.getClass().getDeclaredField(key);
                        field.setAccessible(true);
                        value = field.get(appliance);
                    }
                    String formattedValue = String.valueOf(value).trim();
                    row.add(formattedValue);

                    // Update column width if necessary
                    int contentLength = formattedValue.length();
                    int currentWidth = columnWidths.get(key);
                    int newWidth = Math.max(contentLength, currentWidth);
                    columnWidths.put(key, newWidth);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    row.add("N/A");
                }
            }
            rows.add(row);
        }

        printHeader(keys, columnWidths);
        printContent(keys, rows, columnWidths);
        printFooter(keys, columnWidths);
    }

    private static void printHeader(Set<String> keys, Map<String, Integer> columnWidths) {
        System.out.print("+");

        for (String key : keys) {
            int columnWidth = columnWidths.get(key);
            System.out.print("-".repeat(columnWidth + 2));
            System.out.print("+");
        }
        System.out.println();

        for (String key : keys) {
            int columnWidth = columnWidths.get(key);
            String formattedHeader = String.format("%-" + columnWidth + "s", key);
            System.out.print("| " + formattedHeader + " ");
        }
        System.out.println("|");
        System.out.print("+");
        for (String key : keys) {
            int columnWidth = columnWidths.get(key);
            System.out.print("-".repeat(columnWidth + 2));
            System.out.print("+");
        }
        System.out.println();
    }

    private static void printContent(Set<String> keys, List<List<String>> rows, Map<String, Integer> columnWidths) {
        for (List<String> row : rows) {
            System.out.print("|");
            int columnIndex = 0;
            for (String value : row) {
                int columnWidth = columnWidths.get(keys.toArray()[columnIndex]);
                System.out.printf(" %-" + columnWidth + "s |", value);
                columnIndex++;
            }
            System.out.println();
        }
    }

    private static void printFooter(Set<String> keys, Map<String, Integer> columnWidths) {
        System.out.print("+");
        for (String key : keys) {
            int columnWidth = columnWidths.get(key);
            System.out.print("-".repeat(columnWidth + 2));
            System.out.print("+");
        }
        System.out.println();
    }
}
