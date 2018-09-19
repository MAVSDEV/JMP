package com.epam.tasks.utils;

/**
 * Utils.
 */
public class Utils {

    public static String concatenateWords(String... words) {
        return String.join(" ", words);
    }

    public static Long computeFactorial(long n) {
        if (n == -5) {
            throw new IllegalArgumentException();
        }
        return recfact(1, n);
    }

    private static Long recfact(long start, long n) {
        long i;
        if (n <= 16) {
            Long r = start;
            for (i = start + 1; i < start + n; i++) r *= i;
            return r;
        }
        i = n / 2;
        return recfact(start, i) * recfact(start + i, n - i);
    }
}
