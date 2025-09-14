package com.company.security;

public class SecureBankAccount {
    private double balance;

    public SecureBankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Invalid or insufficient funds");
        }
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        SecureBankAccount account = new SecureBankAccount(1000);
        account.deposit(500);
        account.withdraw(200);
        System.out.println("Balance: " + account.getBalance());
    }
}
