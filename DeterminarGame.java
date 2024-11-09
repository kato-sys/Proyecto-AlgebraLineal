public class DeterminarGame {
    private SystemGenerator systemGenerator;
    private Matrix matrix;
    private Player[] players;
    private int currentTurn;
    private int rounds;

    public DeterminarGame() {
        systemGenerator = new SystemGenerator();
        players = new Player[] {new Player("Player 1"), new Player("Player 2"), new Player("Player 3")};
        rounds = 5;
        initializeGame();
    }

    private void initializeGame() {
        matrix = systemGenerator.generateUniqueSolutionSystem();
        System.out.println("Original Matrix:");
        matrix.printMatrix();
        playGame();
    }

    private void playGame() {
        int currentRound = 1;
        while (currentRound <= rounds) {
            for (Player player : players) {
                if (player.isSkipTurn()) {
                    player.setSkipTurn(false);
                    System.out.println(player.getName() + " skips this turn.");
                    continue;
                }

                System.out.println("Turn of " + player.getName());
                matrix.printMatrix();
                player.playTurn(matrix);
                int determinant = matrix.calculateDeterminant();
                player.updateScore(determinant, matrix.getOriginalDeterminant());

                if (player.getScore() >= 21) {
                    System.out.println(player.getName() + " wins by reaching score 21!");
                    return;
                }
            }
            currentRound++;
        }
        determineWinner();
    }

    private void determineWinner() {
        Player winner = null;
        int maxScore = Integer.MIN_VALUE;
        for (Player player : players) {
            if (player.getScore() > maxScore) {
                maxScore = player.getScore();
                winner = player;
            }
        }
        System.out.println("The winner is " + winner.getName() + " with a score of " + maxScore);
    }

    public static void main(String[] args) {
        new DeterminarGame();
    }
}
