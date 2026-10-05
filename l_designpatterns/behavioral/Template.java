package l_designpatterns.behavioral;

// abstract class that defines skeleton of beverage preparation
abstract class Beverage {
    // template method
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    // commmon steps
    protected void boilWater() {
        System.out.println("Boiling water...");
    }

    protected void pourInCup() {
        System.out.println("Pouring into cup...");
    }

    // steps to be customized by subclasses
    protected abstract void brew();

    protected abstract void addCondiments();
}

// concrete implementation for coffee
class CoffeeBeverage extends Beverage {

    @Override
    protected void brew() {
        System.out.println("Brewing coffee");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding milk & sugar");
    }

}

// concrete implementation for tea
class TeaBeverage extends Beverage {

    @Override
    protected void brew() {
        System.out.println("Adding tea leaves");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon");
    }

}

// client
public class Template {
    public static void main(String[] args) {
        Beverage coffee = new CoffeeBeverage();
        Beverage tea = new TeaBeverage();

        System.out.println("\nCoffee Prep");
        coffee.prepareRecipe();

        System.out.println("\nTea Prep");
        tea.prepareRecipe();
    }
}
