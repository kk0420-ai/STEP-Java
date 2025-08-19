import java.util.*;

public class Q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int games = sc.nextInt();
        sc.nextLine();
        String[][] history = new String[games][3];
        int playerWins = 0, computerWins = 0;

        for (int i = 0; i < games; i++) {
            System.out.print("Enter your choice (rock/paper/scissors): ");
            String user = sc.nextLine().toLowerCase();
            String computer = getComputerChoice();
            String winner = getWinner(user, computer);
            if (winner.equals("Player")) playerWins++;
            else if (winner.equals("Computer")) computerWins++;
            history[i][0] = user;
            history[i][1] = computer;
            history[i][2] = winner;
        }

        String[][] stats = getWinStats(playerWins, computerWins, games);
        displayGameResults(history, stats);
    }

    static String getComputerChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        int index = (int)(Math.random() * 3);
        return choices[index];
    }

    static String getWinner(String user, String comp) {
        if (user.equals(comp)) return "Draw";
        if (user.equals("rock") && comp.equals("scissors")) return "Player";
        if (user.equals("scissors") && comp.equals("paper")) return "Player";
        if (user.equals("paper") && comp.equals("rock")) return "Player";
        return "Computer";
    }

    static String[][] getWinStats(int pw, int cw, int total) {
        String[][] stats = new String[2][3];
        stats[0][0] = "Player";
        stats[0][1] = String.valueOf(pw);
        stats[0][2] = String.valueOf((pw * 100) / total) + "%";
        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(cw);
        stats[1][2] = String.valueOf((cw * 100) / total) + "%";
        return stats;
    }

    static void displayGameResults(String[][] history, String[][] stats) {
        System.out.println("\nGame\tPlayer\tComputer\tWinner");
        for (int i = 0; i < history.length; i++) {
            System.out.println((i+1) + "\t" + history[i][0] + "\t" + history[i][1] + "\t\t" + history[i][2]);
        }
        System.out.println("\nStats:");
        System.out.println("Name\tWins\tWin %");
        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t" + stats[i][1] + "\t" + stats[i][2]);
        }
    }
}
