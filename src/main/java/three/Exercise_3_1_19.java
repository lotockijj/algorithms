package three;

/* Modify FrequencyCounter to print all of the values having the highest
   frequency of occurrence, not just one of them. Hint : Use a Queue. */

import edu.princeton.cs.algs4.ST;

public class Exercise_3_1_19 {

    public static void main(String[] args) {
        String path = "C:\\Users\\Роман\\Downloads\\alglorithms\\tale.txt";
        ST<String, Integer> frequencyCounter = FrequencyCounter.findFrequencyCounter(path, 1);
        Iterable<String> keys = frequencyCounter.keys();
        int highestValueBorder = 4000;
        for (String s: keys){
            Integer occurrencesNumber = frequencyCounter.get(s);
            if(occurrencesNumber >= highestValueBorder){
                System.out.println(s + "  ->   " + occurrencesNumber);
            }
        }
    }
}
