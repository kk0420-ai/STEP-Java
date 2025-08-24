import java.util.*;

public class CSVAnalyzer {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter CSV data (end input with an empty line):");
        List<String> lines = new ArrayList<>();
        while (true) {
            String line = in.nextLine();
            if (line.trim().isEmpty()) break;
            lines.add(line);
        }
        String[][] data = parseCSV(lines);
        cleanData(data);
        analyzeData(data);
    }

    static String[][] parseCSV(List<String> lines) {
        int rows = lines.size();
        List<String[]> parsed = new ArrayList<>();
        for (String line : lines) {
            List<String> fields = new ArrayList<>();
            StringBuilder field = new StringBuilder();
            boolean inQuotes = false;
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c == '\"') inQuotes = !inQuotes;
                else if (c == ',' && !inQuotes) {
                    fields.add(field.toString());
                    field.setLength(0);
                } else {
                    field.append(c);
                }
            }
            fields.add(field.toString());
            parsed.add(fields.toArray(new String[0]));
        }
        int cols = parsed.get(0).length;
        String[][] arr = new String[rows][cols];
        for (int i = 0; i < rows; i++)
            arr[i] = parsed.get(i);
        return arr;
    }

    static void cleanData(String[][] data) {
        for (int i = 0; i < data.length; i++)
            for (int j = 0; j < data[i].length; j++)
                data[i][j] = data[i][j].trim();
    }

    static void analyzeData(String[][] data) {
        int rows = data.length, cols = data[0].length;
        boolean[] numeric = new boolean[cols];
        double[] min = new double[cols];
        double[] max = new double[cols];
        double[] sum = new double[cols];
        int[] valid = new int[cols];
        for (int j = 0; j < cols; j++) {
            numeric[j] = true;
            min[j] = Double.MAX_VALUE;
            max[j] = -Double.MAX_VALUE;
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String val = data[i][j];
                boolean isNum = true;
                for (char c : val.toCharArray())
                    if (!(c >= 48 && c <= 57 || c == '.')) isNum = false;
                if (!isNum) {
                    numeric[j] = false;
                } else {
                    double d = Double.parseDouble(val);
                    min[j] = Math.min(min[j], d);
                    max[j] = Math.max(max[j], d);
                    sum[j] += d;
                    valid[j]++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < cols; j++) {
            sb.append(String.format("%-15s", data[0][j]));
        }
        sb.append("\n");
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append(String.format("%-15s", data[i][j]));
            }
            sb.append("\n");
        }
        System.out.println("\nFormatted Table:");
        System.out.println(sb);
        System.out.println("Summary:");
        for (int j = 0; j < cols; j++) {
            if (numeric[j]) {
                double avg = valid[j] > 0 ? sum[j] / valid[j] : 0;
                System.out.printf("%s -> Min: %.2f, Max: %.2f, Avg: %.2f%n", data[0][j], min[j], max[j], avg);
            }
        }
    }
}
