import java.util.*;

public class StringPerformance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of iterations: ");
        int n = sc.nextInt();

        long time1 = testStringConcat(n);
        long time2 = testStringBuilder(n);
        long time3 = testStringBuffer(n);

        System.out.printf("%-15s %-20s\n", "Method", "Time (ms)");
        System.out.printf("%-15s %-20d\n", "String (+)", time1);
        System.out.printf("%-15s %-20d\n", "StringBuilder", time2);
        System.out.printf("%-15s %-20d\n", "StringBuffer", time3);
    }

    static long testStringConcat(int n) {
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < n; i++) {
            s += "a";
        }
        return System.currentTimeMillis() - start;
    }

    static long testStringBuilder(int n) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        return System.currentTimeMillis() - start;
    }

    static long testStringBuffer(int n) {
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        return System.currentTimeMillis() - start;
    }
}
