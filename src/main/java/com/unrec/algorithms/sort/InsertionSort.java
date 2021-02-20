package com.unrec.algorithms.sort;

public class InsertionSort implements SortAlgorithm {

    @Override
    public void sort(int[] array, int n) {
        for (int i = 1; i < n; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && current < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }
}