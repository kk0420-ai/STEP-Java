enum TicketState {
    CREATED, BOOKED, CONFIRMED, CANCELLED
}

class Ticket {
    private TicketState state;

    public Ticket() {
        state = TicketState.CREATED;
        System.out.println("Ticket " + state);
    }

    public void book() {
        state = TicketState.BOOKED;
        System.out.println("Ticket " + state);
    }

    public void confirm() {
        state = TicketState.CONFIRMED;
        System.out.println("Ticket " + state);
    }

    public void cancel() {
        state = TicketState.CANCELLED;
        System.out.println("Ticket " + state);
    }
}

public class TicketLifecycle {
    public static void main(String[] args) {
        Ticket t = new Ticket();
        t.book();
        t.confirm();
        t.cancel();
    }
}
