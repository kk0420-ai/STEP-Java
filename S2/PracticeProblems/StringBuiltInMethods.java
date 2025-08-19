public class StringBuiltInMethods {
    public static void main(String[] args) {
        String sampleText = " Java Programming is Fun and Challenging! ";

        System.out.println("1. Original Length: " + sampleText.length());
        String trimmed = sampleText.trim();
        System.out.println("2. Trimmed Length: " + trimmed.length());
        System.out.println("3. Character at index 5: " + trimmed.charAt(5));
        System.out.println("4. Substring 'Programming': " + trimmed.substring(5, 16));
        System.out.println("5. Index of 'Fun': " + trimmed.indexOf("Fun"));
        System.out.println("6. Contains 'Java'? " + trimmed.contains("Java"));
        System.out.println("7. Starts with 'Java'? " + trimmed.startsWith("Java"));
        System.out.println("8. Ends with '!': " + trimmed.endsWith("!"));
        System.out.println("9. Uppercase: " + trimmed.toUpperCase());
        System.out.println("10. Lowercase: " + trimmed.toLowerCase());
    }
}
