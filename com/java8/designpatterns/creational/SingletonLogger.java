package com.java8.designpatterns.creational;

enum LogLevel {
    DEBUG, INFO, WARN
}

class Logger {
    private static Logger logger;

    private Logger() {
    }

    public static Logger getLogger() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void display(LogLevel l, String msg) {
        System.out.println("Level : [" + l + "] " + msg);
    }
}

public class SingletonLogger {
    public static void main(String[] args) {
        Logger l1 = Logger.getLogger();
        Logger l2 = Logger.getLogger();
        Logger l3 = Logger.getLogger();

        l1.display(LogLevel.INFO, "hello world 1");
        l2.display(LogLevel.DEBUG, "hello world 12");
        l3.display(LogLevel.WARN, "hello world 123");
    }
}
