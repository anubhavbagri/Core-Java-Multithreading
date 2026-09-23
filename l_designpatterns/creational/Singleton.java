package l_designpatterns.creational;

class Logger {
    private static volatile Logger logger;

    private Logger() {
    }

    public static Logger getLogger() {
        synchronized (Logger.class) {
            if (logger == null) {
                logger = new Logger();
            }
        }
        return logger;
    }

    public void log(String msg) {
        System.out.println("[LOG] " + msg);
    }
}

public class Singleton {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger();
        logger.log("App started");
    }
}
