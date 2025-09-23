public class GameBattle {
    public void attack(int damage) {
        System.out.println("Basic attack for " + damage + " points!");
    }

    public void attack(int damage, String weapon) {
        System.out.println("Attacking with " + weapon + " for " + damage + " points!");
    }

    public void attack(int damage, String weapon, boolean isCritical) {
        if (isCritical)
            System.out.println("CRITICAL HIT! " + weapon + " deals " + (damage * 2) + " points!");
        else
            attack(damage, weapon);
    }

    public void attack(int damage, String[] teammates) {
        System.out.print("Team attack with ");
        for (String t : teammates) System.out.print(t + " ");
        System.out.println("for " + (damage * teammates.length) + " total damage!");
    }

    public static void main(String[] args) {
        GameBattle g = new GameBattle();
        g.attack(50);
        g.attack(75, "Sword");
        g.attack(60, "Bow", true);
        g.attack(40, new String[]{"Alice", "Bob"});
    }
}
