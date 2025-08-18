import java.util.*;

public class TextProcessor {
    public static String cleanInput(String input) {
        input = input.trim().replaceAll("\\s+", " ");
        String[] words = input.toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                sb.append(Character.toUpperCase(word.charAt(0)))
                  .append(word.substring(1)).append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static void analyzeText(String text) {
        int wordCount = text.split("\\s+").length;
        int sentenceCount = text.split("[.!?]").length;
        int charCount = text.replaceAll("\\s+", "").length();

        String[] words = text.split("\\s+");
        String longestWord = "";
        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z]", "");
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : text.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
        }

        char mostCommon = ' ';
        int maxFreq = 0;
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > maxFreq) {
                mostCommon = entry.getKey();
                maxFreq = entry.getValue();
            }
        }

        System.out.println("Word Count: " + wordCount);
        System.out.println("Sentence Count: " + sentenceCount);
        System.out.println("Character Count (no spaces): " + charCount);
        System.out.println("Longest Word: " + longestWord);
        System.out.println("Most Common Character: " + mostCommon);
    }

    public static String[] getWordsSorted(String text) {
        text = text.replaceAll("[^a-zA-Z ]", "");
        String[] words = text.split("\\s+");
        Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);
        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== TEXT PROCESSOR ===");
        System.out.print("Enter a paragraph of text:\n");
        String paragraph = scanner.nextLine();

        String cleaned = cleanInput(paragraph);
        System.out.println("\nCleaned Text:\n" + cleaned + "\n");

        System.out.println("=== ANALYSIS ===");
        analyzeText(cleaned);

        System.out.println("\n=== SORTED WORDS ===");
        String[] sortedWords = getWordsSorted(cleaned);
        for (String word : sortedWords) {
            System.out.println(word);
        }

        System.out.print("\nSearch for a word: ");
        String searchWord = scanner.nextLine().trim();
        boolean found = Arrays.asList(sortedWords).contains(searchWord);
        System.out.println("Word found: " + (found ? "Yes" : "No"));

        scanner.close();
    }
}
