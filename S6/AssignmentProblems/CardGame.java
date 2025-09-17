class Game {
    String name;
    Game(String name) { this.name = name; }

    @Override
    public String toString() { return "Game: " + name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game g = (Game) o;
        return name.equals(g.name);
    }

    @Override
    public int hashCode() { return name.hashCode(); }
}

class CardGame extends Game {
    int players;
    CardGame(String name, int players) { super(name); this.players = players; }

    @Override
    public String toString() { return super.toString() + ", Players: " + players; }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (!(o instanceof CardGame)) return false;
        CardGame cg = (CardGame) o;
        return players == cg.players;
    }

    public static void main(String[] args) {
        CardGame c1 = new CardGame("Poker", 4);
        CardGame c2 = new CardGame("Poker", 4);
        CardGame c3 = new CardGame("Bridge", 2);

        System.out.println(c1);
        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c3));
    }
}
