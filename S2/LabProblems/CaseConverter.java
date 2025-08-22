import java.util.*;

public class CaseConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String input = sc.nextLine();

        String upper = toUpperCase(input);
        String lower = toLowerCase(input);
        String title = toTitleCase(input);

        System.out.printf("%-15s %-30s\n", "Type", "Result");
        System.out.printf("%-15s %-30s\n", "Uppercase", upper);
        System.out.printf("%-15s %-30s\n", "Lowercase", lower);
        System.out.printf("%-15s %-30s\n", "Title Case", title);
    }

    static String toUpperCase(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c >= 'a' && c <= 'z') sb.append((char)(c - 32));
            else sb.append(c);
        }
        return sb.toString();
    }

    static String toLowerCase(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c >= 'A' && c <= 'Z') sb.append((char)(c + 32));
            else sb.append(c);
        }
        return sb.toString();
    }

    static String toTitleCase(String text) {
        StringBuilder sb = new StringBuilder();
        boolean newWord = true;
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                newWord = true;
                sb.append(c);
            } else {
                if (newWord && c >= 'a' && c <= 'z') sb.append((char)(c - 32));
                else if (!newWord && c >= 'A' && c <= 'Z') sb.append((char)(c + 32));
                else sb.append(c);
                newWord = false;
            }
        }
        return sb.toString();
    }
}
