import java.time.LocalDate;
import java.util.*;

final class MedicalRecord {
    private final String recordId;
    private final String patientDNA;
    private final String[] allergies;
    private final String[] medicalHistory;
    private final LocalDate birthDate;
    private final String bloodType;

    public MedicalRecord(String recordId, String patientDNA, String[] allergies, String[] medicalHistory, LocalDate birthDate, String bloodType) {
        if (recordId == null || patientDNA == null || allergies == null || medicalHistory == null || birthDate == null || bloodType == null) {
            throw new IllegalArgumentException("Invalid medical record data");
        }
        this.recordId = recordId;
        this.patientDNA = patientDNA;
        this.allergies = allergies.clone();
        this.medicalHistory = medicalHistory.clone();
        this.birthDate = birthDate;
        this.bloodType = bloodType;
    }

    public String getRecordId() { return recordId; }
    public String getPatientDNA() { return patientDNA; }
    public String[] getAllergies() { return allergies.clone(); }
    public String[] getMedicalHistory() { return medicalHistory.clone(); }
    public LocalDate getBirthDate() { return birthDate; }
    public String getBloodType() { return bloodType; }

    public final boolean isAllergicTo(String substance) {
        for (String allergy : allergies) {
            if (allergy.equalsIgnoreCase(substance)) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "MedicalRecord[" + recordId + ", Blood Type=" + bloodType + "]";
    }
}

public class Patient {
    private final String patientId;
    private final MedicalRecord medicalRecord;

    private String currentName;
    private String emergencyContact;
    private String insuranceInfo;
    private int roomNumber;
    private String attendingPhysician;

    Patient(String name, MedicalRecord medicalRecord) {
        this(UUID.randomUUID().toString(), name, "", "", 0, "", medicalRecord);
    }

    Patient(String patientId, String name, String emergencyContact, String insuranceInfo, int roomNumber, String physician, MedicalRecord medicalRecord) {
        this.patientId = patientId;
        this.currentName = name;
        this.emergencyContact = emergencyContact;
        this.insuranceInfo = insuranceInfo;
        this.roomNumber = roomNumber;
        this.attendingPhysician = physician;
        this.medicalRecord = medicalRecord;
    }

    String getBasicInfo() {
        return "Patient: " + currentName + ", Physician: " + attendingPhysician;
    }

    public String getPublicInfo() {
        return "Patient: " + currentName + ", Room: " + roomNumber;
    }

    public String getPatientId() { return patientId; }
    public MedicalRecord getMedicalRecord() { return medicalRecord; }

    public String getCurrentName() { return currentName; }
    public void setCurrentName(String name) { this.currentName = name; }

    public int getRoomNumber() { return roomNumber; }
    public void setRoomNumber(int room) { this.roomNumber = room; }

    public String getEmergencyContact() { return emergencyContact; }
    public void setEmergencyContact(String contact) { this.emergencyContact = contact; }

    public String getInsuranceInfo() { return insuranceInfo; }
    public void setInsuranceInfo(String info) { this.insuranceInfo = info; }

    public String getAttendingPhysician() { return attendingPhysician; }
    public void setAttendingPhysician(String physician) { this.attendingPhysician = physician; }

    @Override
    public String toString() {
        return "Patient{" + patientId + ", " + currentName + ", Room " + roomNumber + "}";
    }

    public static void main(String[] args) {
        MedicalRecord record = new MedicalRecord("MR-001", "DNA123", new String[]{"Peanuts"}, new String[]{"Asthma"}, LocalDate.of(1990, 5, 10), "O+");
        Patient p = new Patient("John Doe", record);
        p.setRoomNumber(202);
        p.setAttendingPhysician("Dr. Smith");

        System.out.println("Public Info: " + p.getPublicInfo());
        System.out.println("Is allergic to Peanuts? " + p.getMedicalRecord().isAllergicTo("Peanuts"));
        System.out.println("Medical Record: " + p.getMedicalRecord());
    }
}
