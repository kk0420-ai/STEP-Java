import java.util.*;

class StackList {
    private List<Integer> list = new ArrayList<>();

    void push(int item) { list.add(item); }
    int pop() { return list.isEmpty() ? -1 : list.remove(list.size() - 1); }
    int peek() { return list.isEmpty() ? -1 : list.get(list.size() - 1); }
    boolean isEmpty() { return list.isEmpty(); }
    void display() { System.out.println("Stack: " + list); }

    public static void main(String[] args) {
        StackList s = new StackList();
        s.push(10);
        s.push(20);
        s.display();
        System.out.println("Popped: " + s.pop());
        System.out.println("Top Element: " + s.peek());
    }
}
