package com.testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicTestNGTest {

    private int value;

    @BeforeMethod
    public void setUp() {
        value = 10;
    }

    @AfterMethod
    public void tearDown() {
        value = 0;
    }

    @Test
    public void testAddition() {
        int result = value + 5;
        Assert.assertEquals(result, 15);
    }

    @Test
    public void testSubtraction() {
        int result = value - 5;
        Assert.assertEquals(result, 5);
    }

    @Test
    public void testMultiplication() {
        int result = value * 2;
        Assert.assertEquals(result, 20);
    }

    @Test
    public void testDivision() {
        int result = value / 2;
        Assert.assertEquals(result, 5);
    }

    @Test
    public void testGreaterThan() {
        Assert.assertTrue(value > 5);
    }

    @Test
    public void testLessThan() {
        Assert.assertTrue(value < 20);
    }

    @Test
    public void testEquality() {
        Assert.assertEquals(value, 10);
    }

    @Test
    public void testNotNull() {
        Assert.assertNotNull(value);
    }

    @Test
    public void testNull() {
        Integer nullValue = null;
        Assert.assertNull(nullValue);
    }

    @Test
    public void testFail() {
        Assert.fail("This test intentionally fails.");
    }
}
