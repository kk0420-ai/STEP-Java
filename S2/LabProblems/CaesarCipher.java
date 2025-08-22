import java.util.*;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();
        System.out.print("Enter shift: ");
        int shift = sc.nextInt();

        String encrypted = encrypt(input, shift);
        String decrypted = decrypt(encrypted, shift);

        System.out.println("Original:  " + input);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
        System.out.println("Decryption valid: " + input.equals(decrypted));
    }

    static String encrypt(String text, int shift) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                sb.append((char)((c - base + shift) % 26 + base));
            } else sb.append(c);
        }
        return sb.toString();
    }

    static String decrypt(String text, int shift) {
        return encrypt(text, 26 - (shift % 26)); // reverse shift
    }
}
