interface Discount {
    double apply(double amount);
}

class Payment {
    void processTransaction(double amount) {
        class Validator {
            boolean isValid(double amt) { return amt > 0; }
        }
        Validator v = new Validator();
        if (v.isValid(amount)) {
            Discount discount = new Discount() {
                public double apply(double amt) { return amt * 0.9; }
            };
            double finalAmount = discount.apply(amount);
            System.out.println("Valid Payment. Final amount after discount: " + finalAmount);
        } else {
            System.out.println("Invalid Payment");
        }
    }
}

public class PaymentTest {
    public static void main(String[] args) {
        Payment p = new Payment();
        p.processTransaction(1000);
    }
}
