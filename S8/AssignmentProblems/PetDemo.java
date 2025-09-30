interface Animal {
    void eat();
}

interface Pet extends Animal {
    void play();
}

class Dog implements Pet {
    public void eat() { System.out.println("Dog eats food"); }
    public void play() { System.out.println("Dog plays fetch"); }
}

public class PetDemo {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.play();
    }
}
