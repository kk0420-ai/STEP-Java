class BasicMath {
    int calculate(int a, int b) { return a + b; }
    double calculate(double a, double b) { return a + b; }
    int calculate(int a, int b, int c) { return a + b + c; }
}

class AdvancedMath extends BasicMath {
    double calculate(double a, double b, double c) { return a * b * c; }
    int calculate(int a) { return a * a; }

    public static void main(String[] args) {
        AdvancedMath m = new AdvancedMath();
        System.out.println(m.calculate(2, 3));
        System.out.println(m.calculate(2.5, 3.5));
        System.out.println(m.calculate(1, 2, 3));
        System.out.println(m.calculate(2.0, 3.0, 4.0));
        System.out.println(m.calculate(5));
    }
}
