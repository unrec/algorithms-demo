package com.unrec.algorithms.sort;

import com.unrec.algorithms.utils.ArrayGenerator;
import java.util.Arrays;

public class Sorter {

    private SortAlgorithm sortAlgorithm;

    public Sorter(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public void sort(int size, int bound) {
        int[] array = ArrayGenerator.generate(size, bound);
        System.out.println("array before = " + Arrays.toString(array));
        sortAlgorithm.sort(array);
        System.out.println("array after = " + Arrays.toString(array));
    }
}