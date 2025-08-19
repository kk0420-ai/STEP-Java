import java.util.*;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][2];
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            data[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            data[i][1] = sc.nextDouble();
        }
        String[][] result = getBMIStatus(data);
        displayResult(result);
    }

    static String[][] getBMIStatus(double[][] data) {
        String[][] result = new String[10][4];
        for (int i = 0; i < 10; i++) {
            double weight = data[i][0];
            double heightM = data[i][1] / 100;
            double bmi = weight / (heightM * heightM);
            result[i][0] = String.valueOf(data[i][1]);
            result[i][1] = String.valueOf(data[i][0]);
            result[i][2] = String.format("%.2f", bmi);
            result[i][3] = (bmi < 18.5) ? "Underweight" : (bmi < 25) ? "Normal" : (bmi < 30) ? "Overweight" : "Obese";
        }
        return result;
    }

    static void displayResult(String[][] result) {
        System.out.println("Height\tWeight\tBMI\t\tStatus");
        for (String[] r : result) {
            System.out.println(r[0] + "\t" + r[1] + "\t" + r[2] + "\t" + r[3]);
        }
    }
}
