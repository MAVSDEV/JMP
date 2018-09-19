package com.epam.fjk.sorting;

import java.util.concurrent.ForkJoinPool;

public class MergeSortAlgorithm {

    public static int[] sort(int[] unsortedArray) {
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(new MergeSortAction(unsortedArray, 0, unsortedArray.length)).join();
        return unsortedArray;
    }
}
