class Student {
    String studentId, studentName, className;
    String[] subjects; double[][] marks; double gpa;
    static int totalStudents = 0; static String schoolName = "MySchool";

    public Student(String id, String name, String cls, String[] subs) {
        studentId = id; studentName = name; className = cls; subjects = subs;
        marks = new double[subs.length][1]; totalStudents++;
    }

    public void addMarks(int subIndex, double mark) { marks[subIndex][0] = mark; }

    public void calculateGPA() {
        double sum = 0; for (double[] m : marks) sum += m[0];
        gpa = sum / subjects.length / 10; // simple GPA calc
    }

    public void generateReportCard() {
        calculateGPA();
        System.out.println(studentName + " GPA: " + gpa);
    }

    public static void main(String[] args) {
        String[] subs = {"Math", "Science", "English"};
        Student s1 = new Student("S1", "Alice", "10A", subs);
        s1.addMarks(0, 90); s1.addMarks(1, 80); s1.addMarks(2, 85);
        s1.generateReportCard();
    }
}
