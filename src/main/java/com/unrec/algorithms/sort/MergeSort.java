package com.unrec.algorithms.sort;

public class MergeSort implements SortAlgorithm {

    @Override
    public void sort(int[] array, int n) {
        sort(array, 0, n);
    }

    public void sort(int[] array, int start, int end) {
        if (end <= start) {
            return;
        }
        int mid = start + (end - start) / 2;

        sort(array, start, mid);
        sort(array, mid + 1, end);
        merge(array, start, mid, end);
    }

    void merge(int[] array, int start, int mid, int end) {
        int leftSize = mid - start + 1;
        int rightSize = end - mid;

        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            left[i] = array[start + i];
        }
        for (int i = 0; i < rightSize; i++) {
            right[i] = array[mid + i + 1];
        }

        int i = 0, j = 0;
        for (int k = start; k < end + 1; k++) {
            if (i < leftSize && j < rightSize) {
                if (left[i] <= right[j]) {
                    array[k] = left[i];
                    i++;
                } else {
                    array[k] = right[j];
                    j++;
                }
            } else if (i < leftSize) {
                array[k] = left[i];
                i++;
            } else if (j < rightSize) {
                array[k] = right[j];
                j++;
            }
        }
    }
}