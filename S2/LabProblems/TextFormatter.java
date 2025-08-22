import java.util.ArrayList;
import java.util.Scanner;

public class TextFormatter {
    public static ArrayList<String> splitWords(String text) {
        ArrayList<String> words = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                if (start != i) {
                    words.add(text.substring(start, i));
                }
                start = i + 1;
            }
        }
        // Add last word
        if (start < text.length()) {
            words.add(text.substring(start));
        }
        return words;
    }

    // Justify text fully to the given width using StringBuilder
    public static ArrayList<String> justifyText(ArrayList<String> words, int width) {
        ArrayList<String> lines = new ArrayList<>();
        int index = 0;
        while (index < words.size()) {
            int count = words.get(index).length();
            int last = index + 1;
            while (last < words.size()) {
                if (count + 1 + words.get(last).length() > width) break;
                count += 1 + words.get(last).length();
                last++;
            }

            StringBuilder line = new StringBuilder();
            int numberOfWords = last - index;
            // If last line or line has one word, left justify
            if (last == words.size() || numberOfWords == 1) {
                for (int i = index; i < last; i++) {
                    line.append(words.get(i));
                    if (i != last - 1) line.append(" ");
                }
                // Fill remaining spaces
                int remaining = width - line.length();
                for (int i = 0; i < remaining; i++) line.append(" ");
            } else {
                // Full justify
                int totalSpaces = width - (count - (numberOfWords - 1)); // spaces to distribute
                int spacesBetweenWords = totalSpaces / (numberOfWords - 1);
                int extraSpaces = totalSpaces % (numberOfWords - 1);

                for (int i = index; i < last; i++) {
                    line.append(words.get(i));
                    if (i != last - 1) {
                        for (int s = 0; s < spacesBetweenWords; s++) {
                            line.append(" ");
                        }
                        if (extraSpaces > 0) {
                            line.append(" ");
                            extraSpaces--;
                        }
                    }
                }
            }
            lines.add(line.toString());
            index = last;
        }
        return lines;
    }

    // Center align the lines using StringBuilder
    public static ArrayList<String> centerAlign(ArrayList<String> lines, int width) {
        ArrayList<String> centered = new ArrayList<>();
        for (String line : lines) {
            int padding = (width - line.trim().length()) / 2;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < padding; i++) sb.append(" ");
            sb.append(line.trim());
            // Add spaces after if needed to keep width consistent
            while (sb.length() < width) {
                sb.append(" ");
            }
            centered.add(sb.toString());
        }
        return centered;
    }

    // Justify text using String concatenation for comparison
    public static ArrayList<String> justifyTextConcat(ArrayList<String> words, int width) {
        ArrayList<String> lines = new ArrayList<>();
        int index = 0;
        while (index < words.size()) {
            int count = words.get(index).length();
            int last = index + 1;
            while (last < words.size()) {
                if (count + 1 + words.get(last).length() > width) break;
                count += 1 + words.get(last).length();
                last++;
            }

            String line = "";
            int numberOfWords = last - index;
            if (last == words.size() || numberOfWords == 1) {
                for (int i = index; i < last; i++) {
                    line += words.get(i);
                    if (i != last - 1) line += " ";
                }
                int remaining = width - line.length();
                for (int i = 0; i < remaining; i++) line += " ";
            } else {
                int totalSpaces = width - (count - (numberOfWords - 1));
                int spacesBetweenWords = totalSpaces / (numberOfWords - 1);
                int extraSpaces = totalSpaces % (numberOfWords - 1);

                for (int i = index; i < last; i++) {
                    line += words.get(i);
                    if (i != last - 1) {
                        for (int s = 0; s < spacesBetweenWords; s++) {
                            line += " ";
                        }
                        if (extraSpaces > 0) {
                            line += " ";
                            extraSpaces--;
                        }
                    }
                }
            }
            lines.add(line);
            index = last;
        }
        return lines;
    }

    public static void displayFormattedText(ArrayList<String> lines) {
        System.out.printf("%-6s %-10s %s%n", "Line#", "CharCount", "Text");
        for (int i = 0; i < lines.size(); i++) {
            System.out.printf("%-6d %-10d %s%n", (i + 1), lines.get(i).length(), lines.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the text to format:");
        String text = sc.nextLine();

        System.out.println("Enter desired line width:");
        int width = sc.nextInt();
        sc.nextLine(); // consume newline

        // Split words
        ArrayList<String> words = splitWords(text);

        // Justify text using StringBuilder
        long startBuilder = System.nanoTime();
        ArrayList<String> justifiedLines = justifyText(words, width);
        long endBuilder = System.nanoTime();

        // Justify text using String concatenation
        long startConcat = System.nanoTime();
        ArrayList<String> justifiedLinesConcat = justifyTextConcat(words, width);
        long endConcat = System.nanoTime();

        // Center align justified text (using StringBuilder result)
        ArrayList<String> centeredLines = centerAlign(justifiedLines, width);

        System.out.println("\nOriginal Text:");
        System.out.println(text);

        System.out.println("\nLeft-justified text:");
        displayFormattedText(justifiedLines);

        System.out.println("\nCenter-aligned text:");
        displayFormattedText(centeredLines);

        System.out.println("\nPerformance comparison:");
        System.out.printf("StringBuilder justify time: %.4f ms%n", (endBuilder - startBuilder) / 1_000_000.0);
        System.out.printf("String concatenation justify time: %.4f ms%n", (endConcat - startConcat) / 1_000_000.0);

        sc.close();
    }
}
