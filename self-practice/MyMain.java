// Create an EmailNotification class that extends an abstract Message class and implements a Notification interface,
// then demonstrates inheritance, interface implementation, and polymorphism in MyMain.java.

interface Notification {
    void getChannel();
}

abstract class Message {
    String getMessage(int id){
        return "order " + id + " sent";
    }
}

class EmailNotification extends Message implements Notification {

    public void getChannel(){
        System.out.println("Notify via email");
    }
}

class SlackNotification extends Message implements Notification {

    public void getChannel(){
        System.out.println("Notify via slack");
    }
}

public class MyMain{
    public static void main(String[] args){
        EmailNotification emailObj = new EmailNotification();
        notifyObj.getChannel("Email");
        System.out.println(notifyObj.getMessage(505));

        SlackNotification slackObj = new SlackNotification();
        slackObj.getChannel();
        System.out.println(slackObj.getMessage(506));
    }
}