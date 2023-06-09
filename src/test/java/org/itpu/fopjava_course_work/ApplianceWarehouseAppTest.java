package org.itpu.fopjava_course_work;

import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplianceWarehouseAppTest {

    @Test
    public void testMain_ShouldExecuteWithoutErrors() throws IOException, XmlPullParserException {
        // Arrange
        String input = "3\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Act
        ApplianceWarehouseApp.main(new String[0]);

        // Assert
        // No exceptions were thrown, so the execution is considered successful
        assertEquals(947, outputStream.size());
    }
}
