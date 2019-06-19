package epam.kz.matrixOperations;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFiles {
    MatrixExceptions matrixExceptions = new MatrixExceptions();

    public List<List<Integer>> readMatrix(String fileName) {
        List<List<Integer>> matrix = new ArrayList<List<Integer>>();
        try {
            BufferedReader br = new BufferedReader(new java.io.FileReader(fileName));
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(", ");
                List<Integer> matrixRow = createRow(attributes);
                matrix.add(matrixRow);
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        matrixExceptions.validateMatrix(matrix);

        return matrix;
    }

    private List<Integer> createRow(String[] metadata) {
        List<Integer> matrixRow = new ArrayList<Integer>();
        for(String el: metadata){
            matrixRow.add(Integer.parseInt(el));
        }
        return matrixRow;
    }
}
