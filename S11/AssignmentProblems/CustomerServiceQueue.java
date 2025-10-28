import java.util.*;

public class CustomerServiceQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<String> queue = new LinkedList<>();

        while (true) {
            System.out.print("1.Enqueue 2.Dequeue 3.Display 4.Exit: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    queue.add(sc.nextLine());
                    break;
                case 2:
                    if (queue.isEmpty()) System.out.println("No customers!");
                    else System.out.println("Serving: " + queue.poll());
                    break;
                case 3:
                    System.out.println("Queue: " + queue);
                    break;
                case 4:
                    return;
            }
        }
    }
}
