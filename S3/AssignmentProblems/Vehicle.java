class Vehicle {
    String vehicleId, brand, model, fuelType, status;
    int year; double mileage;

    public Vehicle(String id, String br, String m, int y, String f) {
        vehicleId = id; brand = br; model = m; year = y; fuelType = f; status = "Available";
    }

    public void assignDriver(String driver) { status = "Assigned to " + driver; }

    public void updateMileage(double km) { mileage += km; }

    public void display() { System.out.println(brand + " " + model + " " + status); }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("V1", "Toyota", "Innova", 2022, "Diesel");
        v1.assignDriver("John"); v1.updateMileage(500);
        v1.display();
    }
}
