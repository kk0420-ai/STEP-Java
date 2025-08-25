class BankAccount {
    static String bankName;
    static int totalAccounts = 0;
    static double interestRate;

    String accountNumber;
    String accountHolder;
    double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        totalAccounts++;
    }

    public static void setBankName(String name) {
        bankName = name;
    }

    public static void setInterestRate(double rate) {
        interestRate = rate;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void displayBankInfo() {
        System.out.println("Bank: " + bankName + ", Total Accounts: " + totalAccounts);
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void calculateInterest() {
        double interest = balance * interestRate;
        System.out.println("Interest: " + interest);
    }

    public void displayAccountInfo() {
        System.out.println("Account: " + accountNumber + ", Holder: " + accountHolder + ", Balance: " + balance);
    }
}

public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount.setBankName("ABC Bank");
        BankAccount.setInterestRate(0.05);

        BankAccount a1 = new BankAccount("A001", "John", 1000);
        BankAccount a2 = new BankAccount("A002", "Jane", 2000);

        a1.deposit(500);
        a2.withdraw(300);

        a1.displayAccountInfo();
        a1.calculateInterest();

        a2.displayAccountInfo();
        a2.calculateInterest();

        BankAccount.displayBankInfo();
        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());
    }
}
