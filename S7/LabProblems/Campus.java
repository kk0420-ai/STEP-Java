class Device { }
class SmartClass extends Device {
    void control() { System.out.println("SmartClass: Lights + AC + Projector"); }
}
class SmartLab extends Device {
    void control() { System.out.println("SmartLab: Equipment + Safety"); }
}
class SmartLibrary extends Device {
    void control() { System.out.println("SmartLibrary: Track occupancy + books"); }
}
public class Campus {
    public static void main(String[] args) {
        Device[] devices = { new SmartClass(), new SmartLab(), new SmartLibrary() };
        for(Device d : devices) {
            if(d instanceof SmartClass) ((SmartClass)d).control();
            else if(d instanceof SmartLab) ((SmartLab)d).control();
            else if(d instanceof SmartLibrary) ((SmartLibrary)d).control();
        }
    }
}
