import java.util.*;

public class AnagramCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first text: ");
        String s1 = sc.nextLine();
        System.out.print("Enter second text: ");
        String s2 = sc.nextLine();
        boolean result = isAnagram(s1, s2);
        System.out.println("Are anagrams? " + result);
    }

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];
        for (int i = 0; i < a.length(); i++) {
            freq1[a.charAt(i)]++;
            freq2[b.charAt(i)]++;
        }
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) return false;
        }
        return true;
    }
}
