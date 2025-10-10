// File: Registration.java
class ContactInfo implements Cloneable {
    String email;
    String phone;

    public ContactInfo(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); // Shallow clone
    }

    @Override
    public String toString() {
        return "Email: " + email + ", Phone: " + phone;
    }
}

class Student implements Cloneable {
    String id;
    String name;
    ContactInfo contact;

    public Student(String id, String name, ContactInfo contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    // Shallow clone
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // Deep clone
    public Student deepClone() throws CloneNotSupportedException {
        Student copy = (Student) super.clone();
        copy.contact = (ContactInfo) contact.clone();
        return copy;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", " + contact;
    }
}

public class Registration {
    public static void main(String[] args) throws CloneNotSupportedException {
        ContactInfo c = new ContactInfo("john@example.com", "9876543210");
        Student s1 = new Student("S101", "John", c);

        Student shallow = (Student) s1.clone();
        Student deep = s1.deepClone();

        s1.contact.email = "changed@mail.com"; // change original contact

        System.out.println("Original: " + s1);
        System.out.println("Shallow:  " + shallow);
        System.out.println("Deep:     " + deep);
    }
}
