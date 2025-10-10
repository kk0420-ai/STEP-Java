class Outer {
    private String message = "Hello from Inner Class";

    class Inner {
        void display() {
            System.out.println(message);
        }
    }
}

public class InnerClassTest {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.display();
    }
}
