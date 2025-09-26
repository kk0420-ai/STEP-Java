class Character {
    void attack() { System.out.println("Character attacks!"); }
}
class Warrior extends Character {
    void attack() { System.out.println("Warrior slashes with sword!"); }
}
class Mage extends Character {
    void attack() { System.out.println("Mage casts fireball!"); }
}
class Archer extends Character {
    void attack() { System.out.println("Archer shoots an arrow!"); }
}
public class Game {
    public static void main(String[] args) {
        Character[] army = {new Warrior(), new Mage(), new Archer()};
        for (Character c : army) c.attack();  // runtime decides
    }
}
