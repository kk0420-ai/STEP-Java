import java.util.*;
class BankAccount {
    String accountHolder; int accountNumber; double balance;
    BankAccount(){this("NA",new Random().nextInt(10000),0);}
    BankAccount(String name){this(name,new Random().nextInt(10000),0);}
    BankAccount(String name,double bal){this(name,new Random().nextInt(10000),bal);}
    BankAccount(String n,int a,double b){accountHolder=n;accountNumber=a;balance=b;}
    void deposit(double amt){balance+=amt;}
    void withdraw(double amt){if(balance>=amt)balance-=amt;}
    void displayAccount(){System.out.println(accountHolder+" | "+accountNumber+" | Rs."+balance);}
    public static void main(String[] args){
        BankAccount a1=new BankAccount();
        BankAccount a2=new BankAccount("Alice");
        BankAccount a3=new BankAccount("Bob",5000);
        a2.deposit(2000);a3.withdraw(1000);
        a1.displayAccount();a2.displayAccount();a3.displayAccount();
    }
}
