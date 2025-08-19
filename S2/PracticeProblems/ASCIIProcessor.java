import java.util.Scanner;

public class ASCIIProcessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        for (char ch : text.toCharArray()) {
            int code = (int) ch;
            System.out.print(ch + " -> " + code);
            if (Character.isUpperCase(ch)) System.out.println(" (Uppercase)");
            else if (Character.isLowerCase(ch)) System.out.println(" (Lowercase)");
            else if (Character.isDigit(ch)) System.out.println(" (Digit)");
            else System.out.println(" (Special)");
        }

        sc.close();
    }
}
