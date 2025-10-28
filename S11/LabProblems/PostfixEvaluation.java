import java.util.*;

public class PostfixEvaluation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter postfix expression: ");
        String[] tokens = sc.nextLine().split(" ");
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.matches("\\d+")) stack.push(Integer.parseInt(token));
            else {
                int b = stack.pop(), a = stack.pop();
                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            }
        }
        System.out.println("Result: " + stack.pop());
    }
}
