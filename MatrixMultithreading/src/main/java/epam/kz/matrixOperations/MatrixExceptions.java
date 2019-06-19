package epam.kz.matrixOperations;

import java.util.List;

public class MatrixExceptions {

    public void validateMatrix(List<List<Integer>> matrix) {
        for(int i = 0; i < matrix.size(); i++) {
            List<Integer> row = matrix.get(i);
            row.get(i);
            if(!checkDiagonal(row.get(i))) {
                throw new IllegalArgumentException("["+ i +"][" + i + "] element of matrix must be equal to zero");
            }
        }
    }

    private boolean checkDiagonal(int diagonal) {
        return diagonal==0;
    }
}
