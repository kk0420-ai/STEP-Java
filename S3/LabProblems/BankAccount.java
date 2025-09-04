class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private static int totalAccounts = 0;
    private static int counter = 1;

    public BankAccount(String name, double initialDeposit) {
        this.accountHolderName = name;
        this.balance = initialDeposit;
        this.accountNumber = generateAccountNumber();
        totalAccounts++;
    }

    private static String generateAccountNumber() {
        return "ACC" + String.format("%03d", counter++);
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) balance -= amount;
    }

    public void checkBalance() {
        System.out.println(accountHolderName + " Balance: " + balance);
    }

    public void displayAccountInfo() {
        System.out.println("Account: " + accountNumber + ", Name: " + accountHolderName + ", Balance: " + balance);
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[2];
        accounts[0] = new BankAccount("Alice", 1000);
        accounts[1] = new BankAccount("Bob", 500);

        accounts[0].deposit(200);
        accounts[1].withdraw(100);

        for (BankAccount acc : accounts) acc.displayAccountInfo();
        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());
    }
}
