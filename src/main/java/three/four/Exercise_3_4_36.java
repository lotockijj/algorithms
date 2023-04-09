package three.four;

/*
List length range. Write a program that inserts N random int keys into a table of size N / 100 using separate chaining,
then finds the length of the shortest and longest lists, for N = 10 3, 10 4, 10 5, 10 6.
 */

import three.SequentialSearchST;

public class Exercise_3_4_36 { // Longest: 1000 -> 5, 10000 -> 19, 100000 -> 122, 1000000 -> 1054
                               // Shortest:        1,          1,              1,               1
    public static void main(String[] args) {
        SeparateChainingHashST<String, Integer> separateChainingHashST = fillSeparateChainingHashST(1000000);
        String longestShortestLists = getLongestList(separateChainingHashST);
        System.out.println(longestShortestLists);
    }

    public static String getLongestList(SeparateChainingHashST<String, Integer> separateChainingHashST){
        SequentialSearchST<String, Integer>[] st = separateChainingHashST.getSt();
        int countLongest = 0;
        int tempLongest = 0;
        int countShort = 1000000;
        int tempShort = 1;
        for (int i = 0; i < st.length; i++) {
            if(st[i].getFirst() != null){
                tempLongest = st[i].size();
                if(countLongest < tempLongest) {
                    countLongest = tempLongest;
                }
                if(countShort > tempShort && tempShort != 0){
                    countShort = tempShort;
                }
            } else {
                if(countLongest < tempLongest) {
                    countLongest = tempLongest;
                }
                if(countShort > tempShort && tempShort != 0){
                    countShort = tempShort;
                }
                tempLongest = 0;
                tempShort = 0;
            }
        }
        return countLongest + " " + countShort;
    }

    public static SeparateChainingHashST<String, Integer> fillSeparateChainingHashST(int n) {
        n = n/10;
        SeparateChainingHashST<String, Integer> separateChainingHashST = new SeparateChainingHashST<>();
        String[] strings = "S E A R C H X M P L".split(" ");
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                String str = strings[i] + (i + 3) * (j + 1);
                separateChainingHashST.put(str, i);
            }
        }
        return separateChainingHashST;
    }
}
