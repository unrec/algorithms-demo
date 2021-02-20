package com.unrec.algorithms.search;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.RepeatedTest;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import static com.unrec.algorithms.utils.DataProvider.generateContinuousArray;
import static com.unrec.algorithms.utils.DataProvider.randomPositiveIntLessThan;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class BinarySearchUnitTest {

    private static final SearchAlgorithm binaryIterative = new BinarySearchIterative();
    private static final SearchAlgorithm binaryRecursive = new BinarySearchRecursive();
    private static final int MAX_ARRAY_SIZE = 100;

    @RepeatedTest(100)
    void binarySearchIterative_Found() {

        //given
        int size = randomPositiveIntLessThan(MAX_ARRAY_SIZE);
        int[] array = generateContinuousArray(0, size);
        int target = randomPositiveIntLessThan(size);
        log.debug("Size of array: {}, target: {}", size, target);

        //when
        int result = binaryIterative.find(array, 0, size, target);

        //then
        assertTrue(result != -1);
    }

    @RepeatedTest(100)
    void binarySearchIterative_NotFound() {

        //given
        int size = randomPositiveIntLessThan(MAX_ARRAY_SIZE);
        int[] array = generateContinuousArray(0, size);
        int target = ThreadLocalRandom.current().nextInt(size + 1, size + 100);
        log.debug("Size of array: {}, target: {}", size, target);
        log.debug("Array: {}", Arrays.toString(array));

        //when
        int result = binaryIterative.find(array, 0, size, target);

        //then
        assertEquals(result, -1);
    }

    @RepeatedTest(100)
    void binarySearchRecursive_Found() {

        //given
        int size = randomPositiveIntLessThan(MAX_ARRAY_SIZE);
        int[] array = generateContinuousArray(0, size);
        int target = randomPositiveIntLessThan(size);
        log.debug("Size of array: {}, target: {}", size, target);

        //when
        int result = binaryRecursive.find(array, 0, size, target);

        //then
        assertTrue(result != -1);
    }

    @RepeatedTest(100)
    void binarySearchRecursive_NotFound() {

        //given
        int size = randomPositiveIntLessThan(MAX_ARRAY_SIZE);
        int[] array = generateContinuousArray(0, size);
        int target = ThreadLocalRandom.current().nextInt(size + 1, size + 100);
        log.debug("Size of array: {}, target: {}", size, target);
        log.debug("Array: {}", Arrays.toString(array));

        //when
        int result = binaryRecursive.find(array, 0, size, target);

        //then
        assertEquals(result, -1);
    }
}