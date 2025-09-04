class Vehicle {
    private String vehicleId, brand, model;
    private double rentPerDay;
    private boolean isAvailable = true;
    private static int totalVehicles = 0, counter = 1, rentalDays = 0;
    private static double totalRevenue = 0;
    private static String companyName = "XYZ Rentals";

    public Vehicle(String brand, String model, double rent) {
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rent;
        this.vehicleId = "V" + counter++;
        totalVehicles++;
    }

    public void rentVehicle(int days) {
        if (isAvailable) {
            double rent = calculateRent(days);
            isAvailable = false;
            rentalDays += days;
            System.out.println(brand + " rented for " + days + " days, Rent: " + rent);
        }
    }

    public void returnVehicle() { isAvailable = true; }

    private double calculateRent(int days) {
        double rent = rentPerDay * days;
        totalRevenue += rent;
        return rent;
    }

    public void displayVehicleInfo() {
        System.out.println(vehicleId + " | " + brand + " " + model + " | Rent/day: " + rentPerDay + " | Available: " + isAvailable);
    }

    public static void displayCompanyStats() {
        System.out.println(companyName + " | Total Vehicles: " + totalVehicles + ", Total Revenue: " + totalRevenue + ", Rental Days: " + rentalDays);
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Toyota", "Innova", 1000);
        Vehicle v2 = new Vehicle("Honda", "City", 800);

        v1.displayVehicleInfo();
        v1.rentVehicle(3);
        v1.displayVehicleInfo();
        v1.returnVehicle();
        v1.displayVehicleInfo();

        Vehicle.displayCompanyStats();
    }
}
