class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}

public class TestInstanceof {
    public static void main(String[] args) {
        Animal[] animals = { new Dog(), new Cat(), new Dog(), new Animal(), new Cat() };
        int dogs = 0, cats = 0;
        for (Animal a : animals) {
            if (a instanceof Dog) dogs++;
            else if (a instanceof Cat) cats++;
        }
        System.out.println("Dogs: " + dogs);
        System.out.println("Cats: " + cats);
    }
}
