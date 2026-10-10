package l_designpatterns.structural.facade;

/*
Home Theatre System
Without a facade, every part of your application that wants to play a movie (a remote control app,
a voice assistant integration, a scheduled movie night feature) needs to know all those steps.
A HomeTheaterFacade wraps them into watchMovie() and endMovie().
*/
class SmartLights {
    public void dim(int level) {
        System.out.println("Lights: Dimmed to: " + level);
    }

    public void on() {
        System.out.println("Lights: full brightness");
    }
}

class Projector {
    public void on() {
        System.out.println("Projector: Warming up.");
    }

    public void off() {
        System.out.println("Projector: Cooling down.");
    }

    public void wideScreenMode() {
        System.out.println("Projector: Widescreen mode enabled.");
    }
}

class Speaker {
    public void on() {
        System.out.println("Speaker: Powering on.");
    }

    public void off() {
        System.out.println("Speaker: Shutting down.");
    }

    public void setVolume(int level) {
        System.out.println("Speaker: Volume set to: " + level);
    }
}

class HomeTheatreFacade {
    private Projector projector;
    private SmartLights lights;
    private Speaker speaker;

    public HomeTheatreFacade(Projector projector, SmartLights lights, Speaker speaker) {
        this.projector = projector;
        this.lights = lights;
        this.speaker = speaker;
    }

    public void watchMovie(String movie) {
        System.out.println("Preparing to watch: " + movie);
        lights.dim(10);
        projector.on();
        projector.wideScreenMode();
        speaker.on();
        speaker.setVolume(20);
        System.out.println(" ---Enjoy the movie--- ");
    }

    public void endMovie() {
        System.out.println("\nShutting down home theatre");
        speaker.off();
        projector.off();
        lights.on();
        System.out.println("Home theatre off");
    }
}

public class Facade {
    public static void main(String[] args) {
        SmartLights lights = new SmartLights();
        Projector projector = new Projector();
        Speaker speaker = new Speaker();

        HomeTheatreFacade theatre1 = new HomeTheatreFacade(projector, lights, speaker);
        theatre1.watchMovie("Odyssey");
        theatre1.endMovie();

        HomeTheatreFacade theatre2 = new HomeTheatreFacade(projector, lights, speaker);
        theatre2.watchMovie("Odyssey");
        theatre2.endMovie();
    }
}
/*
 * Notice how the client does not care about the order of operations, which
 * devices to power on first,
 * or how to properly shut everything down. The facade handles all of that. If
 * you later add a subwoofer
 * or a screen, you update the facade and every client automatically gets the
 * new behavior.
 */