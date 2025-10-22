class Account {
    private int accNo;
    private double balance;

    public Account(int accNo, double balance) {
        this.accNo = accNo;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void showBalance() {
        System.out.println("Balance: " + balance);
    }
}

class Customer {
    private String name;
    private Account account;

    public Customer(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    public void checkBalance() {
        System.out.print(name + " -> ");
        account.showBalance();
    }
}

class Bank {
    private String bankName;

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public void addCustomer(Customer c) {
        System.out.println("Customer added to " + bankName);
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Account a1 = new Account(101, 5000);
        Customer c1 = new Customer("Rahul", a1);
        Bank b1 = new Bank("SBI");

        b1.addCustomer(c1);
        a1.deposit(2000);
        c1.checkBalance();
    }
}
