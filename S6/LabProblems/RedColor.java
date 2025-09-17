class Color {
    protected String name;
    Color(String name) {
        this.name = name;
        System.out.println("Color constructor");
    }
}
class PrimaryColor extends Color {
    protected int intensity;
    PrimaryColor(String name, int intensity) {
        super(name);
        this.intensity = intensity;
        System.out.println("PrimaryColor constructor");
    }
}
class RedColor extends PrimaryColor {
    private String shade;
    RedColor(String name, int intensity, String shade) {
        super(name, intensity);
        this.shade = shade;
        System.out.println("RedColor constructor");
    }
    public void showDetails() {
        System.out.println("Color: " + name + ", Intensity: " + intensity + ", Shade: " + shade);
    }
    public static void main(String[] args) {
        RedColor r = new RedColor("Red", 80, "Dark Red");
        r.showDetails();
    }
}
