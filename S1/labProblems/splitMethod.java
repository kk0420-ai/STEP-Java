import java.util.Scanner;

public class splitMethod {

    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    public static String[] customSplit(String text) {
        int length = findLength(text);
        int wordCount = 1;
        
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        int[] spaceIndexes = new int[wordCount - 1];
        int spaceIndexCount = 0;
        
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[spaceIndexCount] = i;
                spaceIndexCount++;
            }
        }

        String[] words = new String[wordCount];
        int wordStartIndex = 0;
        int wordEndIndex;

        for (int i = 0; i < wordCount; i++) {
            if (i == wordCount - 1) {
                wordEndIndex = length;
            } else {
                wordEndIndex = spaceIndexes[i];
            }
            words[i] = text.substring(wordStartIndex, wordEndIndex).trim();
            wordStartIndex = wordEndIndex + 1;
        }

        return words;
    }

    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        String[] customSplitResult = customSplit(input);
        String[] builtInSplitResult = input.split(" ");

        System.out.println("Custom split result: ");
        for (String word : customSplitResult) {
            System.out.println(word);
        }

        System.out.println("Built-in split result: ");
        for (String word : builtInSplitResult) {
            System.out.println(word);
        }

        boolean areArraysEqual = compareArrays(customSplitResult, builtInSplitResult);
        System.out.println("Are the custom and built-in split results equal? " + areArraysEqual);
    }
}
