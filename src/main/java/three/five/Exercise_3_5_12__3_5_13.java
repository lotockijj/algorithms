package three.five;

/*
Modify LookupCSV to associate with each key all values that appear in a key-value pair with that key
in the input (not just the most recent, as in the associative-array abstraction).
 */

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise_3_5_12__3_5_13 {
    private static final String FILE_PATH = "C:\\Users\\Роман\\Downloads\\alglorithms2\\exercise_3_5_12.txt";

    public static void main(String[] args) {
        In in = new In("C:\\Users\\Роман\\Downloads\\alglorithms2\\exercise_3_5_12.txt");
        LinearProbingHashST_3_5_8<String, String> hashST358 = new LinearProbingHashST_3_5_8<>();
        while(in.hasNextLine()){
            String line = in.readLine();
            String[] tokens = line.split(",");
            String key = tokens[0];
            List<String> values = new ArrayList<>(Arrays.asList(tokens[1], tokens[2]));
            hashST358.put(key, values);
        }
        List<String> keys = hashST358.getKeys();
        List<String> vals = hashST358.getVals();
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String values = vals.get(i*2) + ":" + vals.get(i*2 + 1);
            System.out.println(key + " -> " + values);
        }
    }
}
