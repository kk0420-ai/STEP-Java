package com.company.security;

public class SecureBankAccount {
    private String accountNumber;
    private double balance;
    private int pin;
    private boolean isLocked;
    private int failedAttempts;
    private static final int MAX_FAILED_ATTEMPTS = 3;
    private static final double MIN_BALANCE = 0.0;

    public SecureBankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.pin = 0;
        this.isLocked = false;
        this.failedAttempts = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isAccountLocked() {
        return isLocked;
    }

    public void deposit(double amount, int pin) {
        if (this.pin == pin && !isLocked) balance += amount;
    }

    public void withdraw(double amount, int pin) {
        if (this.pin == pin && !isLocked && balance >= amount) balance -= amount;
    }

    public static void main(String[] args) {
        SecureBankAccount account = new SecureBankAccount("12345", 1000.0);
        account.deposit(500, 0);
        account.withdraw(200, 0);
    }
}
