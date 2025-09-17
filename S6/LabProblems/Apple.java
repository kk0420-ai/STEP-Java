class Fruit {
    protected String color;
    protected String taste;
    Fruit(String color, String taste) {
        this.color = color;
        this.taste = taste;
    }
}
class Apple extends Fruit {
    private String variety;
    Apple(String color, String taste, String variety) {
        super(color, taste);
        this.variety = variety;
    }
    public void showInfo() {
        System.out.println("Apple: " + color + ", " + taste + ", Variety: " + variety);
    }
    public static void main(String[] args) {
        Apple a = new Apple("Red", "Sweet", "Fuji");
        a.showInfo();
    }
}
