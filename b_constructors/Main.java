package b_constructors;

// Types of constructors

class Movie {
  private String title; // Default: null
  private int duration; // Default: 0


  // implicit default constructor

  public void displayDetails() {
    System.out.println("Title: " + title + ", Duration: " + duration + " mins");
  }
}


class Movie1 {
  private String title;
  private int duration;


  // Custom default constructor
  public Movie1() {
    this.title = "Untitled";
    this.duration = 90;
  }
  public void displayDetails() {
    System.out.println("Title: " + title + ", Duration: " + duration + " mins");
  }
}


class Movie2 {
  private String title;
  private int duration;


  // Parameterized constructor
  public Movie2(String title, int duration) {
    this.title = title;
    this.duration = duration;
  }

    // Copy constructor
  public Movie2(Movie2 other) {
    this.title = other.title;
    this.duration = other.duration;
  }

  public void displayDetails() {
    System.out.println("Title: " + title + ", Duration: " + duration + " mins");
  }
}


class Singleton {
    private static Singleton instance;
    // Private constructor
    private Singleton(){}
    public static Singleton getInstance() {
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}


public class Main {
  public static void main(String[] args) {
    Movie movie = new Movie(); // Implicit default constructor is called
    movie.displayDetails(); // Displays default values


    Movie1 movie1 = new Movie1(); // Custom default constructor is called
    movie1.displayDetails(); // Displays custom default values


    Movie2 movie2 = new Movie2("Inception", 148); // Parameterized constructor is called
    movie2.displayDetails();


    // attempting to create an object with no arguments will result in compilation error
    // Movie2 example = new Movie2();
    // System.out.println(example);

    Movie2 copy = new Movie2(movie2);   // Copy constructor is called
    copy.displayDetails();


    Singleton s1 = Singleton.getInstance();
    Singleton s2 = Singleton.getInstance();
    System.out.println(s1 == s2);   // true, as both references point to the same instance
  }
}

