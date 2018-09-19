package com.epam.fjk.calculator;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int INPUT = 15000;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long startF = System.nanoTime();
        BigInteger factorialFjk = FactorialCalculator.calculateWithFjk(INPUT);
        long endF = System.nanoTime();
        final long timeResultF = TimeUnit.MILLISECONDS.convert(endF - startF, TimeUnit.NANOSECONDS);
        log.info(timeResultF + " milliseconds for ForkJoin");
        log.info("Factorial of " + INPUT + " is " + factorialFjk);

        long startS = System.nanoTime();
        BigInteger factorial = FactorialCalculator.calculate(BigInteger.valueOf(INPUT));
        long endS = System.nanoTime();
        final long timeResultS = TimeUnit.MILLISECONDS.convert(endS - startS, TimeUnit.NANOSECONDS);
        log.info("Factorial of " + INPUT + " is " + factorial);
        log.info(timeResultS + " milliseconds for sequential implementation.");

        log.info("ForkJoin is faster than sequential implementation for " + (timeResultS - timeResultF) + " milliseconds!");
    }
}
