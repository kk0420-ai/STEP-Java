class Person {
    void display() { System.out.println("I am a Person"); }
}

class Student extends Person {
    void display() { System.out.println("I am a Student"); }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        Student s = new Student();
        s.display();
    }
}
