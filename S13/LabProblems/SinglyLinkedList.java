class SinglyLinkedList {
    Node head;
    class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    void insertAtPosition(int data, int pos) {
        Node newNode = new Node(data);
        if (pos == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;
        if (temp == null) {
            System.out.println("Invalid position!");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void display() {
        Node t = head;
        while (t != null) {
            System.out.print(t.data + (t.next != null ? " → " : ""));
            t = t.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.head = list.new Node(10);
        list.head.next = list.new Node(20);
        list.head.next.next = list.new Node(30);
        list.head.next.next.next = list.new Node(40);
        System.out.print("Before Insertion: ");
        list.display();
        list.insertAtPosition(50, 3);
        System.out.print("After Insertion: ");
        list.display();
    }
}
