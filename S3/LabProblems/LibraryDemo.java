class Book {
    private String bookId, title, author;
    private boolean isAvailable = true;
    private static int totalBooks = 0, availableBooks = 0;
    private static int counter = 1;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.bookId = "B" + counter++;
        totalBooks++;
        availableBooks++;
    }

    public void issueBook() {
        if (isAvailable) { isAvailable = false; availableBooks--; }
    }

    public void returnBook() {
        if (!isAvailable) { isAvailable = true; availableBooks++; }
    }

    public void displayBookInfo() {
        System.out.println(bookId + " | " + title + " by " + author + " | Available: " + isAvailable);
    }

    public boolean isAvailable() { return isAvailable; }

    public static void showStats() {
        System.out.println("Total Books: " + totalBooks + ", Available: " + availableBooks);
    }
}

class Member {
    private String memberId, memberName;
    private String[] booksIssued = new String[5];
    private int bookCount = 0;
    private static int counter = 1;

    public Member(String name) {
        this.memberName = name;
        this.memberId = "M" + counter++;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable() && bookCount < 5) {
            book.issueBook();
            booksIssued[bookCount++] = book.toString();
            System.out.println(memberName + " borrowed a book.");
        }
    }

    public void returnBook(Book book) {
        book.returnBook();
        if (bookCount > 0) bookCount--;
        System.out.println(memberName + " returned a book.");
    }
}

public class LibraryDemo {
    public static void main(String[] args) {
        Book b1 = new Book("Java", "James Gosling");
        Book b2 = new Book("Python", "Guido van Rossum");
        Member m1 = new Member("Alice");

        b1.displayBookInfo();
        m1.borrowBook(b1);
        b1.displayBookInfo();
        m1.returnBook(b1);
        b1.displayBookInfo();

        Book.showStats();
    }
}
