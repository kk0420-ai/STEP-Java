import java.util.*;

class Book implements Cloneable {
    String title;
    Book(String title) { this.title = title; }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Library implements Cloneable {
    List<Book> books;
    Library(List<Book> books) { this.books = books; }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    protected Library deepClone() throws CloneNotSupportedException {
        List<Book> newBooks = new ArrayList<>();
        for (Book b : books) newBooks.add((Book) b.clone());
        return new Library(newBooks);
    }
}

public class LibraryTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        List<Book> list = new ArrayList<>();
        list.add(new Book("Java"));
        list.add(new Book("Python"));
        Library original = new Library(list);
        Library shallow = (Library) original.clone();
        Library deep = original.deepClone();
        shallow.books.get(0).title = "C++";
        System.out.println("Original after shallow clone change: " + original.books.get(0).title);
        deep.books.get(0).title = "Go";
        System.out.println("Original after deep clone change: " + original.books.get(0).title);
    }
}
