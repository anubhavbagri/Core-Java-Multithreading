package l_designpatterns.creational;

/*
Abstract product interface
*/
interface Button {
    public void onClick();
}

interface TextField {
    public void onSelect();
}

/*
 * Concrete product class
 */
class WindowsButton implements Button {
    @Override
    public void onClick() {
        System.out.println("windows button clicked.");
    }
}

class MacButton implements Button {
    @Override
    public void onClick() {
        System.out.println("mac button clicked.");
    }
}

class WindowsTextField implements TextField {
    @Override
    public void onSelect() {
        System.out.println("windows textfield selected.");
    }
}

class MacTextField implements TextField {
    @Override
    public void onSelect() {
        System.out.println("mac textfield selected.");
    }
}

/*
 * Abstract factory interface
 */
interface UIFactory {
    public Button createButton();

    public TextField createTextField();
}

/*
 * Concrete factory class
 */
class WindowsFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public TextField createTextField() {
        return new WindowsTextField();
    }
}

class MacFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public TextField createTextField() {
        return new MacTextField();
    }
}

/*
 * Abstract factory pattern: client doesn't know if it's using windows or mac
 * components hence, uses only abstract factory interface
 */
public class AbstractFactory {
    public static void main(String[] args) {
        // Change to "windows" and everything still works.
        // The entire UI family switches consistently. No mixing.
        String os = "mac";

        // only instantiate concrete factories here - nowhere else in the code
        UIFactory factory;
        factory = os.equals("windows") ? new WindowsFactory() : new MacFactory();

        // The client doesn't care which button or textfield it got - WindowsButton or
        // MacButton.
        // It just knows it's a Button.
        Button btn = factory.createButton();
        TextField tf = factory.createTextField();

        btn.onClick();
        tf.onSelect();
    }
}
