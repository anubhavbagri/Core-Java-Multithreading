package l_designpatterns.creational;

interface Notification {
    public void send(String msg);
}

class EmailNotification implements Notification {
    @Override
    public void send(String msg) {
        System.out.println("Sending email: " + msg);
    }
}

class SMSNotification implements Notification {
    @Override
    public void send(String msg) {
        System.out.println("Sending SMS: " + msg);
    }
}

abstract class NotificationCreator {
    public abstract Notification createNotification();

    public void send(String msg) {
        Notification notification = createNotification();
        notification.send(msg);
    }
}

class EmailNotificationCreator extends NotificationCreator {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}

class SMSNotificationCreator extends NotificationCreator {
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}

public class Factory {
    public static void main(String[] args) {
        NotificationCreator creator;

        creator = new EmailNotificationCreator();
        creator.send("hello world");

        creator = new SMSNotificationCreator();
        creator.send("otp scam");
    }
}

