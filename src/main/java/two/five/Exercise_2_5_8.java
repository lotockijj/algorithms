package two.five;

/*Write a program Frequency that reads strings from standard input and prints
the number of times each string occurs, in descending order of frequency.*/

import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.sort;

public class Exercise_2_5_8 {

    private static Map<String, Integer> findFrequency(String[] a){
        sort(a);
        Map<String, Integer> words = new HashMap<>();
        words.put(a[0], 1);
        for (int i = 1; i < a.length; i++) {
            if(a[i].equals(a[i - 1]) && words.containsKey(a[i])){
                words.put(a[i], words.get(a[i]) + 1);
            } else {
                words.put(a[i], 1);
            }
        }
        return words;
    }

    public static void main(String[] args) {
        String[] a = "a b c d ff ff a b m n n ttt ttt ttt".split(" ");
        Map<String, Integer> frequency = findFrequency(a);
        frequency.forEach((k, v) -> StdOut.println(k + " -> " + v));
    }
}
