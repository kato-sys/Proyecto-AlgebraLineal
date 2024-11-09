import java.util.Scanner;

public class Player {
    private String name;
    private int score;
    private boolean skipTurn;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.skipTurn = false;
    }

    public void playTurn(Matrix matrix) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter row to modify (0-2): ");
        int row = scanner.nextInt();
        System.out.print("Enter column to modify (0-2): ");
        int col = scanner.nextInt();
        System.out.print("Enter new value: ");
        int value = scanner.nextInt();
        matrix.updateElement(row, col, value);
    }

    public void updateScore(int determinant, int originalDeterminant) {
        if (determinant == originalDeterminant) {
            skipTurn = false;  // Extra turn
        } else if (determinant < 0) {
            score += determinant;
        } else {
            score += Math.abs(originalDeterminant - determinant);
        }
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public boolean isSkipTurn() {
        return skipTurn;
    }

    public void setSkipTurn(boolean skipTurn) {
        this.skipTurn = skipTurn;
    }
}
