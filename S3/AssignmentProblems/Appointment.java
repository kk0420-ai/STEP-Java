class Patient {
    String patientId, name; int age; String gender;
    public Patient(String id, String n, int a, String g) { patientId = id; name = n; age = a; gender = g; }
}

class Doctor {
    String doctorId, name, specialization;
    public Doctor(String id, String n, String sp) { doctorId = id; name = n; specialization = sp; }
}

class Appointment {
    static int totalAppointments = 0; static double totalRevenue = 0;
    String id; Patient p; Doctor d; String date; double fee;

    public Appointment(String id, Patient p, Doctor d, String date, double fee) {
        this.id = id; this.p = p; this.d = d; this.date = date; this.fee = fee;
        totalAppointments++; totalRevenue += fee;
    }

    public void display() {
        System.out.println("Appt " + id + " Patient: " + p.name + " Doctor: " + d.name + " Fee: " + fee);
    }

    public static void main(String[] args) {
        Patient p1 = new Patient("P1", "Alice", 25, "F");
        Doctor d1 = new Doctor("D1", "Dr. Bob", "Cardiology");
        Appointment a1 = new Appointment("A1", p1, d1, "2-2-25", 500);
        a1.display();
        System.out.println("Total Revenue: " + totalRevenue);
    }
}
