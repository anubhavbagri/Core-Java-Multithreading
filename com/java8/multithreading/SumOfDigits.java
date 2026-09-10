package com.java8.multithreading;

/*
Find Sum of Digits From A Given Number (Hint: Use Some Shared Resource).
Input is 123, Output is 1+2+3 => The Sum Operation Must Be Done Using Multithreading, Here, Total 3 Extra Threads Created.
For Input 12345, Total 5 Threads Needed.
*/

import java.util.*;

public class SumOfDigits {
    private int sum = 0; // class field - accessible by all threads

    public int sum(int n) {
        int c = 0;
        int temp = n;

        while (temp > 0) {
            c++;
            temp = temp / 10;
        }

        int[] digits = new int[c];
        for (int i = c - 1; i >= 0; i--) {
            digits[i] = n % 10;
            n /= 10;
        }

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < c; i++) {
            final int position = i;
            Thread th = new Thread(() -> {
                int digit = digits[position];
                synchronized (this) {
                    sum += digit;
                    System.out.println(sum + " " + Thread.currentThread().getName());
                }
            });
            threads.add(th);
        }

        for (Thread th : threads) {
            th.start();
        }

        for (Thread th : threads) {
            try {
                th.join();
            } catch (Exception e) {
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new SumOfDigits().sum(123));
    }
}
