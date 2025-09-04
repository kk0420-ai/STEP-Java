class Book {
    String bookId, title, author, isbn, category; boolean isIssued = false;
    public Book(String id, String t, String a, String isbn, String c) {
        bookId = id; title = t; author = a; this.isbn = isbn; category = c;
    }
}

class Member {
    String memberId, name; double totalFines = 0;
    Book issuedBook;

    public Member(String id, String name) { memberId = id; this.name = name; }

    public void issueBook(Book b) {
        if (!b.isIssued) { issuedBook = b; b.isIssued = true; System.out.println(name + " borrowed " + b.title); }
    }

    public void returnBook(Book b, int lateDays) {
        b.isIssued = false; issuedBook = null;
        if (lateDays > 0) totalFines += lateDays * 10;
        System.out.println(name + " returned " + b.title + " Fine: " + totalFines);
    }

    public static void main(String[] args) {
        Book b1 = new Book("B1", "Java", "Gosling", "123", "Tech");
        Member m1 = new Member("M1", "Alice");
        m1.issueBook(b1);
        m1.returnBook(b1, 2);
    }
}
