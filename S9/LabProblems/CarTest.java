class Car {
    String brand;
    String model;
    double price;

    Car(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car[Brand=" + brand + ", Model=" + model + ", Price=" + price + "]";
    }
}

public class CarTest {
    public static void main(String[] args) {
        Car c = new Car("Toyota", "Camry", 35000);
        System.out.println(c);
        System.out.println("Class Name: " + c.getClass().getName());
    }
}
