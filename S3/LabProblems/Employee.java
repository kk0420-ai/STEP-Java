class Employee {
    private String empId, empName, department, empType;
    private double baseSalary;
    private static int totalEmployees = 0;
    private static int counter = 1;

    public Employee(String name, String dept, double salary, String type) {
        this.empId = "E" + counter++;
        this.empName = name;
        this.department = dept;
        this.baseSalary = salary;
        this.empType = type;
        totalEmployees++;
    }

    public double calculateSalary(double bonus) { return baseSalary + bonus; }
    public double calculateSalary(int hours, double rate) { return hours * rate; }
    public double calculateSalary() { return baseSalary; }

    public double calculateTax(double salary) {
        if (empType.equals("fulltime")) return salary * 0.1;
        else if (empType.equals("parttime")) return salary * 0.05;
        else return salary * 0.08;
    }

    public void generatePaySlip() {
        double salary;
        if (empType.equals("fulltime")) salary = calculateSalary(2000);
        else if (empType.equals("parttime")) salary = calculateSalary(40, 200);
        else salary = calculateSalary();

        double tax = calculateTax(salary);
        System.out.println(empName + " (" + empType + ") Salary: " + salary + ", Tax: " + tax);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Alice", "IT", 50000, "fulltime");
        Employee e2 = new Employee("Bob", "HR", 0, "parttime");
        Employee e3 = new Employee("Charlie", "Finance", 40000, "contract");

        e1.generatePaySlip();
        e2.generatePaySlip();
        e3.generatePaySlip();

        System.out.println("Total Employees: " + totalEmployees);
    }
}
