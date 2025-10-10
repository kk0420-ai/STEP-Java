class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Book)) return false;
        Book b = (Book) obj;
        return title.equals(b.title) && author.equals(b.author);
    }
}

public class BookTest {
    public static void main(String[] args) {
        Book b1 = new Book("Java", "John");
        Book b2 = new Book("Java", "John");
        Book b3 = b1;
        System.out.println("b1 == b2 : " + (b1 == b2));
        System.out.println("b1.equals(b2) : " + b1.equals(b2));
        System.out.println("b1 == b3 : " + (b1 == b3));
    }
}
