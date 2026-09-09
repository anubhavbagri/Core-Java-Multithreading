package h_lambda;

// Functional Interface: exactly 1 abstract method (SAM = Single Abstract Method)
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

public class Main {
    public static void main(String[] args) {
        int x = 10, y = 5;

        // ============ APPROACH 1: Anonymous Inner Class (pre-Java 8) ============
        Calculator add1 = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a + b + 2;
            }
        };
        System.out.println("Anonymous inner class result: " + add1.calculate(x, y));

        // ============ APPROACH 2: Lambda Expression (Java 8+) ============
        // Unnamed class implementing an interface (Anonymous Inner Class)
        // Lambda syntax: (parameters) -> { body }
        // Same logic, but much less code
        Calculator add2 = (a, b) -> a + b; // single-line version
        System.out.println("Lambda result (inline): " + add2.calculate(x, y));

        // Multi-line lambda
        Calculator add3 = (a, b) -> {
            System.out.println("Adding " + a + " and " + b);
            return a + b;
        };
        System.out.println("Lambda result (multi-line): " + add3.calculate(x, y));

        // ============ APPROACH 3: Named Inner Class ============
        // (This is NOT anonymous — it has a name)
        class Subtract implements Calculator {
            @Override
            public int calculate(int a, int b) {
                return a - b;
            }
        }

        Calculator sub = new Subtract();
        System.out.println("Named inner class result: " + sub.calculate(x, y));

        // ============ PROOF: All are objects implementing the same interface
        // ============
        System.out.println("\nAll implement Calculator? " +
                (add1 instanceof Calculator && add2 instanceof Calculator && sub instanceof Calculator));

    }
}
