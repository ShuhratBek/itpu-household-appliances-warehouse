package org.itpu.fopjava_course_work.util;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TableViewTest {
    @Test
    public void testPrintTable_ShouldPrintTable() {
        // Arrange
        List<Appliance<?>> appliances = new ArrayList<>();
        appliances.add(new TestAppliance().setId(1).setName("Appliance 1").setBrand("Brand 1").setQuantity(5));
        appliances.add(new TestAppliance().setId(2).setName("Appliance 2").setBrand("Brand 2").setQuantity(10));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Act
        TableView.printTable(appliances);

        // Assert
        String expectedOutput = """
                +----+-------------+------+---------+-----------+----------+-------+--------+--------+-------+-------+----------+-------+---------+
                | id | name        | type | brand   | modelName | category | price | weight | height | width | depth | quantity | color | voltage |
                +----+-------------+------+---------+-----------+----------+-------+--------+--------+-------+-------+----------+-------+---------+
                | 1  | Appliance 1 | null | Brand 1 | null      | null     | 0     | 0.0    | 0.0    | 0.0   | 0.0   | 5        | null  | null    |
                | 2  | Appliance 2 | null | Brand 2 | null      | null     | 0     | 0.0    | 0.0    | 0.0   | 0.0   | 10       | null  | null    |
                +----+-------------+------+---------+-----------+----------+-------+--------+--------+-------+-------+----------+-------+---------+
                """;
        String actualOutput = outputStream.toString();
        assertEquals(expectedOutput, actualOutput);
    }

    private static class TestAppliance extends Appliance<TestAppliance> {
        // Implement a test-specific subclass of Appliance
    }
}
