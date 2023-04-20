package three.five;

/*
Fully indexed CSV. Implement an ST client FullLookupCSV that builds an array of ST objects
(one for each field), with a test client that allows the user to specify the key and value fields in each query.
 */

import edu.princeton.cs.algs4.In;

import java.util.List;

public class Exercise_3_5_22 {

    public static void main(String[] args) {
        In in = new In("C:\\Users\\Роман\\Downloads\\alglorithms2\\exercise_3_5_12.txt");
        FullLookupCSV fullLookupCSV = new FullLookupCSV();
        LinearProbingHashST_3_5_8<Integer, String> linearProbingHashST = fullLookupCSV.getFullLookCSV(in);

        List<String> stringsZero = linearProbingHashST.get(0);
        List<String> stringsOne = linearProbingHashST.get(1);
        List<String> stringsTwo = linearProbingHashST.get(2);
        stringsZero.forEach(e -> System.out.print(e + ", "));
        System.out.println();
        stringsOne.forEach(e -> System.out.print(e + ", "));
        System.out.println();
        stringsTwo.forEach(e -> System.out.print(e + ", "));
    }
}
