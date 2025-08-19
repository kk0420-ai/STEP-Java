import java.util.*;

public class Q7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string with leading and trailing spaces: ");
        String input = sc.nextLine();
        int[] bounds = trimBounds(input);
        String trimmed = substring(input, bounds[0], bounds[1]);
        boolean isEqual = compare(trimmed, input.trim());
        System.out.println("Trimmed: '" + trimmed + "'");
        System.out.println("Is Equal to trim(): " + isEqual);
    }

    static int[] trimBounds(String str) {
        int start = 0, end = str.length() - 1;
        while (start <= end && str.charAt(start) == ' ') start++;
        while (end >= start && str.charAt(end) == ' ') end--;
        return new int[]{start, end + 1};
    }

    static String substring(String str, int start, int end) {
        String sub = "";
        for (int i = start; i < end; i++) sub += str.charAt(i);
        return sub;
    }

    static boolean compare(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }
}
