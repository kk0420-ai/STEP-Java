enum OrderState {
    NEW, PROCESSING, SHIPPED, DELIVERED, CANCELLED
}

class Order {
    private OrderState state;

    public Order() {
        state = OrderState.NEW;
        System.out.println("Order created. Current state: " + state);
    }

    public void processOrder() {
        state = OrderState.PROCESSING;
        System.out.println("Order is now " + state);
    }

    public void shipOrder() {
        state = OrderState.SHIPPED;
        System.out.println("Order is now " + state);
    }

    public void deliverOrder() {
        state = OrderState.DELIVERED;
        System.out.println("Order is now " + state);
    }

    public void cancelOrder() {
        state = OrderState.CANCELLED;
        System.out.println("Order is now " + state);
    }
}

public class OrderLifecycle {
    public static void main(String[] args) {
        Order order = new Order();   // State: NEW
        order.processOrder();        // State: PROCESSING
        order.shipOrder();           // State: SHIPPED
        order.deliverOrder();        // State: DELIVERED
    }
}
