package com.unrec.algorithms.search;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import static com.unrec.algorithms.utils.DataProvider.generateSortedArray;
import static com.unrec.algorithms.utils.DataProvider.randomArrayItem;
import static com.unrec.algorithms.utils.DataProvider.randomPositiveInt;


@State(Scope.Benchmark)
public class SearchExecutionPlan {

    @Param({"100000", "200000", "300000", "400000", "500000", "600000", "700000", "800000", "900000",
            "1000000", "2000000", "3000000", "4000000", "5000000", "6000000", "7000000", "8000000", "9000000",
            "10000000", "20000000", "30000000", "40000000", "50000000", "60000000", "70000000", "80000000", "90000000",
            "100000000", "150000000", "200000000"})
    public int arraySize;

    public int[] array;
    public int target;

    @Setup(Level.Trial)
    public void setUp() {
        array = generateSortedArray(arraySize, randomPositiveInt());
        target = randomArrayItem(array);
    }
}