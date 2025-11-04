class DoublyLinkedList {
    Node head;
    class Node {
        int data;
        Node prev, next;
        Node(int d) { data = d; }
    }

    void deleteAll(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == value) {
                if (temp.prev != null) temp.prev.next = temp.next;
                else head = temp.next;
                if (temp.next != null) temp.next.prev = temp.prev;
            }
            temp = temp.next;
        }
    }

    void display() {
        Node t = head;
        while (t != null) {
            System.out.print(t.data + (t.next != null ? " ⇄ " : ""));
            t = t.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.head = list.new Node(10);
        list.head.next = list.new Node(20);
        list.head.next.prev = list.head;
        list.head.next.next = list.new Node(30);
        list.head.next.next.prev = list.head.next;
        list.head.next.next.next = list.new Node(20);
        list.head.next.next.next.prev = list.head.next.next;
        list.head.next.next.next.next = list.new Node(40);
        list.head.next.next.next.next.prev = list.head.next.next.next;

        list.display();
        list.deleteAll(20);
        list.display(); // Output: 10 ⇄ 30 ⇄ 40
    }
}
