package com.epam.fjk.calculator;


import java.math.*;
import java.util.concurrent.*;

public class FactorialCalculator {

    public static BigInteger calculateWithFjk(int input) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<BigInteger> future = forkJoinPool.submit(new FactorialTask(1, input + 1));
        return future.get();
    }

    public static BigInteger calculate(BigInteger n) {
        return factorial(n);
    }

    private static BigInteger factorial(BigInteger n) {
        return n.equals(BigInteger.ZERO) ? BigInteger.ONE : n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }
}
