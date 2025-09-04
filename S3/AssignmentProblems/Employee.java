class Employee {
    String empId, empName, department, designation;
    double baseSalary; boolean[] attendance = new boolean[30];

    public Employee(String id, String name, String dept, String desig, double salary) {
        empId = id; empName = name; department = dept; designation = desig; baseSalary = salary;
    }

    public void markAttendance(int day, boolean present) { attendance[day] = present; }

    public double calculateSalary() {
        int presentDays = 0; for (boolean d : attendance) if (d) presentDays++;
        return baseSalary * presentDays / 30;
    }

    public void generatePaySlip() {
        System.out.println(empName + " Salary: " + calculateSalary());
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("E1", "Alice", "IT", "Dev", 30000);
        e1.markAttendance(0, true); e1.markAttendance(1, false);
        e1.generatePaySlip();
    }
}
