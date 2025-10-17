import java.util.*;

class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public void showDetails() {
        System.out.println("Title: " + title + ", Author: " + author + ", ISBN: " + isbn);
    }

    public String getTitle() {
        return title;
    }
}

class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added book '" + book.getTitle() + "' to " + name + " Library");
    }

    public void showBooks() {
        System.out.println("Books in " + name + " Library:");
        for (Book book : books) {
            book.showDetails();
        }
    }
}

class Member {
    private String name;
    private List<Book> borrowedBooks;

    public Member(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        System.out.println(name + " borrowed book: " + book.getTitle());
    }

    public void showBorrowedBooks() {
        System.out.println("Books borrowed by " + name + ":");
        for (Book book : borrowedBooks) {
            book.showDetails();
        }
    }
}

public class LibraryDemo {
    public static void main(String[] args) {
        Library lib = new Library("Central City");

        Book book1 = new Book("1984", "George Orwell", "ISBN001");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "ISBN002");
        Book book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "ISBN003");

        lib.addBook(book1);
        lib.addBook(book2);
        lib.addBook(book3);

        lib.showBooks();

        Member member = new Member("Ravi");
        member.borrowBook(book1);
        member.borrowBook(book3);

        member.showBorrowedBooks();
    }
}
