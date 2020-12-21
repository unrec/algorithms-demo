package com.unrec.algorithms.search;

public class Searcher {

    private SearchAlgorithm searchAlgorithm;

    public Searcher() {
    }

    public Searcher(SearchAlgorithm searchAlgorithm) {
        this.searchAlgorithm = searchAlgorithm;
    }

    public void setSearchAlgorithm(SearchAlgorithm searchAlgorithm) {
        this.searchAlgorithm = searchAlgorithm;
    }

    public int search(int[] array, int target) {
        return searchAlgorithm.find(array, target);
    }
}