package l_designpatterns.behavioral;

import java.util.*;

// observer interface
interface Subscriber {
    public void update(String video);
}

// subject interface
// provides methods for managing observers: add, remove, notify
interface YoutubeChannel {
    public void addSubscriber(Subscriber sub);

    public void removeSubscriber(Subscriber sub);

    public void notifySubscriber();
}

// concrete subject implementation
// manages the observer list(subscribers) & calls notifySubscriber
// automatically whenever new data arrives
class YoutubeChannelImpl implements YoutubeChannel {
    private List<Subscriber> subscribers = new ArrayList<>();
    private String video;

    @Override
    public void addSubscriber(Subscriber sub) {
        subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(Subscriber sub) {
        subscribers.remove(sub);
    }

    @Override
    public void notifySubscriber() {
        for (Subscriber sub : subscribers) {
            sub.update(video);
        }
    }

    public void uploadNewVideo(String video) {
        this.video = video;
        notifySubscriber();
    }
}

/*
 * concrete observers implementation - own update logic
 */
class EmailSubscriber implements Subscriber {
    private String email;

    EmailSubscriber(String email) {
        this.email = email;
    }

    @Override
    public void update(String video) {
        System.out.println(email + " email - new video: " + video);
    }
}

class PushNotificationSubscriber implements Subscriber {
    private String device;

    PushNotificationSubscriber(String device) {
        this.device = device;
    }

    @Override
    public void update(String video) {
        System.out.println(device + " user device - new video: " + video);
    }
}

// client code
public class Observer {
    public static void main(String[] args) {
        YoutubeChannelImpl channel = new YoutubeChannelImpl();

        Subscriber s1 = new EmailSubscriber("anubhav");
        Subscriber s2 = new PushNotificationSubscriber("android101");

        channel.addSubscriber(s1);
        channel.addSubscriber(s2);

        channel.uploadNewVideo("Avengers trailer");

    }
}
