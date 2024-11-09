public class SystemGenerator {
    public Matrix generateUniqueSolutionSystem() {
        Matrix matrix;
        do {
            matrix = new Matrix();
            matrix.randomizeElements();
        } while (matrix.calculateDeterminant() == 0);  // Ensure unique solution
        matrix.setOriginalDeterminant(matrix.calculateDeterminant());
        return matrix;
    }
}
