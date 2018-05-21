package com.epam.fjk.sorting;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Random;

@Slf4j
public class Main {

    public static void main(String[] args) {
        int size = 10;
        int[] array = prepareUnsortedArray(size);
        long start = System.nanoTime();
        MergeSortAlgorithm.sort(array);
        log.info(String.format("%f [msec]", (System.nanoTime() - start) / 1000000.0));
        log.info("array was sorted: " + Arrays.toString(array));
    }

    private static int[] prepareUnsortedArray(int size) {
        int[] array = new int[size];
        for(int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt();
        }
        return array;
    }
}
