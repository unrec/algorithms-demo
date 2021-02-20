package com.unrec.algorithms.search;

public class BinarySearchRecursive implements SearchAlgorithm {

    @Override
    public int find(int[] array, int start, int end, int target) {

        if (end > array.length || end < start) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (array[mid] == target) {
            return mid;
        }
        if (array[mid] > target) {
            return find(array, start, mid - 1, target);
        } else {
            return find(array, mid + 1, end, target);
        }
    }
}