package com.unrec.algorithms.search;

public class BinarySearchIterative implements SearchAlgorithm {

    @Override
    public int find(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int median = left + (right - left) / 2;
            if (array[median] == target) {
                return median;
            }
            if (array[median] > target) {
                right = median - 1;
            }
            if (array[median] < target) {
                left = median + 1;
            }
        }
        return -1;
    }
}