class Content { }
class Movie extends Content {
    void showMovie() { System.out.println("Movie: Ratings + Duration"); }
}
class Series extends Content {
    void showSeries() { System.out.println("TV Series: Seasons + Episodes"); }
}
class Documentary extends Content {
    void showDoc() { System.out.println("Documentary: Educational Tags"); }
}
public class Streaming {
    public static void main(String[] args) {
        Content c = new Movie();  // general reference
        if(c instanceof Movie) {
            Movie m = (Movie)c;  // downcasting
            m.showMovie();
        }
    }
}
