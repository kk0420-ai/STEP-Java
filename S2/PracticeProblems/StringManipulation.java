import java.util.Scanner;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        String trimmed = input.trim();
        String replaced = trimmed.replace(" ", "_");
        String noDigits = replaced.replaceAll("\\d", "");
        String[] words = trimmed.split(" ");
        String joined = String.join(" | ", words);

        System.out.println("Trimmed: " + trimmed);
        System.out.println("Underscore replace: " + replaced);
        System.out.println("No digits: " + noDigits);
        System.out.println("Words split:");
        for (String w : words) System.out.println(w);
        System.out.println("Rejoined: " + joined);

        sc.close();
    }
}
