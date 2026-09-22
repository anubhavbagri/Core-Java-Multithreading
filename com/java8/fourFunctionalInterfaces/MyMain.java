package com.java8.fourFunctionalInterfaces;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MyMain {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(
                Arrays.asList("Alice", "Bob", "Charlie", "Dave", "Eve"));

        System.out.println(names + "\n");

        // Predicate example

        Predicate<String> isLong = (name) -> name.length() > 4;
        names.removeIf(isLong);

        System.out.println(names);

        // Function example

        Function<String, Integer> toLength = (name) -> name.length();
        List<Integer> sizes = names.stream()
                .map(toLength)
                .collect(Collectors.toList());

        System.out.println(sizes);

        // Consumer example

        Consumer<String> display = (name) -> System.out.println(name + " hi");
        names.forEach(display);

        // supplier example

        Supplier<Integer> randNum = () -> new Random().nextInt(10);
        System.out.println(randNum.get());
        System.out.println(randNum.get());
    }
}
