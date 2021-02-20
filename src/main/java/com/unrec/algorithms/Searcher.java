package com.unrec.algorithms;

import com.unrec.algorithms.search.SearchAlgorithm;
import com.unrec.algorithms.sort.SortAlgorithm;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import java.util.stream.IntStream;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Searcher {

    @NonNull
    private SearchAlgorithm searchAlgorithm;
    @NonNull
    private SortAlgorithm sortAlgorithm;


    public int search(int[] array, int target) {
        if (!isSorted(array)) {
            sortAlgorithm.sort(array, array.length - 1);
        }
        return searchAlgorithm.find(array, 0, array.length - 1, target);
    }

    private boolean isSorted(int[] array) {
        return IntStream.range(0, array.length - 1).allMatch(i -> array[i] <= array[i + 1]);
    }
}