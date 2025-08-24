import java.util.*;

public class TextCompressor {
    public static void main(String[] args) {
        System.out.println("Enter a text: ");
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        char[] chars;
        int[] freq;
        Result res = countFrequency(text);
        chars = res.chars;
        freq = res.freq;
        String[][] mapping = createCodes(chars, freq);
        String compressed = compress(text, mapping);
        String decompressed = decompress(compressed, mapping);
        double ratio = 100.0 * compressed.length() / text.length();
        System.out.printf("%-8s %-8s%n", "Char", "Freq");
        for (int i = 0; i < chars.length; i++) {
            System.out.printf("%-8s %-8d%n", chars[i], freq[i]);
        }
        System.out.println("Mapping:");
        for (String[] m : mapping) {
            System.out.println(m[0] + " => " + m[1]);
        }
        System.out.println("Original: " + text);
        System.out.println("Compressed: " + compressed);
        System.out.println("Decompressed: " + decompressed);
        System.out.printf("Compression ratio: %.2f%%%n", ratio);
        in.close();
    }

    static class Result {
        char[] chars;
        int[] freq;
        Result(char[] c, int[] f) { chars = c; freq = f; }
    }

    static Result countFrequency(String s) {
        StringBuilder cbs = new StringBuilder();
        StringBuilder fbs = new StringBuilder();
        for (char c : s.toCharArray()) {
            int pos = cbs.toString().indexOf(c);
            if (pos >= 0) {
                int f = fbs.charAt(pos);
                fbs.setCharAt(pos, (char)(f + 1));
            } else {
                cbs.append(c);
                fbs.append(1);
            }
        }
        int n = cbs.length();
        char[] cs = new char[n];
        int[] fs = new int[n];
        for (int i = 0; i < n; i++) {
            cs[i] = cbs.charAt(i);
            fs[i] = fbs.charAt(i);
        }
        return new Result(cs, fs);
    }

    static String[][] createCodes(char[] chars, int[] freq) {
        int n = chars.length;
        String[][] map = new String[n][2];
        List<Integer> idx = new ArrayList<>();
        for (int i = 0; i < n; i++) idx.add(i);
        idx.sort((a, b) -> Integer.compare(freq[b], freq[a]));
        char symbol = 'A';
        for (int i = 0; i < n; i++) {
            int k = idx.get(i);
            map[i][0] = String.valueOf(chars[k]);
            map[i][1] = String.valueOf((char)(symbol + i));
        }
        return map;
    }

    static String compress(String s, String[][] map) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            for (String[] m : map) {
                if (m[0].charAt(0) == c) {
                    sb.append(m[1]);
                    break;
                }
            }
        }
        return sb.toString();
    }

    static String decompress(String comp, String[][] map) {
        StringBuilder sb = new StringBuilder();
        for (char c : comp.toCharArray()) {
            for (String[] m : map) {
                if (m[1].charAt(0) == c) {
                    sb.append(m[0]);
                    break;
                }
            }
        }
        return sb.toString();
    }
}
