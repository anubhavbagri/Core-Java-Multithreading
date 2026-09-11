package com.java8.multithreading;

import java.util.concurrent.locks.*;;

public class ReaderWriter {
    private int data = 0; // shared resource/data - readers read this, writers update this

    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock(); // shared lock
    private final Lock writeLock = rwLock.writeLock(); // exclusive lock

    public int read(String readerName) {
        readLock.lock(); // multiple threads can hold readLock simultaneously
        try {
            System.out.println(readerName + " is reading: " + data); // active readers can overlap
            Thread.sleep(50);
            return data;
        } catch (Exception e) {
            return -1;
        } finally {
            readLock.unlock();
            System.out.println(readerName + " done reading");
        }
    }

    public void write(String writerName, int value) {
        writeLock.lock(); // ONLY ONE thread can hold writeLock
        try {
            System.out.println(writerName + " is writing: " + value); // all readers blocked
            Thread.sleep(50);
            data = value;
            System.out.println(writerName + " finished writing: " + data);
        } catch (Exception e) {
        } finally {
            writeLock.unlock();
        }
    }

    public static void runReadWriteLock(ReaderWriter rw) {
        rw.data = 0;

        Thread r1 = new Thread(() -> rw.read("Reader-1"));
        Thread r2 = new Thread(() -> rw.read("Reader-2"));
        Thread r3 = new Thread(() -> rw.read("Reader-3"));

        Thread w1 = new Thread(() -> rw.write("Writer-1", 100));
        Thread w2 = new Thread(() -> rw.write("Writer-2", 200));

        r1.start();
        r2.start();
        r3.start();
        w1.start();
        w2.start();

        try {
            r1.join();
            r2.join();
            r3.join();
            w1.join();
            w1.join();
        } catch (Exception e) {
        }

    }

    public static void main(String[] args) {
        ReaderWriter rw = new ReaderWriter();

        runReadWriteLock(rw);
    }

}
