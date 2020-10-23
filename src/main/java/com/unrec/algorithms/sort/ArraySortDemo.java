package com.unrec.algorithms.sort;

public class ArraySortDemo {
    public static void main(String[] args) {

        SortAlgorithm gnome = new GnomeSort();
        Sorter sorter = new Sorter(gnome);
        sorter.sort(100, 100);
    }
}