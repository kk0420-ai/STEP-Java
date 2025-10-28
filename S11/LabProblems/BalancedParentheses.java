import java.util.*;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter expression: ");
        String exp = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        for (char ch : exp.toCharArray()) {
            if ("({[".indexOf(ch) != -1) stack.push(ch);
            else if (")}]".indexOf(ch) != -1) {
                if (stack.isEmpty() || !isMatching(stack.pop(), ch)) {
                    System.out.println("Not Balanced");
                    return;
                }
            }
        }
        System.out.println(stack.isEmpty() ? "Balanced" : "Not Balanced");
    }

    static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
}
