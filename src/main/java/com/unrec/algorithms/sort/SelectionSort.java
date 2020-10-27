package com.unrec.algorithms.sort;

public class SelectionSort implements SortAlgorithm {

    @Override
    public void sort(int[] array) {
        for (int startIndex = 0; startIndex < array.length - 1; startIndex++) {
            int minIndex = startIndex;
            for (int i = startIndex + 1; i < array.length; i++) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }
            if (minIndex != startIndex) {
                int tmp = array[startIndex];
                array[startIndex] = array[minIndex];
                array[minIndex] = tmp;
            }
        }
    }
}