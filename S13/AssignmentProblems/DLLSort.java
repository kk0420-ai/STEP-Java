class DLLSort {
    Node head;
    class Node {
        int data;
        Node prev, next;
        Node(int d) { data = d; }
    }

    void bubbleSort() {
        if (head == null) return;
        boolean swapped;
        do {
            swapped = false;
            Node temp = head;
            while (temp.next != null) {
                if (temp.data > temp.next.data) {
                    int t = temp.data;
                    temp.data = temp.next.data;
                    temp.next.data = t;
                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);
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
        DLLSort list = new DLLSort();
        list.head = list.new Node(40);
        list.head.next = list.new Node(10);
        list.head.next.prev = list.head;
        list.head.next.next = list.new Node(30);
        list.head.next.next.prev = list.head.next;
        list.head.next.next.next = list.new Node(20);
        list.head.next.next.next.prev = list.head.next.next;

        System.out.println("Before sorting:");
        list.display();
        list.bubbleSort();
        System.out.println("After sorting:");
        list.display();
    }
}
