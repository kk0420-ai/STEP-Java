import java.util.*;

public class passwordTool {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of passwords to analyze: ");
        int n = Integer.parseInt(in.nextLine());
        List<String> pwds = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pwds.add(in.nextLine());
        }
        System.out.printf("%-20s %-6s %-6s %-6s %-6s %-6s %-6s %-8s%n", "Password", "Len", "Upper", "Lower", "Digits", "SpChar", "Score", "Strength");
        for (String pwd : pwds) {
            int[] counts = analyze(pwd);
            int score = calcScore(pwd, counts);
            String strength = evalLevel(score);
            System.out.printf("%-20s %-6d %-6d %-6d %-6d %-6d %-6d %-8s%n",
                               pwd, pwd.length(), counts[0], counts[1], counts[2], counts[3], score, strength);
        }
        System.out.print("Enter desired length for new strong password: ");
        int len = Integer.parseInt(in.nextLine());
        String gen = generate(len);
        System.out.println("Generated password: " + gen);
        in.close();
    }

    static int[] analyze(String s) {
        int up=0, lo=0, di=0, sp=0;
        for (char c : s.toCharArray()) {
            int v = c;
            if (v>=65 && v<=90) up++;
            else if (v>=97 && v<=122) lo++;
            else if (v>=48 && v<=57) di++;
            else if (v>=33 && v<=126) sp++;
        }
        return new int[]{up, lo, di, sp};
    }

    static int calcScore(String s, int[] c) {
        int score = 0;
        if (s.length() > 8) score += 2 * (s.length() - 8);
        if (c[0] > 0) score += 10;
        if (c[1] > 0) score += 10;
        if (c[2] > 0) score += 10;
        if (c[3] > 0) score += 10;
        String lower = s.toLowerCase();
        String[] bad = {"123","abc","qwerty"};
        for (String b : bad) if (lower.contains(b)) score -= 10;
        return score;
    }

    static String evalLevel(int score) {
        if (score <= 20) return "Weak";
        else if (score <= 50) return "Medium";
        else return "Strong";
    }

    static String generate(int len) {
        String upp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String low = "abcdefghijklmnopqrstuvwxyz";
        String dig = "0123456789";
        String spec = "!@#$%^&*()-_=+[]{}|;:,.<>?/";
        String all = upp + low + dig + spec;
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        sb.append(upp.charAt(r.nextInt(upp.length())));
        sb.append(low.charAt(r.nextInt(low.length())));
        sb.append(dig.charAt(r.nextInt(dig.length())));
        sb.append(spec.charAt(r.nextInt(spec.length())));
        for (int i = sb.length(); i < len; i++) {
            sb.append(all.charAt(r.nextInt(all.length())));
        }
        List<Character> list = new ArrayList<>();
        for (char ch : sb.toString().toCharArray()) list.add(ch);
        Collections.shuffle(list);
        StringBuilder res = new StringBuilder();
        for (char ch : list) res.append(ch);
        return res.toString();
    }
}
