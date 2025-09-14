import java.util.Objects;
import java.util.UUID;

final class PetSpecies {
    private final String speciesName;
    private final String[] evolutionStages;
    private final int maxLifespan;
    private final String habitat;

    public PetSpecies(String speciesName, String[] evolutionStages, int maxLifespan, String habitat) {
        if (speciesName == null || evolutionStages == null || evolutionStages.length == 0 || maxLifespan <= 0) {
            throw new IllegalArgumentException("Invalid species data");
        }
        this.speciesName = speciesName;
        this.evolutionStages = evolutionStages.clone();
        this.maxLifespan = maxLifespan;
        this.habitat = habitat;
    }

    public String getSpeciesName() { return speciesName; }
    public String[] getEvolutionStages() { return evolutionStages.clone(); }
    public int getMaxLifespan() { return maxLifespan; }
    public String getHabitat() { return habitat; }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PetSpecies)) return false;
        PetSpecies other = (PetSpecies) obj;
        return speciesName.equals(other.speciesName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(speciesName, maxLifespan);
    }

    @Override
    public String toString() {
        return speciesName + " from " + habitat;
    }
}

public class VirtualPet {
    private final String petId;
    private final PetSpecies species;
    private final long birthTimestamp;

    private String petName;
    private int age;
    private int happiness;
    private int health;

    protected static final String[] DEFAULT_EVOLUTION_STAGES = {"Egg", "Baby", "Adult"};
    static final int MAX_HAPPINESS = 100;
    static final int MAX_HEALTH = 100;
    public static final String PET_SYSTEM_VERSION = "2.0";

    public VirtualPet() {
        this("Pet-" + UUID.randomUUID(), new PetSpecies("Generic", DEFAULT_EVOLUTION_STAGES, 100, "Forest"), 0, 50, 50, System.currentTimeMillis());
    }

    public VirtualPet(String petName) {
        this(petName, new PetSpecies("Generic", DEFAULT_EVOLUTION_STAGES, 100, "Forest"));
    }

    public VirtualPet(String petName, PetSpecies species) {
        this(petName, species, 0, 50, 50, System.currentTimeMillis());
    }

    public VirtualPet(String petName, PetSpecies species, int age, int happiness, int health, long birthTimestamp) {
        this.petId = generatePetId();
        this.species = Objects.requireNonNull(species);
        this.birthTimestamp = birthTimestamp;
        this.petName = petName;
        setAge(age);
        setHappiness(happiness);
        setHealth(health);
    }

    private String generatePetId() {
        return "PET-" + UUID.randomUUID().toString();
    }

    private void validateStat(int stat) {
        if (stat < 0 || stat > 100) throw new IllegalArgumentException("Stat out of range");
    }

    public void setHappiness(int happiness) {
        validateStat(happiness);
        this.happiness = happiness;
    }

    public void setHealth(int health) {
        validateStat(health);
        this.health = health;
    }

    public void setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Age must be positive");
        this.age = age;
    }

    public String getPetId() { return petId; }
    public PetSpecies getSpecies() { return species; }
    public long getBirthTimestamp() { return birthTimestamp; }
    public String getPetName() { return petName; }
    public int getAge() { return age; }
    public int getHappiness() { return happiness; }
    public int getHealth() { return health; }

    public void feedPet(String foodType) {
        modifyHappiness(10);
        modifyHealth(5);
    }

    public void playWithPet(String gameType) {
        modifyHappiness(15);
        modifyHealth(-2);
    }

    protected int calculateFoodBonus() {
        return 5;
    }

    protected int calculateGameEffect() {
        return 10;
    }

    private void modifyHappiness(int delta) {
        happiness = Math.min(MAX_HAPPINESS, Math.max(0, happiness + delta));
    }

    private void modifyHealth(int delta) {
        health = Math.min(MAX_HEALTH, Math.max(0, health + delta));
    }

    private void updateEvolutionStage() {}

    String getInternalState() {
        return petName + ":" + age + ":" + happiness + ":" + health;
    }

    @Override
    public String toString() {
        return "VirtualPet{name='" + petName + "', species=" + species.getSpeciesName() + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof VirtualPet)) return false;
        VirtualPet other = (VirtualPet) obj;
        return this.petId.equals(other.petId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(petId);
    }

    public static void main(String[] args) {
        VirtualPet pet = new VirtualPet("Fluffy");
        System.out.println("Pet Created: " + pet);
        System.out.println("Initial State -> Happiness: " + pet.getHappiness() + ", Health: " + pet.getHealth());

        pet.feedPet("Apple");
        pet.playWithPet("Catch");

        System.out.println("After Interaction -> Happiness: " + pet.getHappiness() + ", Health: " + pet.getHealth());
        System.out.println("Internal State: " + pet.getInternalState());
    }
}
