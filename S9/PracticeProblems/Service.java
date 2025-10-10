// File: NotificationService.java
interface Notifier {
    void send(String message);
}

public class Service {
    public void triggerAlert() {
        Notifier notifier = new Notifier() {
            @Override
            public void send(String message) {
                System.out.println("Sending notification: " + message);
            }
        };

        notifier.send("System Alert! Low memory detected.");
    }

    public static void main(String[] args) {
        new Service().triggerAlert();
    }
}
