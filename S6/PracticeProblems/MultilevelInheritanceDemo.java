class Animal {
    protected String species;
    protected String habitat;
    protected int lifespan;
    protected boolean isWildlife;

    Animal(String species, String habitat, int lifespan, boolean isWildlife) {
        this.species = species;
        this.habitat = habitat;
        this.lifespan = lifespan;
        this.isWildlife = isWildlife;
        System.out.println("Animal constructor: Creating " + species);
    }

    public void eat() { System.out.println("Animal is eating"); }
    public void sleep() { System.out.println("Animal is sleeping"); }
    public void move() { System.out.println("Animal is moving"); }

    public String getAnimalInfo() {
        return species + " | Habitat: " + habitat + " | Lifespan: " + lifespan + " years";
    }
}

class Mammal extends Animal {
    private String furColor;
    private boolean hasWarmBlood;
    private int gestationPeriod;

    Mammal(String species, String habitat, int lifespan, boolean isWildlife,
           String furColor, int gestationPeriod) {
        super(species, habitat, lifespan, isWildlife);
        this.furColor = furColor;
        this.hasWarmBlood = true;
        this.gestationPeriod = gestationPeriod;
        System.out.println("Mammal constructor: Adding mammal traits");
    }

    @Override
    public void move() {
        super.move();
        System.out.println("Mammal is walking/running");
    }

    public void nurse() { System.out.println("Mammal is nursing offspring"); }
    public void regulateTemperature() { System.out.println("Maintaining body temperature"); }
}

class Dog extends Mammal {
    private String breed;
    private boolean isDomesticated;
    private int loyaltyLevel;
    private String favoriteActivity;

    Dog() {
        super("Dog", "Domestic", 12, false, "Brown", 60);
        this.breed = "Mixed";
        this.isDomesticated = true;
        this.loyaltyLevel = 7;
        this.favoriteActivity = "Playing";
        System.out.println("Dog constructor: Creating default dog");
    }

    Dog(String species, String habitat, int lifespan, boolean isWildlife,
        String furColor, int gestationPeriod, String breed, boolean isDomesticated,
        int loyaltyLevel, String favoriteActivity) {
        super(species, habitat, lifespan, isWildlife, furColor, gestationPeriod);
        this.breed = breed;
        this.isDomesticated = isDomesticated;
        this.loyaltyLevel = loyaltyLevel;
        this.favoriteActivity = favoriteActivity;
        System.out.println("Dog constructor: Creating " + breed + " dog");
    }

    Dog(Dog other) {
        this(other.species, other.habitat, other.lifespan, other.isWildlife,
             "CopiedFur", 60, other.breed, other.isDomesticated,
             other.loyaltyLevel, other.favoriteActivity);
        System.out.println("Dog copy constructor called");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("Dog wagging tail while eating");
    }

    @Override
    public void move() { System.out.println("Dog is running and playing"); }

    @Override
    public void sleep() { System.out.println("Dog is sleeping in doghouse"); }

    public void bark() { System.out.println("Woof! Woof!"); }
    public void fetch() { System.out.println("Dog is fetching the ball"); }
    public void showLoyalty() { System.out.println("Loyalty Level: " + loyaltyLevel); }

    public void demonstrateInheritance() {
        eat(); move(); sleep(); nurse(); regulateTemperature();
        bark(); fetch(); showLoyalty();
    }

    public static void main(String[] args) {
        Dog d1 = new Dog();
        d1.demonstrateInheritance();

        System.out.println("\n--- Creating detailed Dog ---");
        Dog d2 = new Dog("Dog", "House", 14, true, "Black", 62,
                         "German Shepherd", true, 10, "Guarding");
        d2.demonstrateInheritance();

        System.out.println("\n--- Copying Dog ---");
        Dog d3 = new Dog(d2);
        d3.demonstrateInheritance();
    }
}
