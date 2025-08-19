import java.util.*;

public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        String[][] result = getCharTypes(str);
        System.out.println("Char\tType");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + "\t" + result[i][1]);
        }
    }

    static String checkCharType(char c) {
        if (c >= 'A' && c <= 'Z') c += 32;
        if (c >= 'a' && c <= 'z') {
            if ("aeiou".indexOf(c) != -1) return "Vowel";
            return "Consonant";
        }
        return "Not a Letter";
    }

    static String[][] getCharTypes(String str) {
        String[][] arr = new String[str.length()][2];
        for (int i = 0; i < str.length(); i++) {
            arr[i][0] = String.valueOf(str.charAt(i));
            arr[i][1] = checkCharType(str.charAt(i));
        }
        return arr;
    }
}
