package g_abstraction;

// Can an abstract class implement an interface? If yes, why would you do it?
// Yes, an abstract class can implement an interface to provide partial implementation.
// This is useful when some methods in the interface have common logic that can be shared across subclasses

interface Pet {
    void play();
}

abstract class BaseAnimal implements Pet {
    String name;
    BaseAnimal(String name){
        this.name = name;
    }

    abstract void sound();

    @Override
    public void play(){
        System.out.println(name + " plays.");
    }
}

class Horse extends BaseAnimal {
    Horse(String name){
        super(name);
    }

    @Override
    public void sound(){
        System.out.println(name + " neighs.");
    }
}

public class Main2 {
    public static void main(String[] args){
        Horse horse = new Horse("Charlie");
        horse.sound();
        horse.play();
    }
}
