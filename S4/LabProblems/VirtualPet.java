import java.util.*;

public class VirtualPet {
    final String petId;
    String petName, species;
    int age, happiness, health, stageIndex;
    static final String[] EVOLUTION_STAGES = {"Egg", "Baby", "Child", "Teen", "Adult", "Elder"};
    static int totalPetsCreated = 0;

    public VirtualPet() { this("Unknown", "Mystery", 0, 50, 50, 0); }
    public VirtualPet(String petName) { this(petName, "Random", 0, 60, 60, 1); }
    public VirtualPet(String petName, String species) { this(petName, species, 0, 70, 70, 2); }
    public VirtualPet(String petName, String species, int age, int happiness, int health, int stageIndex) {
        this.petId = generatePetId();
        this.petName = petName;
        this.species = species;
        this.age = age;
        this.happiness = happiness;
        this.health = health;
        this.stageIndex = stageIndex;
        totalPetsCreated++;
    }

    public void feedPet() { health += 10; }
    public void playWithPet() { happiness += 10; }
    public void healPet() { health = Math.min(100, health + 20); }
    public void simulateDay() {
        age++;
        happiness -= 5;
        health -= 5;
        if (health <= 0) species = "Ghost";
    }
    public void evolvePet() { if (stageIndex < EVOLUTION_STAGES.length - 1) stageIndex++; }
    public String getPetStatus() { return EVOLUTION_STAGES[stageIndex]; }
    public static String generatePetId() { return "PET" + (++totalPetsCreated); }

    public void display() {
        System.out.println(petId + " " + petName + " [" + species + "] Age:" + age + " HP:" + health + " Happy:" + happiness + " Stage:" + getPetStatus());
    }

    public static void main(String[] args) {
        VirtualPet p1 = new VirtualPet();
        VirtualPet p2 = new VirtualPet("Buddy");
        VirtualPet p3 = new VirtualPet("Luna", "Dragon");
        for (int i = 0; i < 3; i++) {
            p1.simulateDay(); p1.evolvePet();
            p2.playWithPet(); p2.simulateDay(); p2.evolvePet();
            p3.feedPet(); p3.simulateDay(); p3.evolvePet();
        }
        p1.display(); p2.display(); p3.display();
    }
}
