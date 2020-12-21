package com.unrec.algorithms.utils;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class ArrayGenerator {

    private static ThreadLocalRandom random = ThreadLocalRandom.current();

    public static int[] generate(int size, int bound) {
        return IntStream.generate(() -> random.nextInt(bound)).limit(size).toArray();
    }

    public static int[] generateSorted(int size, int bound) {
        return IntStream.generate(() -> random.nextInt(bound)).limit(size).sorted().toArray();
    }
}