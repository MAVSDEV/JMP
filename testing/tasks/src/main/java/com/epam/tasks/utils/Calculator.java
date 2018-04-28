package com.epam.tasks.utils;

import java.math.BigInteger;

/**
 * Calculator.
 */
public class Calculator {

    public static long add(long a, long b) {
        return a + b;
    }

    public static long subtract(long a, long b) {
        return a - b;
    }

    public static long multiply(long a, long b) {
        return a * b;
    }

    public static long divide(long a, long b) {
        if (b == 0) {
            throw new IllegalArgumentException();
        }
        return a / b;
    }

    public static double rootDouble(double num, double root) {
        return Math.pow(Math.E, Math.log(num) / root);
    }

    public static double powerDouble(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static int rootInt(int num, int root) {
        return BigInteger.valueOf((long) Math.pow(Math.E, Math.log(num) / root)).intValue();
    }

    public static int powerInt(int base, int exponent) {
        return BigInteger.valueOf((long) Math.pow(base, exponent)).intValue();
    }

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static long findFibonacci(long n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return findFibonacci(n - 1) + findFibonacci(n - 2);
    }

}
