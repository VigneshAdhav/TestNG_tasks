package com.testng;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class CalculatorTest {

    Calculator calculator;

    @BeforeClass
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterClass
    public void tearDown() {
        calculator = null;
    }

    @Test(groups = "math")
    public void testAddition() {
        int result = calculator.add(3, 5);
        Assert.assertEquals(result, 8);
    }

    @Test(groups = "math")
    public void testSubtraction() {
        int result = calculator.subtract(8, 3);
        Assert.assertEquals(result, 5);
    }

    @Test(groups = "math")
    public void testMultiplication() {
        int result = calculator.multiply(4, 6);
        Assert.assertEquals(result, 24);
    }

    @Test(groups = "math", dataProvider = "divisionData")
    public void testDivision(int a, int b, int expected) {
        int result = calculator.divide(a, b);
        Assert.assertEquals(result, expected);
    }

    @DataProvider(name = "divisionData")
    public Object[][] divisionData() {
        return new Object[][] {
                {10, 2, 5},
                {12, 4, 3},
                {8, 0, 0}  // Division by zero
        };
    }

    @Test(groups = "math")
    public void testDivideByZero() {
        try {
            calculator.divide(5, 0);
            Assert.fail("Expected ArithmeticException");
        } catch (ArithmeticException e) {
            Assert.assertEquals(e.getMessage(), "Cannot divide by zero");
        }
    }

    @Test(groups = "special")
    public void testSpecialCase() {
        int result = calculator.add(0, 0);
        Assert.assertEquals(result, 0);
    }

    @Test(dependsOnGroups = "math")
    public void testDependentCase() {
        int result = calculator.add(2, 3);
        Assert.assertEquals(result, 5);
    }

    @Parameters({"param1", "param2", "param3"})
    @Test
    public void testParameterized(int param1, int param2, int param3) {
        int result = calculator.add(param1, param2);
        Assert.assertEquals(result, param3);
    }

    @Test
    public void testAnotherParameterized(@Optional("1") int param1, @Optional("2") int param2, @Optional("3") int param3) {
        int result = calculator.add(param1, param2);
        Assert.assertEquals(result, param3);
    }

    @Test(groups = "math", expectedExceptions = ArithmeticException.class)
    public void testExpectedException() {
        calculator.divide(5, 0);
    }
}
