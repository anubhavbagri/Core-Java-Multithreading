package com.java8.designpatterns.creational.singleton;

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
        l2.display(LogLevel.DEBUG, "hello world 2");
        l3.display(LogLevel.WARN, "hello world 3");
    }
}

// Student impl = new Student("anubhav", 100)
// Json obj = new Json("https://dummyjson.com/RESOURCE/?limit=10&skip=5&select=key1,key2,key3", "cricbuzz.com/api/v1/")
// Json obj2 = new Json1(getJsonFile(int i, String s, boolean f), 100, "xyz")
// Json obj3 = Builder.getJsonFile(3mb);