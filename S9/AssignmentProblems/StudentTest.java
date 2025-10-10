import java.util.*;

class Student {
    private int rollNo;
    private String name;

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student s = (Student) obj;
        return this.rollNo == s.rollNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNo);
    }

    @Override
    public String toString() {
        return "Student[RollNo=" + rollNo + ", Name=" + name + "]";
    }
}

public class StudentTest {
    public static void main(String[] args) {
        HashSet<Student> set = new HashSet<>();
        set.add(new Student(1, "A"));
        set.add(new Student(2, "B"));
        set.add(new Student(1, "C"));
        for (Student s : set) System.out.println(s);
    }
}
