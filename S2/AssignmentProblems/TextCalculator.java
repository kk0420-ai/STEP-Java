import java.util.*;

public class TextCalculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of expressions to evaluate: ");
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.print("Enter expression " + (i + 1) + ": ");
            String expr = in.nextLine().replaceAll("\\s+", "");
            if (!isValid(expr)) {
                System.out.println("Invalid expression");
                continue;
            }
            System.out.println("Original: " + expr);
            int result = evaluate(expr);
            System.out.println("Result: " + result);
        }
        in.close();
    }

    static boolean isValid(String expr) {
        int bal = 0;
        for (char c : expr.toCharArray()) {
            if (!(Character.isDigit(c) || "+-*/()".indexOf(c) >= 0)) return false;
            if (c == '(') bal++;
            if (c == ')') bal--;
            if (bal < 0) return false;
        }
        return bal == 0;
    }

    static int evaluate(String expr) {
        while (expr.contains("(")) {
            int r = expr.indexOf(')');
            int l = expr.lastIndexOf('(', r);
            String inside = expr.substring(l + 1, r);
            int val = evaluateSimple(inside);
            expr = expr.substring(0, l) + val + expr.substring(r + 1);
        }
        return evaluateSimple(expr);
    }

    static int evaluateSimple(String expr) {
        List<Integer> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        int i = 0, n = expr.length();
        while (i < n) {
            int j = i;
            while (j < n && Character.isDigit(expr.charAt(j))) j++;
            nums.add(Integer.parseInt(expr.substring(i, j)));
            if (j < n) ops.add(expr.charAt(j));
            i = j + 1;
        }
        for (int k = 0; k < ops.size(); ) {
            char op = ops.get(k);
            if (op == '*' || op == '/') {
                int a = nums.get(k);
                int b = nums.get(k + 1);
                int r = op == '*' ? a * b : a / b;
                nums.set(k, r);
                nums.remove(k + 1);
                ops.remove(k);
            } else k++;
        }
        int res = nums.get(0);
        for (int k = 0; k < ops.size(); k++) {
            char op = ops.get(k);
            int b = nums.get(k + 1);
            res = op == '+' ? res + b : res - b;
        }
        return res;
    }
}
