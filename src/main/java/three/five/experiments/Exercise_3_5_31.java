package three.five.experiments;

/*
Spell checker. With the file dictionary.txt from the booksite as command-line argument,
the BlackFilter client described on page 491 prints all misspelled words in a text file taken
from standard input. Compare the performance of RedBlackBST, SeparateChainingHashST, and LinearProbingHashST
for the file WarAndPeace.txt (available on the booksite) with this client and discuss the results.
 */
// RedBlackBST (Elapsed time: 3.0 . Number of all misspelled words: 91185)
// SeparateChainingHashST (Elapsed time: 3.036 . Number of all misspelled words: 91185)
// LinearProbingHashST (Elapsed time: 2.5 . Number of all misspelled words: 91185)

import edu.princeton.cs.algs4.*;
import org.apache.commons.lang3.math.NumberUtils;

public class Exercise_3_5_31 {

    public static void main(String[] args) {
        In in = new In("C:\\Users\\Роман\\Downloads\\alglorithms2\\dictionary.txt");
        SeparateChainingHashST<String, Integer> redBlackBST = new SeparateChainingHashST<>();
        Stopwatch timer = new Stopwatch();
        while(!in.isEmpty()){
            redBlackBST.put(in.readString(), NumberUtils.INTEGER_ONE);
        }
        In in2 = new In("C:\\Users\\Роман\\Downloads\\alglorithms2\\WarAndPeace.txt");
        int count = 0;
        while(!in2.isEmpty()){
            String str = in2.readString().replace(",", "")
                    .replace(".", "")
                    .replace(";", "")
                    .replace("\"", "")
                    .replace(":", "")
                    .replace("(", "")
                    .replace(")", "")
                    .replace("?", "");
            if(!redBlackBST.contains(str) && !str.isEmpty() && str.length() > 2){
                System.out.println(str);
                count++;
            }
        }
        double elapsedTime = timer.elapsedTime();
        System.out.println("Elapsed time: " + elapsedTime + " . Number of all misspelled words: " + count);
    }
}
