class MedicalStaff { void duty() { System.out.println("General hospital duty"); } }
class Doctor extends MedicalStaff { void duty() { System.out.println("Doctor: Diagnose & Surgery"); } }
class Nurse extends MedicalStaff { void duty() { System.out.println("Nurse: Administer Medicine"); } }
class Technician extends MedicalStaff { void duty() { System.out.println("Technician: Operate Equipment"); } }
class Administrator extends MedicalStaff { void duty() { System.out.println("Admin: Schedule & Records"); } }
public class Hospital {
    public static void main(String[] args) {
        MedicalStaff[] s = { new Doctor(), new Nurse(), new Technician(), new Administrator() };
        for(MedicalStaff m: s) m.duty();
    }
}
