package three.one;

/*Add code to FrequencyCounter to keep track of the last call to put(). Print the
last word inserted and the number of words that were processed in the input stream
prior to this insertion. Run your program for tale.txt with length cutoffs 1, 8, and 10.*/

import edu.princeton.cs.algs4.ST;
import three.FrequencyCounter;

public class Exercise_3_1_9 {

    public static void main(String[] args) {
        String path = "C:\\Users\\Роман\\Downloads\\alglorithms\\tale.txt";
        FrequencyCounter.findFrequencyCounter(path, 1);
        System.out.println("Last word: " + FrequencyCounter.lastWord + " . Number of words: " + FrequencyCounter.numberOfWords);
        FrequencyCounter.numberOfWords = 0;
        FrequencyCounter.findFrequencyCounter(path, 8);
        System.out.println("Number of words for cutoff  8: " +  FrequencyCounter.numberOfWords);
        FrequencyCounter.numberOfWords = 0;
        FrequencyCounter.findFrequencyCounter(path, 10);
        System.out.println("Number of words for cutoff 10: " +  FrequencyCounter.numberOfWords);
    }
}
