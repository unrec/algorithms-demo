package com.unrec.algorithms.etc;

import java.util.concurrent.ThreadLocalRandom;

public class FactorialDemo {
    public static void main(String[] args) {

        int number = ThreadLocalRandom.current().nextInt(20);
        System.out.println("number = " + number);
        System.out.println("Factorial recursive = " + factorialRecursive(number));
        System.out.println("Factorial iterative = " + factorialIterative(number));
    }

    private static long factorialRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The number should be positive.");
        }
        if (n == 1) {
            return 1;
        }
        return n * factorialRecursive(n - 1);
    }

    private static long factorialIterative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The number should be positive.");
        }

        if (n == 1) {
            return 1;
        }

        long result = 1;
        for (int i = n; i > 1; i--) {
            result *= i;
        }
        return result;
    }
}