package com.unrec.algorithms.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.RepeatedTest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static com.github.seregamorph.hamcrest.OrderMatchers.softOrdered;
import static com.unrec.algorithms.utils.DataProvider.generateUnsortedArray;
import static org.hamcrest.MatcherAssert.assertThat;

@Slf4j
class InsertionSortUnitTest {

    private static final InsertionSort insertionSort = new InsertionSort();


    @RepeatedTest(100)
    void insertionSort_Success() {

        //given
        int[] array = generateUnsortedArray(10, 50);
        log.debug("Array before sorting: {}", Arrays.toString(array));

        //when
        insertionSort.sort(array,array.length);

        //then
        log.debug("Array after sorting: {}", Arrays.toString(array));
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        assertThat(list, softOrdered());
    }
}