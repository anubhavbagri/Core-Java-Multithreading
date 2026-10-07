package l_designpatterns.behavioral;

import java.util.*;

// element
// entrypoint for double dispatch mechanism
interface Shape {
    void accept(ShapeVisitor visitor);
}

/*
 * Concrete elements
 * implements the accept() method by calling the visitor's corresponding visit
 * method, passing this
 */
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visitCircle(this);
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visitRectangle(this);
    }
}

/*
 * visitor
 * declares a visit method for each concrete element type
 */
interface ShapeVisitor {
    void visitCircle(Circle circle);

    void visitRectangle(Rectangle rectangle);
}

/*
 * concrete visitors
 * each concrete visitor implements the visitor interface with a specific
 * operation
 */
class AreaCalculatorVisitor implements ShapeVisitor {

    @Override
    public void visitCircle(Circle circle) {
        double area = Math.PI * circle.getRadius() * circle.getRadius();
        System.out.println("circle area = " + area);
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        double area = rectangle.getHeight() * rectangle.getWidth();
        System.out.println("Rectangle area = " + area);
    }
}

class JpgExporterVisitor implements ShapeVisitor {

    @Override
    public void visitCircle(Circle circle) {
        System.out.println("export circle: " + circle.getRadius());
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        System.out.println("export rectangle: " + rectangle.getHeight() + " " + rectangle.getWidth());
    }
}

public class Visitor {
    public static void main(String[] args) {
        List<Shape> shapes = List.of(
                new Circle(2.5),
                new Rectangle(4, 10),
                new Circle(4));

        AreaCalculatorVisitor areaCalculator = new AreaCalculatorVisitor();
        JpgExporterVisitor jpgExporter = new JpgExporterVisitor();

        // double dispatch
        for (Shape s : shapes) {
            s.accept(areaCalculator);
            s.accept(jpgExporter);
        }
    }
}
