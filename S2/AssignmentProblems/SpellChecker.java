import java.util.Scanner;

public class SpellChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String sentence = sc.nextLine();

        System.out.println("Enter number of dictionary words:");
        int n = sc.nextInt();
        sc.nextLine();

        String[] dictionary = new String[n];
        for (int i = 0; i < n; i++) {
            dictionary[i] = sc.nextLine();
        }

        String[] words = splitSentence(sentence);
        String[][] results = new String[words.length][3];

        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            if (isCorrect(w, dictionary)) {
                results[i][0] = w;
                results[i][1] = "-";
                results[i][2] = "Correct";
            } else {
                String suggestion = findClosest(w, dictionary);
                int dist = (suggestion.equals("-")) ? -1 : calculateDistance(w, suggestion);
                results[i][0] = w;
                results[i][1] = suggestion;
                results[i][2] = dist != -1 && dist <= 2 ? "Misspelled" : "No suggestion";
            }
        }

        displayResults(results);
    }

    static String[] splitSentence(String sentence) {
        int len = sentence.length();
        String[] temp = new String[len];
        int count = 0;
        int start = 0;
        for (int i = 0; i < len; i++) {
            char c = sentence.charAt(i);
            if (!Character.isLetter(c)) {
                if (start < i) {
                    temp[count++] = sentence.substring(start, i).toLowerCase();
                }
                start = i + 1;
            }
        }
        if (start < len) {
            temp[count++] = sentence.substring(start).toLowerCase();
        }
        String[] words = new String[count];
        for (int i = 0; i < count; i++) {
            words[i] = temp[i];
        }
        return words;
    }

    static boolean isCorrect(String word, String[] dictionary) {
        for (String w : dictionary) {
            if (w.equalsIgnoreCase(word)) {
                return true;
            }
        }
        return false;
    }

    static int calculateDistance(String w1, String w2) {
        int len1 = w1.length();
        int len2 = w2.length();

        if (len1 == len2) {
            int diff = 0;
            for (int i = 0; i < len1; i++) {
                if (w1.charAt(i) != w2.charAt(i)) {
                    diff++;
                }
            }
            return diff;
        }

        if (Math.abs(len1 - len2) > 2) return Integer.MAX_VALUE;

        String longer = len1 > len2 ? w1 : w2;
        String shorter = len1 > len2 ? w2 : w1;

        int i = 0, j = 0, diff = 0;
        while (i < longer.length() && j < shorter.length()) {
            if (longer.charAt(i) != shorter.charAt(j)) {
                diff++;
                i++;
                if (diff > 2) return Integer.MAX_VALUE;
            } else {
                i++;
                j++;
            }
        }
        diff += longer.length() - i;
        return diff;
    }

    static String findClosest(String word, String[] dictionary) {
        int minDist = Integer.MAX_VALUE;
        String closest = "-";
        for (String dictWord : dictionary) {
            int dist = calculateDistance(word, dictWord);
            if (dist < minDist) {
                minDist = dist;
                closest = dictWord;
            }
        }
        if (minDist <= 2) return closest;
        return "-";
    }

    static void displayResults(String[][] results) {
        System.out.printf("%-15s %-15s %-12s%n", "Original Word", "Suggestion", "Status");
        for (String[] res : results) {
            System.out.printf("%-15s %-15s %-12s%n", res[0], res[1], res[2]);
        }
    }
}
