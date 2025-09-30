abstract class Shape {
    abstract double area();
    abstract double perimeter();
    void displayInfo() { System.out.println("This is a shape"); }
}

class Circle extends Shape {
    double r;
    Circle(double r) { this.r = r; }
    double area() { return Math.PI * r * r; }
    double perimeter() { return 2 * Math.PI * r; }
}

class Rectangle extends Shape {
    double l, w;
    Rectangle(double l, double w) { this.l = l; this.w = w; }
    double area() { return l * w; }
    double perimeter() { return 2 * (l + w); }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Shape c = new Circle(5);
        Shape r = new Rectangle(4, 6);
        c.displayInfo();
        System.out.println("Circle Area: " + c.area() + " Perimeter: " + c.perimeter());
        r.displayInfo();
        System.out.println("Rectangle Area: " + r.area() + " Perimeter: " + r.perimeter());
    }
}
