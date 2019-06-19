package epam.kz.matrixOperations;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

public class MatrixChange {
    private RowRange rowRange = new RowRange();
    private static Logger LOGGER = LogManager.getLogger(MatrixChange.class);


    public void changeGivenRows(int threadNumber, int i, List<List<Integer>> matrix){
        int rowNumber = matrix.size();
        RowRange rr = calculateRowRange(rowNumber, threadNumber, i);
        for(int j = rr.getMin(); j < rr.getMax(); j++) {
            List<Integer> row = matrix.get(j);
            row.set(j, (int)Math.pow((i+1), 2));
            LOGGER.info("Element at " + j + "-th row of matrix has been changed to " + (int)Math.pow((i+1), 2));
        }
    }

    public RowRange calculateRowRange(int rowNumber, int threadNumber, int i){
        int wholeNumber = rowNumber/threadNumber;
        int remainder = rowNumber%threadNumber;
        if(i < remainder) {
            rowRange.setMin(i*(wholeNumber+1));
            rowRange.setMax((i+1)*(wholeNumber+1));
        }
        else {
            rowRange.setMin(wholeNumber*i+remainder);
            rowRange.setMax(wholeNumber*(i+1)+remainder);
        }

        return rowRange;

    }

}
