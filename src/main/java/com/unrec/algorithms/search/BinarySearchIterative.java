package com.unrec.algorithms.search;

public class BinarySearchIterative implements SearchAlgorithm {

    @Override
    public int find(int[] array, int start, int end, int target) {

        if (end > array.length) {
            return -1;
        }

        int left = start;
        int right = end;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] > target) {
                right = mid - 1;
            }
            if (array[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }
}