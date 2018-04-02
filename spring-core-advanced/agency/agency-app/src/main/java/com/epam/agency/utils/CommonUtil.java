package com.epam.agency.utils;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Common util.
 */
@Slf4j
public class CommonUtil {

    private CommonUtil() {
        // util class
    }

    public static void sleep(int milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            log.error("Something was wrong!");
        }
    }

    public static List<Integer> getRandomListOfIds() {
        List<Integer> numbers = Lists.newArrayList();
        int estatesSize = ObjectPlaceholder.ESTATES_1.size();
        int tempIndex = 0;
        for (int i = 0; i < estatesSize * 4; i++) {
            numbers.add(tempIndex++);
            if (tempIndex >= estatesSize) {
                tempIndex = 0;
            }
        }
        Collections.shuffle(numbers);
        return numbers;
    }

    public static long getRandomNumber(int min, int max) {
        return (long) (min + new Random().nextInt((max - min) + 1));
    }
}
