package three.five;

/*
Modify LookupCSV to make a program RangeLookupCSV that takes two key values from the standard input and
prints all key-value pairs in the .csv file such that the key falls within the range specified.
 */

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Exercise_3_5_13 {
    private static final String FILE_PATH = "C:\\Users\\Роман\\Downloads\\alglorithms2\\exercise_3_5_12.txt";

    public static void main(String[] args) throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new FileReader(FILE_PATH))) {
            List<String[]> r = reader.readAll();
            r.subList(2,5).forEach(x -> System.out.println(Arrays.toString(x)));
        }
    }
}
