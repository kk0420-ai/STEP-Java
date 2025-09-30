class MathOps {
    int add(int a, int b) { return a + b; }
    double add(double a, double b) { return a + b; }
}

public class OverloadDemo {
    public static void main(String[] args) {
        MathOps m = new MathOps();
        System.out.println(m.add(5, 3));
        System.out.println(m.add(2.5, 4.3));
    }
}
