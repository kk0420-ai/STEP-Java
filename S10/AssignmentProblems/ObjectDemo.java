class Account {
    int accNo;
    double balance;

    Account(int accNo, double balance) {
        this.accNo = accNo;
        this.balance = balance;
    }
}

class Customer {
    String name;
    Account account;

    Customer(String name, Account account) {
        this.name = name;
        this.account = account;
    }
}

class Bank {
    String bankName;

    Bank(String bankName) {
        this.bankName = bankName;
    }
}

public class ObjectDemo {
    public static void main(String[] args) {
        Bank bank1 = new Bank("SBI");
        Account acc1 = new Account(1001, 8000);
        Customer cust1 = new Customer("Sneha", acc1);

        System.out.println(bank1.bankName + " -> " + cust1.name + " -> Balance: " + cust1.account.balance);
    }
}
