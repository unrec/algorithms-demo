package com.unrec.algorithms.sort;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import java.util.concurrent.TimeUnit;

public class MergeSortBenchmarkTest {

    private static final MergeSort mergeSort = new MergeSort();

    @Test
    public void runBenchmark() throws Exception {
        Options options = new OptionsBuilder()
                .include(this.getClass().getName() + ".*")
                .mode(Mode.AverageTime)
                .forks(1)
                .threads(1)
                .warmupIterations(1)
                .measurementIterations(1)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .build();

        new Runner(options).run();
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void mergeSort(SortExecutionPlan plan) {

        int[] array = plan.array;
        mergeSort.sort(array, 0, array.length - 1);
    }
}