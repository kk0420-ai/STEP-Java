class Car {
    String brand;
    String model;
    int year;
    String color;
    boolean isRunning;

    public Car(String brand, String model, int year, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.isRunning = false;
    }

    public void startEngine() {
        isRunning = true;
        System.out.println(brand + " engine started.");
    }

    public void stopEngine() {
        isRunning = false;
        System.out.println(brand + " engine stopped.");
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Year: " + year + ", Color: " + color + ", Running: " + isRunning);
    }

    public int getAge() {
        return 2025 - year;
    }
}

public class CarDemo {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Camry", 2020, "Red");
        Car car2 = new Car("Honda", "Civic", 2018, "Blue");
        Car car3 = new Car("Ford", "Mustang", 2023, "Black");

        car1.startEngine();
        car1.displayInfo();
        System.out.println("Age: " + car1.getAge());

        car2.displayInfo();
        car2.stopEngine();

        car3.startEngine();
        car3.displayInfo();
    }
}
