package com.unrec.algorithms.search;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySearchBenchmarkTest {

    private static SearchAlgorithm binaryIterative = new BinarySearchIterative();
    private static SearchAlgorithm binaryRecursive = new BinarySearchRecursive();

    @Test
    public void runBenchmarks() throws Exception {
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
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void binarySearchIterativeBenchmark(SearchExecutionPlan plan) {

        //given
        int[] array = plan.array;
        int target = plan.target;

        //when
        int result = binaryIterative.find(array, 0, array.length, target);

        //then
        assertTrue(result != -1);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void binarySearchRecursiveBenchmark(SearchExecutionPlan plan) {

        //given
        int[] array = plan.array;
        int target = plan.target;

        //when
        int result = binaryRecursive.find(array, 0, array.length, target);

        //then
        assertTrue(result != -1);
    }
}