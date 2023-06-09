package org.itpu.fopjava_course_work.controller;

import org.itpu.fopjava_course_work.criteria.SearchCriteria;
import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.service.ApplianceService;
import org.itpu.fopjava_course_work.validators.FieldValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AbstractControllerTest {

    private ApplianceService applianceService;
    private AbstractController<TestAppliance> testController;

    @BeforeEach
    public void setup() {
        applianceService = new TestApplianceService();
        testController = new AbstractController<>(applianceService) {
            @Override
            protected SearchCriteria<TestAppliance> createCriteria() {
                return new SearchCriteria<>() {
                    @Override
                    public Class<TestAppliance> getApplianceType() {
                        return null;
                    }

                    @Override
                    public SearchCriteria<TestAppliance> add(Class<TestAppliance> clazz, FieldValidator fieldValidator) {
                        return null;
                    }

                    @Override
                    public boolean test(TestAppliance appliance) {
                        return false;
                    }
                };
            }
        };
    }

    @Test
    public void testGetAll() {
        // Set up the expected result
        Collection<TestAppliance> expectedResult = Collections.singletonList(new TestAppliance());
        ((TestApplianceService) applianceService).setFindResult(expectedResult);

        // Call the method under test
        Collection<TestAppliance> result = testController.getAll();

        // Verify the result
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testFindBy_WithValidSearchParameters_ReturnsResult() {
        // Set up the expected result
        Collection<TestAppliance> expectedResult = Collections.singletonList(new TestAppliance());
        ((TestApplianceService) applianceService).setFindResult(expectedResult);

        // Set up the search parameters
        Map<String, String> searchParameters = new HashMap<>();
        searchParameters.put("attributeName", "attributeValue");

        // Call the method under test
        Collection<TestAppliance> result = testController.findBy(searchParameters);

        // Verify the result
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testFindBy_WithInvalidSearchParameters_ReturnsEmptyList() {
        // Set up the expected result
        Collection<TestAppliance> expectedResult = Collections.emptyList();
        ((TestApplianceService) applianceService).setFindResult(expectedResult);

        // Set up the search parameters
        Map<String, String> searchParameters = new HashMap<>();
        searchParameters.put("invalidAttributeName", "invalidAttributeValue");

        // Call the method under test
        Collection<TestAppliance> result = testController.findBy(searchParameters);

        // Verify the result
        Assertions.assertTrue(result.isEmpty());
    }

    private static class TestAppliance extends Appliance<TestAppliance> {
        // Implement a test-specific subclass of Appliance
    }

    private static class TestApplianceService implements ApplianceService {
        private Collection<TestAppliance> findResult;

        public void setFindResult(Collection<TestAppliance> findResult) {
            this.findResult = findResult;
        }

        @Override
        public <T extends Appliance<T>> Collection<T> find(SearchCriteria<T> criteria) {
            return (Collection<T>) findResult;
        }
    }
}