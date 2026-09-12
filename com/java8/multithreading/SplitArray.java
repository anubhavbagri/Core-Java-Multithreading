package com.java8.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

/*
Split An Array To 2 Parts, Now Use Exactly 2 Thread to Calculate Sum of Both Parts and Send To Main Thread, The Main Thread Will Find & return Larger Sum Among The 2 Sub Sums.

5 7 3 2 1 6 4 8 1 -> Input Array

	5 7 3 2 1 -> Part 1, For Thread 1
	6 4 8 1 -> Part 2, For Thread 2

Main Will Do Now -> Who is Larger (5+7+3+2+1) OR (9+6+4+8+1)
*/

public class SplitArray {

    public int largerSum(int[] arr) {

        int n = arr.length;
        int mid = n / 2;

        AtomicInteger s1 = new AtomicInteger(0);
        AtomicInteger s2 = new AtomicInteger(0);

        Thread th1 = new Thread(() -> {
            for (int i = 0; i < mid; i++) {
                s1.addAndGet(arr[i]); // thread safe increment
                System.out.println("s1 = " + s1 + " " + Thread.currentThread().getName());
            }
        }, "myThread-1");

        Thread th2 = new Thread(() -> {
            for (int i = mid; i < n; i++) {
                s2.addAndGet(arr[i]); // thread safe increment
                System.out.println("s2 = " + s2 + " " + Thread.currentThread().getName());
            }
        }, "myThread-2");

        th1.start();
        th2.start();

        try {
            th1.join(); // forces main thread to wait for thread 1
            th2.join(); // forces main thread to wait for thread 2
        } catch (Exception e) {
        }

        return Math.max(s1.get(), s2.get());

    }

    public static void main(String[] args) {
        int a[] = { -2, 1, 2, 3, 4, -5 };
        System.out.println(new SplitArray().largerSum(a));
    }
}
