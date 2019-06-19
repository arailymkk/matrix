package epam.kz.matrixOperations;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

public class MatrixReport {

    private static Logger LOGGER = LogManager.getLogger(MatrixReport.class);

    public void matrixPrintByRow(List<List<Integer>> matrix){
        for(int i = 0; i < matrix.size(); i++) {
            LOGGER.debug("Row " + i + ": "+matrix.get(i));
        }
    }
}
