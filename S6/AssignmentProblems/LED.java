class Light {
    Light() { this("White"); System.out.println("Light default constructor"); }
    Light(String color) { System.out.println("Light color: " + color); }
}

class LED extends Light {
    LED() { this("Blue", 5); System.out.println("LED default constructor"); }
    LED(String color, int watt) { super(color); System.out.println("LED watt: " + watt); }

    public static void main(String[] args) {
        new LED();
        new LED("Red", 10);
    }
}
