import java.util.Random;

public class Matrix {
    private int[][] elements;
    private int originalDeterminant;

    public Matrix() {
        elements = new int[3][3];
    }

    public void randomizeElements() {
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                elements[i][j] = rand.nextInt(21) - 10;
            }
        }
    }

    public int calculateDeterminant() {
        // Determinant formula for 3x3 matrix
        return elements[0][0] * (elements[1][1] * elements[2][2] - elements[1][2] * elements[2][1])
             - elements[0][1] * (elements[1][0] * elements[2][2] - elements[1][2] * elements[2][0])
             + elements[0][2] * (elements[1][0] * elements[2][1] - elements[1][1] * elements[2][0]);
    }

    public void updateElement(int row, int col, int value) {
        elements[row][col] = value;
    }

    public void printMatrix() {
        for (int[] row : elements) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    public int getOriginalDeterminant() {
        return originalDeterminant;
    }

    public void setOriginalDeterminant(int determinant) {
        this.originalDeterminant = determinant;
    }
}
