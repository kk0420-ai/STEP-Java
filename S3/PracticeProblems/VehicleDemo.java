class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    protected double fuelLevel;

    public Vehicle(String make, String model, int year, double fuelLevel) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelLevel = fuelLevel;
    }

    public void startVehicle() {
        System.out.println(make + " " + model + " started.");
    }

    public void stopVehicle() {
        System.out.println(make + " " + model + " stopped.");
    }

    public void refuel(double amount) {
        fuelLevel += amount;
    }

    public void displayVehicleInfo() {
        System.out.println("Make: " + make + ", Model: " + model + ", Year: " + year + ", Fuel: " + fuelLevel);
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Vehicle("Toyota", "Camry", 2022, 50),
            new Vehicle("Ford", "F-150", 2021, 60),
            new Vehicle("Yamaha", "R15", 2023, 10)
        };

        for (Vehicle v : vehicles) {
            v.startVehicle();
            v.displayVehicleInfo();
            v.refuel(5);
            v.stopVehicle();
        }
    }
}
