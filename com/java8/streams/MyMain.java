package com.java8.streams;

import java.util.*;
import java.util.function.*;

import javax.sql.rowset.spi.SyncResolver;

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

        // int[] count = { 0 };

        // salaries.stream()
        // .distinct()
        // .sorted((a, b) -> b - a)
        // .filter(n -> ++count[0] == 3)
        // .forEach(System.out::print);

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
    }
}

class C {
    public static void call() {
    }
}

public class MyMain {
    public static void main(String[] args) {
        A.call();
        System.out.println();
        B.call();
        System.out.println();
        C.call();
    }
}
