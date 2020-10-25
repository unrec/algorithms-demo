package com.unrec.algorithms.etc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FibonacciDemo {
    public static void main(String[] args) {

        int number = ThreadLocalRandom.current().nextInt(50);
        System.out.println("number = " + number);
        System.out.println("Fibonacci recursive = " + fibonacciRecursive(number));
        System.out.println("Fibonacci iterative = " + fibonacciIterative(number));
    }

    private static int fibonacciRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The number should be positive.");
        }

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    private static int fibonacciIterative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The number should be positive.");
        }

        int prev;
        int beforeprev;

        List<Integer> numbers = new ArrayList<>(n);
        numbers.add(0);
        numbers.add(1);
        int i = 2;

        while (i <= n) {
            prev = numbers.get(i - 1);
            beforeprev = numbers.get(i - 2);
            numbers.add(prev + beforeprev);
            i++;
        }
        return numbers.get(n);
    }
}