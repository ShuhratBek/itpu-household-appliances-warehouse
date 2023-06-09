package org.itpu.fopjava_course_work.validators;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FieldValidatorTest {

    @Test
    public void testTest_ShouldReturnTrue() {
        // Arrange
        TestAppliance appliance = new TestAppliance().setId(1).setName("Appliance 1").setPrice(99);
        FieldValidator validator = new FieldValidator("name", "Appliance 1");

        // Act
        boolean result = validator.test(appliance);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testTest_ShouldReturnFalse() {
        // Arrange
        TestAppliance appliance = new TestAppliance().setId(1).setName("Appliance 1").setPrice(99);
        FieldValidator validator = new FieldValidator("price", 199.99);

        // Act
        boolean result = validator.test(appliance);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testTest_ShouldReturnTrueForRange() {
        // Arrange
        TestAppliance appliance = new TestAppliance().setId(1).setName("Appliance 1").setPrice(99);
        FieldValidator validator = new FieldValidator("price", "50-150");

        // Act
        boolean result = validator.test(appliance);

        // Assert
        assertTrue(result);
    }

    private static class TestAppliance extends Appliance<TestAppliance> {
    }
}
