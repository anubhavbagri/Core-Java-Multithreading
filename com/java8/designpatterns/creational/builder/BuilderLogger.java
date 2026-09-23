package com.java8.designpatterns.creational.builder;

class Logger {
    private String logLevel;

    // private constructor, ensuring its only created through the builder
    private Logger(LoggerBuilder builder) {
        this.logLevel = builder.logLevel;
    }

    public void display(String msg) {
        System.out.println("Level : [" + logLevel + "] " + msg);
    }

    /*
    LoggerBuilder - nested class
    Encapsulation: LoggerBuilder is tightly related to the Logger class so its grouped inside it
    This makes it clear that the builder is for creating Logger objects
    */
    public static class LoggerBuilder {
        // same attributes as Logger but they are mutable
        private String logLevel = "INFO"; // default value

        public LoggerBuilder setLogLevel(String logLevel) {
            this.logLevel = logLevel;
            return this;
        }

        // build method to create a Logger object
        public Logger build() {
            return new Logger(this); // return a new Logger created using the builder's values
        }
    }
}

public class BuilderLogger {
    public static void main(String[] args) {
        // creating the logger using the builder pattern
        Logger.LoggerBuilder builder = new Logger.LoggerBuilder();

        Logger l1 = builder.build(); // the build method returns the final product

        Logger l2 = builder.setLogLevel("DEBUG")
                .build();

        Logger l3 = builder.setLogLevel("WARN")
                .build();

        l1.display("hello world 1");
        l2.display("hello world 2");
        l3.display("hello world 3");
    }
}
