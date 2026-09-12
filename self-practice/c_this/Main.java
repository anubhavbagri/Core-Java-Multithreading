package c_this;

class Person{
    private String name;
    private int age;

    // constructor 1
    Person(String name){
        this(name, 0);  //calls constructor 2
    }

    Person(String name, int age){
        // resolves conflict between instance variable and parameter
        this.name = name;
        this.age = age;
    }

    Person setName(String name){
        this.name = name;
        this.age = 12;
        return this;    // Enables method chaining
    }

    void greet(Person person){
        System.out.println("Hello, " + person);
    }

    void introduce(){
        greet(this);    // passes the current object as parameter
    }

    void display(){
        System.out.println("Name: " + this.name + ", Age: " + this.age);
    }

    @Override
    public String toString(){
        // by default, if not overridden: displays classname@hashcode
        return "I am a person instance";
    }
}

public class Main {
    public static void main(String[] args){
        Person p = new Person("Anubhav");
        p.display();

        p.setName("Alice").display();

        Person p3 = p.setName("Alice");
        System.out.println(p == p3);    // Compares memory references, returns true

        p.introduce();
    }
}
