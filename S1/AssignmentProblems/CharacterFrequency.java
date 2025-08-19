import java.util.*;

public class CharacterFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        String[][] freq = getCharFrequency(s);
        System.out.println("Char\tFreq");
        for (String[] row : freq) {
            System.out.println(row[0] + "\t" + row[1]);
        }
    }

    static String[][] getCharFrequency(String s) {
        int[] freq = new int[256];
        for (int i = 0; i < s.length(); i++) freq[s.charAt(i)]++;
        String[][] res = new String[s.length()][2];
        int idx = 0;
        boolean[] used = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!used[c]) {
                res[idx][0] = String.valueOf(c);
                res[idx][1] = String.valueOf(freq[c]);
                used[c] = true;
                idx++;
            }
        }
        return Arrays.copyOf(res, idx);
    }
}
