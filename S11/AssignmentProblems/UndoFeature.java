import java.util.*;

public class UndoFeature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        while (true) {
            System.out.print("Enter text or 'undo' or 'exit': ");
            String cmd = sc.nextLine();
            if (cmd.equalsIgnoreCase("exit")) break;
            else if (cmd.equalsIgnoreCase("undo")) {
                if (!stack.isEmpty()) stack.pop();
            } else stack.push(cmd);

            System.out.println("Current Text: " + stack);
        }
    }
}
