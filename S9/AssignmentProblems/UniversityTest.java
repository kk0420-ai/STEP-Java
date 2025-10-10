class University {
    private String name = "ABC University";

    class Department {
        void showDept() {
            System.out.println("Department of CS at " + name);
        }
    }

    static class ExamCell {
        static void showExamCell() {
            System.out.println("Exam Cell Operations Started");
        }
    }
}

public class UniversityTest {
    public static void main(String[] args) {
        University u = new University();
        University.Department d = u.new Department();
        d.showDept();
        University.ExamCell.showExamCell();
    }
}