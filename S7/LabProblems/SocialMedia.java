class Post {
    String author, content;
    Post(String a, String c) { author = a; content = c; }
    void display() {
        System.out.println(author + ": " + content);
    }
}
class Instagram extends Post {
    Instagram(String a, String c) { super(a, c); }
    void display() { System.out.println( author + ": " + content + " #hashtags"); }
}
class Twitter extends Post {
    Twitter(String a, String c) { super(a, c); }
    void display() { System.out.println(author + ": " + content + " ("+content.length()+" chars)"); }
}
class LinkedIn extends Post {
    LinkedIn(String a, String c) { super(a, c); }
    void display() { System.out.println(author + ": " + content + " [Professional Post]"); }
}
public class SocialMedia {
    public static void main(String[] args) {
        Post p1 = new Instagram("Alice", "Hello Insta!");
        Post p2 = new Twitter("Bob", "Tweeting...");
        Post p3 = new LinkedIn("Charlie", "Networking!");
        p1.display(); p2.display(); p3.display();
    }
}
