package com.java8.streams;

import java.util.*;
import java.util.function.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// 1. find only odd numbers from a stream
class A {
    public static void call() {
        List<Integer> numList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Predicate<Integer> isOdd = (n) -> n % 2 != 0;
        // Consumer<Integer> print = (n) -> System.out.print(n + " ");

        numList.stream()
                .filter(n -> n % 2 != 0)
                .forEach(n -> System.out.print(n + " "));
    }
}

// 2. find & print 2nd highest salary from a list of salaries
class B {
    public static void call() {
        List<Integer> salaries = List.of(50000, 30000, 25000, 60000, 25000);

        int[] count = { 0 };

        // not readable but time efficient
        salaries.stream()
                .distinct()
                .sorted((a, b) -> b - a)
                .filter(n -> ++count[0] == 2)
                .forEach(System.out::println);

        // readable but not time efficient since for each item of the stream, new object
        // is being created
        salaries.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .forEach(new Consumer<Integer>() {
                    int count = 0;

                    @Override
                    public void accept(Integer t) {
                        if (++count == 2) {
                            System.out.println(t);
                        }
                    }
                });

        salaries.stream()
                .distinct()
                .sorted((a, b) -> b - a)
                .skip(1)
                .findFirst()
                .ifPresent(System.out::print);
    }
}

// 3. find sum of digits of a given number using stream api

class C {
    public static void call() {
    }
}

// 4. print only prime numbers from 1 to n using stream api
class D {
    public static void call() {
        int n = 10;

        Supplier<Integer> s = new Supplier<Integer>() {
            int i = 1;

            @Override
            public Integer get() {
                return i++;
            }
        };

        Predicate<Integer> isPrime = (num) -> num > 1 && IntStream.range(2, num)
                .noneMatch(i -> num % i == 0);

        Stream.generate(s)
                .limit(n)
                .filter(isPrime)
                .forEach(System.out::println);

    }

}

public class MyMain {
    public static void main(String[] args) {
        A.call();
        System.out.println();
        B.call();
        System.out.println();
        C.call();
        System.out.println("Prime numbers: ");
        D.call();
    }
}
