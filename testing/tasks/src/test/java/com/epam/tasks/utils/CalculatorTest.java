package com.epam.tasks.utils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * CalculatorTest.
 */
@RunWith(JUnit4.class)
public class CalculatorTest {

    @Test
    public void calculatorTest_add() {
        long result = Calculator.add(4, 5);
        Assert.assertEquals(9, result);
    }

    @Test
    public void calculatorTest_subtract() {
        long result = Calculator.subtract(4, 5);
        Assert.assertEquals(-1, result);
    }

    @Test
    public void calculatorTest_multiply() {
        long result = Calculator.multiply(4, 5);
        Assert.assertEquals(20, result);
    }

    @Test
    public void calculatorTest_divide() {
        long result = Calculator.divide(10, 5);
        Assert.assertEquals(2, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculatorTest_divideWithException() {
        Calculator.divide(10, 0);
    }

    @Test
    public void calculatorTest_rootInt() {
        long result = Calculator.rootInt(8, 2);
        Assert.assertEquals(2, result);
    }

    @Test
    public void calculatorTest_powerInt() {
        long result = Calculator.powerInt(4, 3);
        Assert.assertEquals(64, result);
    }

    @Test
    public void calculatorTest_rootDouble() {
        double result = Calculator.rootDouble(4.3, 3.2);
        Assert.assertEquals(1.577, result, 0.001);
    }

    @Test
    public void calculatorTest_powerDouble() {
        double result = Calculator.powerDouble(4.7, 3.9);
        Assert.assertEquals(418.005, result, 0.001);
    }

    @Test
    public void calculatorTest_isPrimeTrue() {
        boolean isPrime = Calculator.isPrime(43);
        Assert.assertTrue(isPrime);
    }

    @Test
    public void calculatorTest_isPrimeFalse() {
        boolean isPrime = Calculator.isPrime(42);
        Assert.assertFalse(isPrime);
    }

    @Test
    public void calculatorTest_isPrimeLessThanTwo() {
        boolean isPrime = Calculator.isPrime(1);
        Assert.assertFalse(isPrime);
    }

    @Test
    public void calculatorTest_isPrimeEqualsTwo() {
        boolean isPrime = Calculator.isPrime(2);
        Assert.assertTrue(isPrime);
    }

    @Test
    public void calculatorTest_isPrimeFalse1() {
        boolean isPrime = Calculator.isPrime(9);
        Assert.assertFalse(isPrime);
    }

    @Test(timeout = 5)
    public void calculatorTest_isPrimeWithTimeout() {
        Calculator.isPrime(42000);
    }

    @Test
    public void calculatorTest_findFibonacciSequenceWithZero() {
        long result = Calculator.findFibonacci(0);
        Assert.assertEquals(0, result);
    }

    @Test
    public void calculatorTest_findFibonacciSequenceWithOne() {
        long result = Calculator.findFibonacci(1);
        Assert.assertEquals(1, result);
    }

    @Test
    public void calculatorTest_findFibonacciSequence() {
        Long result = Calculator.findFibonacci(15);
        assertThat(result, allOf(
                is(greaterThan(10l)),
                is(lessThan(700l))
        ));
    }
}