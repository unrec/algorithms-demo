package com.unrec.algorithms.sort;

public class SelectionSort implements SortAlgorithm {

    @Override
    public void sort(int[] array, int n) {
        for (int startIndex = 0; startIndex < n - 1; startIndex++) {
            int minIndex = startIndex;
            for (int i = startIndex + 1; i < n; i++) {
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