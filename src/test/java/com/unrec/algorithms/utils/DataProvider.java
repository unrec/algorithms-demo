package com.unrec.algorithms.utils;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class DataProvider {

    private static ThreadLocalRandom random = ThreadLocalRandom.current();

    public static int[] generateUnsortedArray(int size, int bound) {
        return IntStream.generate(() -> random.nextInt(bound)).limit(size).toArray();
    }

    public static int[] generateSortedArray(int size, int bound) {
        return IntStream.generate(() -> random.nextInt(bound)).limit(size).sorted().toArray();
    }

    public static int[] generateContinuousArray(int start, int end) {
        return IntStream.rangeClosed(start, end).toArray();
    }

    public static int randomPositiveInt() {
        return random.nextInt(1, Integer.MAX_VALUE - 1);
    }

    public static int randomPositiveIntLessThan(int max) {
        if (max == 1) {
            return 1;
        }
        return random.nextInt(1, max);
    }

    public static int randomArrayItem(int[] array) {
        return array[randomPositiveIntLessThan(array.length - 1)];
    }
}