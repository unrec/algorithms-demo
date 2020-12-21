package com.unrec.algorithms.search;

import com.unrec.algorithms.utils.ArrayGenerator;

import java.util.Arrays;

public class SearchDemo {
    public static void main(String[] args) {

        int[] array = ArrayGenerator.generateSorted(100, 100);
        System.out.println("Sorted array = " + Arrays.toString(array));

        SearchAlgorithm binaryIterative = new BinarySearchIterative();
        Searcher searcher = new Searcher();
        searcher.setSearchAlgorithm(binaryIterative);

        int target = 42;
        int result = searcher.search(array, target);
        System.out.println("Searching for target: " + target);
        System.out.println(result == -1 ? "NOT FOUND" : "FOUND AT " + result + " POSITION");
    }
}