package two.five;

/* Write a program that reads a list of words from standard input and prints all two-
word compound words in the list. For example, if after, thought, and afterthought
are in the list, then afterthought is a compound word. */

import java.util.Arrays;
import java.util.Comparator;

public class Exercise_2_5_2 {

    public static void main(String[] args) {
        String[] strings = {"after", "thought", "afterthought"};
        String[] strings2 = {"allStill", "thought", "all", "Still",  "after", "afterthought"};
        Arrays.sort(strings2, Comparator.comparing(String::length));
        printCompaundWords(strings);
        printCompaundWords(strings2);
    }

    private static void printCompaundWords(String[] a) {
        for (int i = 2; i < a.length; i++) {
            for (int j = 1; j < i; j++) {
                for (int k = 0; k < j; k++) {
                    if(a[i].length() != a[j].length() + a[k].length()){
                        continue;
                    } else {
                        if((a[j] + a[k]).equals(a[i]) || (a[k] + a[j]).equals(a[i])){
                            System.out.println(a[i]);
                        }
                    }
                }
            }
        }
    }
}