class CircularLinkedList {
    Node tail;
    class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
        }
    }

    void deleteAtBeginning() {
        if (tail == null) return;
        if (tail.next == tail) tail = null;
        else tail.next = tail.next.next;
    }

    void deleteAtEnd() {
        if (tail == null) return;
        if (tail.next == tail) tail = null;
        else {
            Node temp = tail.next;
            while (temp.next != tail) temp = temp.next;
            temp.next = tail.next;
            tail = temp;
        }
    }

    void display() {
        if (tail == null) { System.out.println("List is empty."); return; }
        Node temp = tail.next;
        do {
            System.out.print(temp.data + " → ");
            temp = temp.next;
        } while (temp != tail.next);
        System.out.println("back to " + tail.next.data);
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.deleteAtBeginning();
        list.insertAtEnd(40);
        System.out.print("Circular List: ");
        list.display();
    }
}
