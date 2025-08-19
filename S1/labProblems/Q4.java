import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();
        String[] words = splitWords(text);
        String[][] wordLength = generateWordLengthArray(words);
        int[] result = findMinMax(wordLength);
        System.out.println("Shortest Word: " + wordLength[result[0]][0]);
        System.out.println("Longest Word: " + wordLength[result[1]][0]);
    }

    static String[] splitWords(String text) {
        ArrayList<String> words = new ArrayList<>();
        String word = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c != ' ') {
                word += c;
            } else {
                if (!word.equals("")) {
                    words.add(word);
                    word = "";
                }
            }
        }
        if (!word.equals("")) words.add(word);
        return words.toArray(new String[0]);
    }

    static int findLength(String s) {
        int len = 0;
        try {
            while (true) {
                s.charAt(len);
                len++;
            }
        } catch (Exception e) {}
        return len;
    }

    static String[][] generateWordLengthArray(String[] words) {
        String[][] arr = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            arr[i][0] = words[i];
            arr[i][1] = String.valueOf(findLength(words[i]));
        }
        return arr;
    }

    static int[] findMinMax(String[][] arr) {
        int min = 0, max = 0;
        for (int i = 1; i < arr.length; i++) {
            int len = Integer.parseInt(arr[i][1]);
            if (len < Integer.parseInt(arr[min][1])) min = i;
            if (len > Integer.parseInt(arr[max][1])) max = i;
        }
        return new int[]{min, max};
    }
}
