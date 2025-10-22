class Hospital {
    public void manageAppointments() {
        System.out.println("Appointments managed by Admin.");
    }

    public void updateRecords() {
        System.out.println("Doctor updates patient records.");
    }

    public void generateBills() {
        System.out.println("Bill generated for Patient.");
    }
}

public class HospitalSystem {
    public static void main(String[] args) {
        Hospital h = new Hospital();
        h.manageAppointments();
        h.updateRecords();
        h.generateBills();
    }
}
