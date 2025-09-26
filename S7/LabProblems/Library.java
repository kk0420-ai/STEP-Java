class LibraryUser {
    void access() { System.out.println("General library access"); }
}
class Student extends LibraryUser {
    void access() { System.out.println("Student: borrow books, use computers"); }
}
class Faculty extends LibraryUser {
    void access() { System.out.println("Faculty: reserve books, access databases"); }
}
class Guest extends LibraryUser {
    void access() { System.out.println("Guest: browse only"); }
}
public class Library {
    public static void main(String[] args) {
        LibraryUser u1 = new Student(); // upcasting
        LibraryUser u2 = new Faculty();
        LibraryUser u3 = new Guest();
        u1.access(); u2.access(); u3.access();
    }
}
