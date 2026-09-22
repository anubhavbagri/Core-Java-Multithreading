package com.java8.collections;

import java.util.*;

/*
 * FOUR MAJOR OPERATIONS:
 * 1. stream creation: list.stream()
 * 2. intermediate operations: for eg. filter(), map(), reduce()
 * 3. terminal operation: for eg. collect(), forEach(), count()
 * 4. pipe line: connect operations together - stream() -> filter() -> map() ->
 * collect()
 *
 */

public class MyMain {
    public static void main(String[] args) {
        List<Integer> list = List.of(10, 20, 30, 40, 50);

        list
                .stream()
                .filter(data -> data > 20)
                .forEach(data -> System.out.println(data));
    }
}
