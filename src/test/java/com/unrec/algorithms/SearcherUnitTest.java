package com.unrec.algorithms;

import com.unrec.algorithms.search.BinarySearchIterative;
import com.unrec.algorithms.search.BinarySearchRecursive;
import com.unrec.algorithms.search.SearchAlgorithm;
import com.unrec.algorithms.sort.InsertionSort;
import com.unrec.algorithms.sort.MergeSort;
import com.unrec.algorithms.sort.SortAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import static com.unrec.algorithms.utils.DataProvider.generateUnsortedArray;
import static com.unrec.algorithms.utils.DataProvider.randomArrayItem;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@Slf4j
public class SearcherUnitTest {

    private static final int MAX_ARRAY_SIZE = 50;
    private static final int BOUND_VALUE = 1000;
    private static final int ARGUMENTS_AMOUNT = 100;
    private static List<Arguments> argumentsList;

    static {
        argumentsList = new ArrayList<>();

        for (int i = 0; i < ARGUMENTS_AMOUNT; i++) {
            int[] array = generateUnsortedArray(MAX_ARRAY_SIZE, BOUND_VALUE);
            int target = randomArrayItem(array);
            argumentsList.add(arguments(array, target));
        }
    }

    private final Searcher searcher = new Searcher();
    private final SearchAlgorithm binarySearchIterative = new BinarySearchIterative();
    private final SearchAlgorithm binarySearchRecursive = new BinarySearchRecursive();
    private final SortAlgorithm mergeSort = new MergeSort();
    private final SortAlgorithm insertionSort = new InsertionSort();

    static Stream<Arguments> arrayAndTargetProvider() {
        return argumentsList.stream();
    }

    @DisplayName("Binary Search with Merge Sorting")
    @ParameterizedTest(name = "run: {index}, target = {1}")
    @MethodSource("arrayAndTargetProvider")
    void binarySearchIterative_MergeSort(int[] array, int target) {

        //given
        searcher.setSearchAlgorithm(binarySearchIterative);
        searcher.setSortAlgorithm(mergeSort);

        //when
        int result = searcher.search(array, target);
        log.debug("Found at position: {}", result);

        //then
        assertTrue(result != -1);
    }

    @DisplayName("Binary Search with Insertion Sorting")
    @ParameterizedTest(name = "run: {index}, target = {1}")
    @MethodSource("arrayAndTargetProvider")
    void binarySearchIterative_InsertionSort(int[] array, int target) {

        //given
        searcher.setSearchAlgorithm(binarySearchIterative);
        searcher.setSortAlgorithm(insertionSort);

        //when
        int result = searcher.search(array, target);
        log.debug("Found at position: {}", result);

        //then
        assertTrue(result != -1);
    }
}