package k_streamAPI;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// Stream API is used to process collections of objects in a functional-style and declarative way
// A Stream in java is a sequence of elements that supports various methods which
// can be pipelined to produce the desired result (often using lambda expressions)
// no storage, only pipeline of functions

public class Main {
    public static void main(String[] args) {
        // 1. filter Odd numbers

        List<Integer> numList = List.of(10, 20, 5, 8, 30, 25);

        Predicate<Integer> checkOdd = (n) -> n % 2 != 0;
        List<Integer> oddNumbers = numList.stream()
                .filter(checkOdd)
                .collect(Collectors.toList());

        System.out.println(oddNumbers);

        // 2. find the second largest number

        Optional<Integer> secondLargest = numList.stream()
                .distinct()
                .sorted((a, b) -> Integer.compare(b, a))
                .skip(1)
                .findFirst();

        Consumer<Integer> display = (num) -> System.out.println("Second largest: " + num);
        secondLargest.ifPresentOrElse(display, () -> System.out.println("not enough elements"));

    }
}
