import java.util.Scanner;

class ATM {
    private double balance = 5000;

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();

        System.out.println("----- ATM MENU -----");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter amount to withdraw: ");
                double w = sc.nextDouble();
                atm.withdraw(w);
                break;

            case 2:
                System.out.print("Enter amount to deposit: ");
                double d = sc.nextDouble();
                atm.deposit(d);
                break;

            case 3:
                atm.checkBalance();
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
