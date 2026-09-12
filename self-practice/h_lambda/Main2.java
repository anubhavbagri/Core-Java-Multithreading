package h_lambda;

@FunctionalInterface
interface Validator {
    boolean validate(String name);
}

public class Main2 {
    public static void main(String[] args) {
        Validator nonEmpty = (name) -> !name.isEmpty();

        Validator isLongerThanFive = (name) -> name.length() > 5;

        Validator both = (name) -> nonEmpty.validate(name) && isLongerThanFive.validate(name);

        System.out.println(both.validate("Hello World"));
    }
}
