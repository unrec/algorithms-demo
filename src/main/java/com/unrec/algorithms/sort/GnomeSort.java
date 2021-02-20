package com.unrec.algorithms.sort;

public class GnomeSort implements SortAlgorithm {

    public void sort(int[] array, int n) {
        int index = 0;

        while (index < n) {
            if (index == 0) {
                index++;
            }
            if (array[index] >= array[index - 1]) {
                index++;
            } else {
                int temp = array[index];
                array[index] = array[index - 1];
                array[index - 1] = temp;
                index--;
            }
        }
    }
}