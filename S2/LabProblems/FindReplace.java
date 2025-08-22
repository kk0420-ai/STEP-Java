import java.util.*;

public class FindReplace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the main text:");
        String text = sc.nextLine();
        System.out.println("Enter the substring to find:");
        String find = sc.nextLine();
        System.out.println("Enter the substring to replace with:");
        String replace = sc.nextLine();

        String manualResult = manualReplace(text, find, replace);
        String builtinResult = text.replace(find, replace);

        System.out.println("\nManual Result: " + manualResult);
        System.out.println("Built-in Result: " + builtinResult);
        System.out.println("Match with replace(): " + manualResult.equals(builtinResult));
    }

    static String manualReplace(String text, String find, String replace) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i <= text.length() - find.length()) {
            if (text.substring(i, i + find.length()).equals(find)) {
                result.append(replace);
                i += find.length();
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }
        while (i < text.length()) {
            result.append(text.charAt(i++));
        }
        return result.toString();
    }
}
