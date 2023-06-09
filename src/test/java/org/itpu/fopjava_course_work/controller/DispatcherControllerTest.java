package org.itpu.fopjava_course_work.controller;

import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.itpu.fopjava_course_work.criteria.SearchCriteria;
import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.service.ApplianceService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DispatcherControllerTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOutput = System.out;
    private final InputStream originalInput = System.in;

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void cleanup() {
        System.setOut(originalOutput);
        System.setIn(originalInput);
    }

    @Test
    public void testListen_QuitOption_ShouldExit() throws IOException, XmlPullParserException {
        // Set up the input stream to simulate user input
        String input = "3\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);

        // Set up the ApplianceService and parameterConverters
        ApplianceService applianceService = new TestApplianceService();
        Map<String, String> parameterConverters = new HashMap<>();

        // Create an instance of DispatcherController
        DispatcherController dispatcherController = new DispatcherController(applianceService, parameterConverters);

        // Call the method under test
        dispatcherController.listen();

        // Verify the output
        String output = outputStream.toString();
        Assertions.assertTrue(output.contains("Exiting the application. Goodbye!"));
    }

    private static class TestApplianceService implements ApplianceService {
        @Override
        public <T extends Appliance<T>> Collection<T> find(SearchCriteria<T> criteria) {
            return null;
        }
    }

    // ... add more test cases for other options and scenarios

}

