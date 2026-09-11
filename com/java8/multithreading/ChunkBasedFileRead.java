package com.java8.multithreading;

import java.io.*;
import java.util.*;

public class ChunkBasedFileRead {

    // public static void generateLargeFile(String filename, long sizeInMB) {
    // try (BufferedOutputStream out = new BufferedOutputStream(new
    // FileOutputStream(filename))) {

    // byte[] data = "The quick brown fox jumped over the lazy dog ".getBytes();

    // long targetBytes = sizeInMB * 1024 * 1024;
    // long writtenBytes = 0;

    // while (writtenBytes < targetBytes) {
    // out.write(data);
    // writtenBytes += data.length;
    // }
    // } catch (IOException e) {

    // }
    // }

    public static long singleThreadedRead(String filename) throws IOException {
        System.out.println("\n--- Single Threaded Read ---");
        long start = System.nanoTime();

        // Read entire file into byte array
        File file = new File(filename);
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        byte[] buffer = new byte[(int) raf.length()];
        raf.read(buffer);
        raf.close();

        // Same split logic as multithreaded
        String content = new String(buffer);
        String[] words = content.split("\\s+");

        int totalWords = words.length;

        long end = System.nanoTime();
        long durationMs = (end - start) / 1_000_000;

        System.out.println("Total Words: " + totalWords);
        System.out.println("Time: " + durationMs + " ms\n");

        return durationMs;
    }

    public static long multiThreadedRead(String filename, int numThreads) throws IOException {
        long startTime = System.nanoTime();

        // Step 1: Get file size
        RandomAccessFile rafSize = new RandomAccessFile(filename, "r");
        long fileSize = rafSize.length();
        rafSize.close();

        long chunkSize = fileSize / numThreads;

        // Step 2: Shared array - each thread writes to its own index
        int[] wordCounts = new int[numThreads];

        // Step 3: Create and store threads
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
                    String[] words = content.split("\\s+");

                    wordCounts[idx] = words.length;

                    System.out
                            .println("Thread " + idx + " | Start: " + start + " | End: " + end + " | Words: "
                                    + wordCounts[idx]);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            threads.add(th);
        }

        // Step 4: Start all threads
        for (Thread th : threads)
            th.start();

        // Step 5: wait for all threads
        for (Thread th : threads) {
            try {
                th.join();
            } catch (Exception e) {
            }
        }

        // Step 6: combine results in main thread
        long totalWords = 0;
        for (int cnt : wordCounts)
            totalWords += cnt;

        long endTime = System.nanoTime();
        long durationMs = (endTime - startTime) / 1_000_000;

        System.out.println("Words: " + totalWords);
        System.out.println("Time: " + durationMs + " ms\n");

        return durationMs;
    }

    public static void main(String[] args) throws Exception {
        String filename = "sample.txt";
        // generateLargeFile("sample.txt", 1);

        long singleTime = singleThreadedRead(filename);

        long multiTime2 = multiThreadedRead(filename, 2);
        long multiTime4 = multiThreadedRead(filename, 4);
        long multiTime8 = multiThreadedRead(filename, 8);

        // Compare
        System.out.println("\n========= PERFORMANCE COMPARISON =========");
        System.out.println("Single thread:  " + singleTime + " ms");
        System.out.println("2 threads:      " + multiTime2 + " ms");
        System.out.println("4 threads:      " + multiTime4 + " ms");
        System.out.println("8 threads:      " + multiTime8 + " ms");

        // int cores = Runtime.getRuntime().availableProcessors();
        // System.out.println("Available cores: " + cores);
    }
}
