package com.java8.multithreading;

import java.io.*;
import java.util.*;

/*
Read A Large Text File Using Multithreading and Chunk Based-> Processing.
Hint: The sequence doesn't matter, reading faster is important
*/

public class ChunkBasedFileRead {

    public static long singleThreadedRead(String filename) throws IOException {
        System.out.println("\n--- Single Threaded Read ---");
        long start = System.nanoTime();

        RandomAccessFile raf = new RandomAccessFile(filename, "r");
        byte[] buffer = new byte[(int) raf.length()];
        raf.read(buffer);
        raf.close();

        String content = new String(buffer);
        System.out.println(content);

        long end = System.nanoTime();
        long durationMs = (end - start) / 1_000_000;

        return durationMs;
    }

    public static long multiThreadedRead(String filename, int numThreads) throws IOException {
        System.out.println("\n### Start ###");

        long startTime = System.nanoTime();

        // Step 1: Get file size
        RandomAccessFile rafSize = new RandomAccessFile(filename, "r");
        long fileSize = rafSize.length();
        rafSize.close();

        long chunkSize = fileSize / numThreads;

        // Step 2: Create and store threads
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < numThreads; i++) {
            final int idx = i;
            final long start = idx * chunkSize;
            final long end = (idx == numThreads - 1) ? fileSize : (idx + 1) * chunkSize; // last thread reads until end
                                                                                         // of file

            Thread th = new Thread(() -> {
                try {

                    RandomAccessFile raf = new RandomAccessFile(filename, "r");
                    raf.seek(start);

                    byte[] buffer = new byte[(int) (end - start)];
                    raf.read(buffer);
                    raf.close();

                    String content = new String(buffer);

                    String[] lines = content.split("\\n");
                    StringBuilder sb = new StringBuilder();
                    for (String line : lines) {
                        String trimmed = line.trim();
                        if (!trimmed.isEmpty())
                            sb.append(trimmed).append("\n");
                    }

                    System.out.println(" ---Thread " + idx);
                    System.out.println(sb.toString());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            threads.add(th);
        }

        // Step 3: Start all threads
        for (Thread th : threads)
            th.start();

        // Step 4: wait for all threads
        for (Thread th : threads) {
            try {
                th.join();
            } catch (Exception e) {
            }
        }
        long endTime = System.nanoTime();

        System.out.println("### Done ###");

        long durationMs = (endTime - startTime) / 1_000_000;
        return durationMs;
    }

    public static void main(String[] args) throws Exception {
        String filename = "dummy.txt";
        // generateLargeFile("sample.txt", 1);

        // long singleTime = singleThreadedRead(filename);

        long multiTime2 = multiThreadedRead(filename, 2);
        long multiTime4 = multiThreadedRead(filename, 4);
        long multiTime8 = multiThreadedRead(filename, 8);

        // Compare
        System.out.println("\n========= PERFORMANCE COMPARISON =========");
        // System.out.println("Single thread: " + singleTime + " ms");
        System.out.println("2 threads:      " + multiTime2 + " ms");
        System.out.println("4 threads:      " + multiTime4 + " ms");
        System.out.println("8 threads:      " + multiTime8 + " ms");

        // int cores = Runtime.getRuntime().availableProcessors();
        // System.out.println("Available cores: " + cores);
    }
}
