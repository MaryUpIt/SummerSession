package src.com.session.summer.matrix;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Matrix {
    private final double[] [] matrix;
    private final int rows;
    private final int columns;

    public Matrix( int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new double[rows][columns];
    }

    public void fillMatrixByRandom() {
        fillMatrix(Math::random);
    }

    public void fillMatrixByZero() {
        fillMatrix(() -> 0.0);
    }

    private void fillMatrix(Supplier<Double> supplier){
        for (int i = 0; i< rows; i++) {
            for (int j = 0; j < columns; j++){
                matrix[i][j] = supplier.get();
            }
        }
    }


}
