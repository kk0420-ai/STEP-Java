class Artwork {}
class Painting extends Artwork { void details() { System.out.println("Painting: Colors & Frames"); } }
class Sculpture extends Artwork { void details() { System.out.println("Sculpture: Materials & Dimensions"); } }
class DigitalArt extends Artwork { void details() { System.out.println("Digital Art: Resolution & Format"); } }
class Photography extends Artwork { void details() { System.out.println("Photography: Camera & Editing"); } }
public class Gallery {
    public static void main(String[] args) {
        Artwork a = new Sculpture();
        if(a instanceof Sculpture) {
            Sculpture s = (Sculpture)a;
            s.details();
        }
    }
}
