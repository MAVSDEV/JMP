package com.epam.fjk.calculator;

import java.math.BigInteger;
import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<BigInteger> {

    private static final int THRESHOLD = 1000;
    
    private final int lo;
    private final int hi;

    public FactorialTask(int lo, int hi) {
        this.lo = lo;
        this.hi = hi;
    }

    @Override
    protected BigInteger compute() {
        if (hi - lo < THRESHOLD) {
            BigInteger result = BigInteger.valueOf(lo);
            for (int i = lo + 1; i < hi; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
            return result;
        } else {
            int mid = (lo + hi) >>> 1;

            FactorialTask f1 = new FactorialTask(lo, mid);
            f1.fork();
            FactorialTask f2 = new FactorialTask(mid, hi);
            return f2.compute().multiply(f1.join());
        }
    }
}
