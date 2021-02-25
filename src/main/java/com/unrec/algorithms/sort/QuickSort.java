package com.unrec.algorithms.sort;

public class QuickSort implements SortAlgorithm {

    @Override
    public void sort(int[] array, int n) {
        quickSort(array, 0, n);
    }

    private void quickSort(int[] array, int start, int end) {
        if (end <= start) {
            return;
        }
        int pivot = partition(array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private int partition(int[] array, int start, int end) {
        int pivot = end;

        int counter = start;
        for (int i = start; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;

        return counter;
    }
}