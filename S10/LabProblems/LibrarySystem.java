class Book {
    private int bookID;
    private String title;
    private String author;

    public Book(int bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
    }

    public void issue() {
        System.out.println(title + " has been issued.");
    }

    public void returnBook() {
        System.out.println(title + " has been returned.");
    }

    public String getTitle() {
        return title;
    }
}

class Member {
    private int memberID;
    private String name;

    public Member(int memberID, String name) {
        this.memberID = memberID;
        this.name = name;
    }

    public void borrowBook(Book b) {
        System.out.println(name + " borrowed the book: " + b.getTitle());
    }
}

class Librarian {
    private int empID;
    private String name;

    public Librarian(int empID, String name) {
        this.empID = empID;
        this.name = name;
    }

    public void addBook() {
        System.out.println(name + " added a new book to the library.");
    }

    public void removeBook() {
        System.out.println(name + " removed a book from the library.");
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Librarian librarian = new Librarian(1, "Ramesh");
        Book book = new Book(101, "Java Basics", "James Gosling");
        Member member = new Member(1001, "Kapil");

        librarian.addBook();
        member.borrowBook(book);
        book.issue();
        book.returnBook();
        librarian.removeBook();
    }
}
