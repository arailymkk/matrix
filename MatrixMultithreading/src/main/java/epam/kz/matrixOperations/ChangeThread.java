package epam.kz.matrixOperations;

import java.util.List;

public class ChangeThread implements Runnable {
    private MatrixChange matrixChange = new MatrixChange();

    private int threadNumber;
    private int index;
    private List<List<Integer>> matrix;

    public ChangeThread(int threadNumber, int index, List<List<Integer>> matrix) {
        this.threadNumber = threadNumber;
        this.index = index;
        this.matrix = matrix;
    }

    public void run() {
        matrixChange.changeGivenRows(threadNumber, index, matrix);

    }
}
