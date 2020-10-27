package com.unrec.algorithms.sort;

public class ArraySortDemo {
    public static void main(String[] args) {

        SortAlgorithm gnome = new GnomeSort();
        SortAlgorithm selection = new SelectionSort();
        Sorter sorter = new Sorter();

        sorter.setSortAlgorithm(gnome);
        sorter.sort(100, 100);
        System.out.println("---");
        sorter.setSortAlgorithm(selection);
        sorter.sort(100, 100);
    }
}