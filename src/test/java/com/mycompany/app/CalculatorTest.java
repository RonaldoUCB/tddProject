package com.mycompany.app;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculatorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void ifEmptyStringReturnZero() throws Exception {
        // Prepare test
        Calculator calculator = new Calculator();

        // Test logic
        String result = calculator.sum("");

        // Verify o Assert
        assertEquals("0", result);
    }

    @Test
    public void forTwoNumbersReturnSum() throws Exception {
        // Prepare test
        Calculator calculator = new Calculator();

        // Test logic
        String result = calculator.sum("2,3");

        // Verify o Assert
        assertEquals("5", result);

        assertEquals("3", calculator.sum("0,3"));
        assertEquals("55", calculator.sum("44,11"));
        assertEquals("20", calculator.sum("10,10"));
    }

    @Test
    public void forThreeNumbersReturnSum() throws Exception {
        // Prepare test
        Calculator calculator = new Calculator();

        // Test logic
        String result = calculator.sum("2,3,5");

        // Verify o Assert
        assertEquals("10", result);

        assertEquals("3", calculator.sum("1,2,0"));
        assertEquals("55", calculator.sum("20,20,15"));
        assertEquals("20", calculator.sum("10,5,5"));
    }

    @Test
    public void forNumbersGreaterAThousandIgnore() throws Exception {
        // Prepare test
        Calculator calculator = new Calculator();

        // Test logic
        String result = calculator.sum("1001,10");

        // Verify o Assert
        assertEquals("10", result);
    }

    @Test
    public void forNegativeNumberThrowException() throws Exception {
        // Prepare test
        Calculator calculator = new Calculator();

        // Test logic

        // Verify o Assert
        expectedException.expect(Exception.class);
        assertEquals("10", calculator.sum("1001,-10"));
    }
}
