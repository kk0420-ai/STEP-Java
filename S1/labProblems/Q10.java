import java.util.*;

public class Q10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[][] marks = generateRandomPCM(n);
        double[][] scores = calculateTotals(marks);
        String[] grades = calculateGrades(scores);
        displayScorecard(marks, scores, grades);
    }

    static int[][] generateRandomPCM(int n) {
        Random rand = new Random();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = rand.nextInt(41) + 60;
            arr[i][1] = rand.nextInt(41) + 60;
            arr[i][2] = rand.nextInt(41) + 60;
        }
        return arr;
    }

    static double[][] calculateTotals(int[][] marks) {
        double[][] result = new double[marks.length][3];
        for (int i = 0; i < marks.length; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double avg = total / 3.0;
            double percent = Math.round((avg) * 100.0) / 100.0;
            result[i][0] = total;
            result[i][1] = avg;
            result[i][2] = percent;
        }
        return result;
    }

    static String[] calculateGrades(double[][] scores) {
        String[] grades = new String[scores.length];
        for (int i = 0; i < scores.length; i++) {
            double p = scores[i][2];
            if (p >= 90) grades[i] = "A+";
            else if (p >= 80) grades[i] = "A";
            else if (p >= 70) grades[i] = "B";
            else if (p >= 60) grades[i] = "C";
            else if (p >= 50) grades[i] = "D";
            else grades[i] = "F";
        }
        return grades;
    }

    static void displayScorecard(int[][] marks, double[][] scores, String[] grades) {
        System.out.println("Stu\tPhy\tChem\tMath\tTotal\tAvg\t%\tGrade");
        for (int i = 0; i < marks.length; i++) {
            System.out.println((i+1) + "\t" + marks[i][0] + "\t" + marks[i][1] + "\t" + marks[i][2] + "\t" +
                (int)scores[i][0] + "\t" + String.format("%.2f", scores[i][1]) + "\t" +
                String.format("%.2f", scores[i][2]) + "\t" + grades[i]);
        }
    }
}
