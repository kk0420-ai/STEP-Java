class Vehicle { void dispatch() { System.out.println("General transport"); } }
class Bus extends Vehicle { void dispatch() { System.out.println("Bus: Fixed Route"); } }
class Taxi extends Vehicle { void dispatch() { System.out.println("Taxi: Door to Door"); } }
class Train extends Vehicle { void dispatch() { System.out.println("Train: Scheduled"); } }
class Bike extends Vehicle { void dispatch() { System.out.println("Bike: Eco Trip"); } }
public class Transport {
    public static void main(String[] args) {
        Vehicle[] v = { new Bus(), new Taxi(), new Train(), new Bike() };
        for(Vehicle x: v) x.dispatch();
    }
}
