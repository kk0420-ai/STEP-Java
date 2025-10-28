import java.util.*;

public class ExpressionValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter expression: ");
        String exp = sc.nextLine();
        Stack<Character> stack = new Stack<>();

        for (char ch : exp.toCharArray()) {
            if ("({[".indexOf(ch) != -1)
                stack.push(ch);
            else if (")}]".indexOf(ch) != -1) {
                if (stack.isEmpty() || !matches(stack.pop(), ch)) {
                    System.out.println("Expression is NOT Balanced");
                    return;
                }
            }
        }

        System.out.println(stack.isEmpty() ? "Expression is Balanced" : "Expression is NOT Balanced");
    }

    static boolean matches(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
}
