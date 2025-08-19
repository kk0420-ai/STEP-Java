import java.util.*;

public class UniqueCharactersInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        char[] unique = findUniqueCharacters(text);
        System.out.println("Unique characters:");
        for (char c : unique) System.out.print(c + " ");
    }

    static int getLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (Exception e) {}
        return count;
    }

    static char[] findUniqueCharacters(String s) {
        int len = getLength(s);
        char[] temp = new char[len];
        int idx = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            boolean unique = true;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == c) {
                    unique = false;
                    break;
                }
            }
            if (unique) temp[idx++] = c;
        }
        char[] result = new char[idx];
        for (int i = 0; i < idx; i++) result[i] = temp[i];
        return result;
    }
}
