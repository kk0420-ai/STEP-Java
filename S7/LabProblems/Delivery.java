class Delivery {
    void calculate(int distance) {
        System.out.println("Basic Delivery: " + (distance * 10) + " Rs");
    }
    void calculate(int distance, int priorityFee) {
        System.out.println("Premium Delivery: " + (distance * 10 + priorityFee) + " Rs");
    }
    void calculate(int distance, int orders, int discount) {
        double cost = distance * 10 - (orders * discount);
        System.out.println("Group Delivery: " + cost + " Rs");
    }
    void calculate(int distance, int discountPercent, int totalBill, boolean festival) {
        double cost = (distance * 10) * (1 - discountPercent/100.0);
        if (totalBill > 500) cost = 0;
        System.out.println("Festival Special: " + cost + " Rs");
    }
    public static void main(String[] args) {
        Delivery d = new Delivery();
        d.calculate(5);
        d.calculate(5, 20);
        d.calculate(5, 3, 5);
        d.calculate(5, 20, 600, true);
    }
}
