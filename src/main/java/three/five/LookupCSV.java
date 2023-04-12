package three.five;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LookupCSV {

    public static void main(String[] args){
        In in = new In("C:\\Users\\Роман\\Downloads\\alglorithms2\\exercise_3_5_12.txt");
        int keyField = Integer.parseInt("1");
        int valField = Integer.parseInt("2");

        LinearProbingHashST_3_5_8<String, String> hashST358 = new LinearProbingHashST_3_5_8<>();
        while(in.hasNextLine()){
            String line = in.readLine();
            String[] tokens = line.split(",");
            String key = tokens[keyField];
            String val = tokens[valField];
            hashST358.put(key, val);
        }

        while (!StdIn.isEmpty()){
            String query = StdIn.readString();
            if(hashST358.contains(query)){
                StdOut.println(hashST358.get(query));
                hashST358.get(query).forEach(e-> StdOut.println(e + ", "));
            }
        }
    }
}

