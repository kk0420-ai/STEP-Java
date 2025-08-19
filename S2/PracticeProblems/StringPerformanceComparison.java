public class StringPerformanceComparison {
    public static void main(String[] args) {
        long start, end;

        start = System.nanoTime();
        concatenateWithString(1000);
        end = System.nanoTime();
        System.out.println("String: " + (end - start) + " ns");

        start = System.nanoTime();
        concatenateWithStringBuilder(1000);
        end = System.nanoTime();
        System.out.println("StringBuilder: " + (end - start) + " ns");

        start = System.nanoTime();
        concatenateWithStringBuffer(1000);
        end = System.nanoTime();
        System.out.println("StringBuffer: " + (end - start) + " ns");
    }

    public static String concatenateWithString(int n) {
        String result = "";
        for (int i = 0; i < n; i++) result += i;
        return result;
    }

    public static String concatenateWithStringBuilder(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(i);
        return sb.toString();
    }

    public static String concatenateWithStringBuffer(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) sb.append(i);
        return sb.toString();
    }
}
