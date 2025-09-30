public class PaymentTest {
    public static void main(String[] args) {
        PaymentGateway p1 = new CreditCardPayment();
        p1.pay(1000);
        p1.refund(500);

        PaymentGateway p2 = new UPIPayment();
        p2.pay(2000);
        p2.refund(1000);
    }
}

interface PaymentGateway {
    void pay(double amount);
    void refund(double amount);
}

class CreditCardPayment implements PaymentGateway {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Credit Card");
    }
    public void refund(double amount) {
        System.out.println("Refund " + amount + " to Credit Card");
    }
}

class UPIPayment implements PaymentGateway {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via UPI");
    }
    public void refund(double amount) {
        System.out.println("Refund " + amount + " to UPI");
    }
}
