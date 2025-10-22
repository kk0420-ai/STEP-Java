class Teacher {
    String name;
    String subject;

    Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }
}

class Student {
    String name;
    int rollNo;

    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }
}

public class StudentTeacherRelation {
    public static void main(String[] args) {
        Teacher t1 = new Teacher("Ravi", "Math");
        Teacher t2 = new Teacher("Priya", "Science");

        Student s1 = new Student("Karthik", 101);
        Student s2 = new Student("Sneha", 102);
        Student s3 = new Student("Rohan", 103);
        Student s4 = new Student("Meera", 104);

        System.out.println(t1.name + " guides " + s1.name + " and " + s2.name);
        System.out.println(t2.name + " guides " + s3.name + " and " + s4.name);
    }
}
