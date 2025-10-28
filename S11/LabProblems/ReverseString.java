import java.util.*;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) stack.push(ch);
        System.out.println("Reversed: ");
        while (!stack.isEmpty()) System.out.print(stack.pop());
        System.out.println();
    }
}
