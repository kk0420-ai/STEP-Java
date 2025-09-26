class Device {}
class SmartTV extends Device { void control() { System.out.println("SmartTV: Channels & Apps"); } }
class Thermostat extends Device { void control() { System.out.println("Thermostat: Temperature & Energy"); } }
class SecuritySystem extends Device { void control() { System.out.println("Security: Cameras & Alarms"); } }
class KitchenAppliance extends Device { void control() { System.out.println("Kitchen: Cooking & Recipes"); } }
public class Home {
    public static void main(String[] args) {
        Device[] d = { new SmartTV(), new Thermostat(), new SecuritySystem(), new KitchenAppliance() };
        for(Device x: d) {
            if(x instanceof SmartTV) ((SmartTV)x).control();
            else if(x instanceof Thermostat) ((Thermostat)x).control();
            else if(x instanceof SecuritySystem) ((SecuritySystem)x).control();
            else if(x instanceof KitchenAppliance) ((KitchenAppliance)x).control();
        }
    }
}
