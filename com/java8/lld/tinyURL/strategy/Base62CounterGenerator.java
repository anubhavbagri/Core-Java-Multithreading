package com.java8.lld.tinyURL.strategy;

/*
Extensibility: use AtomicLong when multiple threads try to call `generate()` simultaneously & we need
thread-safe increment. For a single threaded learning example, using simple `long`
 */

public class Base62CounterGenerator implements ShortCodeGenerator {

    private long counter = 10000000;

    @Override
    public String generate() {
        counter++;
        return toBase62(counter);
    }

    public String toBase62(long n) {
        final String B62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(B62.charAt((int) (n % 62)));
            n /= 62;
        }
        return sb.reverse().toString();
    }
}
