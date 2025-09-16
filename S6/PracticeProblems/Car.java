class Car extends Vehicle {
    private int numberOfDoors;
    private String fuelType;
    private String transmissionType;

    Car() {
        super();
        this.numberOfDoors = 4;
        this.fuelType = "Petrol";
        this.transmissionType = "Manual";
        System.out.println("Car default constructor called");
    }

    Car(String brand, String model, int year, String engineType,
        int numberOfDoors, String fuelType, String transmissionType) {
        super(brand, model, year, engineType);
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        System.out.println("Car parameterized constructor called");
    }

    @Override
    public void start() {
        super.start();
        System.out.println("Car-specific startup checks completed");
    }

    @Override
    public void displaySpecs() {
        super.displaySpecs();
        System.out.println("Doors: " + numberOfDoors + ", Fuel: " + fuelType +
                           ", Transmission: " + transmissionType);
    }

    public void openTrunk() {
        System.out.println("Trunk opened");
    }

    public void playRadio() {
        System.out.println("Radio playing music");
    }

    public static void main(String[] args) {
        System.out.println("\n--- Testing Car with Default Constructor ---");
        Car car1 = new Car();
        car1.start();
        car1.displaySpecs();
        car1.openTrunk();

        System.out.println("\n--- Testing Car with Parameterized Constructor ---");
        Car car2 = new Car("Toyota", "Corolla", 2021, "Hybrid", 
                           4, "Hybrid", "Automatic");
        car2.start();
        car2.playRadio();
        System.out.println(car2.getVehicleInfo());
    }
}
