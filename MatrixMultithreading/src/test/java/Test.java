import epam.kz.matrixOperations.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        int threadNumber = 4;

        Logger LOGGER = LogManager.getLogger(MatrixChange.class);
        MatrixReport matrixReport = new MatrixReport();
        ReadFiles rf = new ReadFiles();
        List<List<Integer>> matrix = rf.readMatrix("numbers.txt");
        List<Thread> threads = new ArrayList<Thread>();

        for(int z = 0; z < threadNumber; z++) {
            ChangeThread change = new ChangeThread(threadNumber, z, matrix);
            threads.add(new Thread(change));
        }

        for(Thread thread: threads) {
            thread.start();
        }

        try{
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e){
            LOGGER.error(e);
        }
        matrixReport.matrixPrintByRow(matrix);

    }

}
