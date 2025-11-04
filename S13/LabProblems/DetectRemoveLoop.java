class DetectRemoveLoop {
    Node head;
    class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    void detectAndRemoveLoop() {
        Node slow = head, fast = head;
        boolean loopFound = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                loopFound = true;
                break;
            }
        }
        if (!loopFound) {
            System.out.println("No loop detected.");
            return;
        }
        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
        System.out.println("Loop detected and removed.");
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + (temp.next != null ? " → " : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DetectRemoveLoop list = new DetectRemoveLoop();
        list.head = list.new Node(10);
        list.head.next = list.new Node(20);
        list.head.next.next = list.new Node(30);
        list.head.next.next.next = list.new Node(40);
        list.head.next.next.next.next = list.new Node(50);
        list.head.next.next.next.next.next = list.head.next.next;
        list.detectAndRemoveLoop();
        System.out.print("List after loop removal: ");
        list.display();
    }
}
