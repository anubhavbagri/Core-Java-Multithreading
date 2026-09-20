package com.java8.streams;

import java.util.*;

// find only odd numbers from a stream
class A {
    public static void call() {
        List<Integer> numList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Predicate<Integer> isOdd = (n) -> n % 2 != 0;

        List<Integer> oddNum = numList.stream()
                .filter(n -> n % 2 != 0)
                .toList();

        System.out.println("Odd numbers: " + oddNum);

    }
}

class B {
    public static void call() {
    }
}

class C {
    public static void call() {
    }
}

public class MyMain {
    public static void main(String[] args) {
        A.call();
        B.call();
        C.call();
    }
}
