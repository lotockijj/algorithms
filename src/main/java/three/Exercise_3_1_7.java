package three;

/*  What is the average number of distinct keys that FrequencyCounter will find
    among N random nonnegative integers less than 1,000, for N=10, 102, 103, 104, 105, and 106? */

import edu.princeton.cs.algs4.ST;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Exercise_3_1_7 {

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("Distinct keys for 10     : " + FrequencyCounter.findDistinctKeys(getRandomList(random, 10)));
        System.out.println("Distinct keys for 100    : " + FrequencyCounter.findDistinctKeys(getRandomList(random, 100)));
        System.out.println("Distinct keys for 1000   : " + FrequencyCounter.findDistinctKeys(getRandomList(random, 1000)));
        System.out.println("Distinct keys for 10000  : " + FrequencyCounter.findDistinctKeys(getRandomList(random, 10000)));
        System.out.println("Distinct keys for 100000 : " + FrequencyCounter.findDistinctKeys(getRandomList(random, 100000)));
        System.out.println("Distinct keys for 1000000: " + FrequencyCounter.findDistinctKeys(getRandomList(random, 1000000)));
        System.out.println("Distinct keys for 1000000: " + findDistinctKeys2(1000));
    }

    private static int findDistinctKeys2(int size) {
        Random random = new Random();
        ST<String, Integer> st = new ST<>();

        for (int j = 0; j < size; j++) {
            st.put(String.valueOf(random.nextInt(1000)), j);
        }
        return st.size();
    }

    private static List<Integer> getRandomList(Random random, int size) {
        List<Integer> numbers = new ArrayList<>();
        for (int j = 0; j < size; j++) {
            numbers.add(random.nextInt(1000));
        }
        return numbers;
    }
}
