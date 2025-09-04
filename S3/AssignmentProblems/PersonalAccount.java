class PersonalAccount {
    private String accountHolderName, accountNumber;
    private double currentBalance, totalIncome, totalExpenses;

    private static int totalAccounts = 0, counter = 1;
    private static String bankName = "Default Bank";

    public PersonalAccount(String name, double opening) {
        accountHolderName = name;
        currentBalance = opening;
        totalIncome = opening;
        accountNumber = generateAccountNumber();
        totalAccounts++;
    }

    public void addIncome(double amount, String desc) {
        currentBalance += amount; totalIncome += amount;
        System.out.println(accountHolderName + " income: " + amount + " (" + desc + ")");
    }

    public void addExpense(double amount, String desc) {
        if (amount <= currentBalance) {
            currentBalance -= amount; totalExpenses += amount;
            System.out.println(accountHolderName + " expense: " + amount + " (" + desc + ")");
        }
    }

    public double calculateSavings() { return totalIncome - totalExpenses; }

    public void displayAccountSummary() {
        System.out.println("[" + accountNumber + "] " + accountHolderName +
                " | Balance: " + currentBalance + " | Savings: " + calculateSavings());
    }

    private static String generateAccountNumber() { return "AC" + (counter++); }
    public static void setBankName(String name) { bankName = name; }
    public static int getTotalAccounts() { return totalAccounts; }

    public static void main(String[] args) {
        setBankName("MyBank");
        PersonalAccount a1 = new PersonalAccount("Alice", 1000);
        PersonalAccount a2 = new PersonalAccount("Bob", 500);
        PersonalAccount a3 = new PersonalAccount("Charlie", 2000);

        a1.addIncome(500, "Salary"); a1.addExpense(200, "Groceries");
        a2.addExpense(100, "Books"); a3.addIncome(1000, "Freelance");

        a1.displayAccountSummary(); a2.displayAccountSummary(); a3.displayAccountSummary();
        System.out.println("Bank: " + bankName + " | Total Accounts: " + getTotalAccounts());
    }
}
