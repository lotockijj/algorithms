package golden.key;

/* Marry has four pennies: 1, 2, 5, 10k. How much sums from 1 to 18k can't she pay without change ? */

import edu.princeton.cs.algs4.StdOut;

import java.util.*;

public class Kee_4_5_1 {
    public static void main(String[] args) {
        List<Integer> coins = Arrays.asList(1, 2, 5, 10);
        int sum = 18;
        printNotPossibleSumsWithRandom(coins, sum);
        printNotPossibleSumsWith(coins, sum);
    }

    private static void printNotPossibleSumsWith(List<Integer> coins, int len) {
        int m = coins.get(0);
        int k = coins.get(1);
        int c = coins.get(2);
        int n = coins.get(3);
        Set<Integer> sums = new HashSet<>();
        Set<Integer> allSums = getAllSums(len);
        deleteSum(sums, m, k, c, n);
        allSums.forEach(e -> System.out.print(e + ", "));
        StdOut.println();
    }

    private static void deleteSum(Set<Integer> sums, Integer ... values){
        
        Integer[] newValue = values;
        if(values.length == 0){
            return;
        }
    }

    private static void printNotPossibleSumsWithRandom(List<Integer> coins, int len) {
        int m = coins.get(0);
        int k = coins.get(1);
        int c = coins.get(2);
        int n = coins.get(3);
        Set<Integer> sums = new HashSet<>();
        Set<Integer> allSums = getAllSums(len);
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int sum = 0;
            if(random.nextBoolean()) sum += m;
            if(random.nextBoolean()) sum += k;
            if(random.nextBoolean()) sum += c;
            if(random.nextBoolean()) sum += n;
            sums.add(sum);
            if(allSums.contains(sum)){
                allSums.remove(sum);
            }
        }
        allSums.forEach(e -> System.out.print(e + ", "));
        StdOut.println();
    }

    private static Set<Integer> getAllSums(int len) {
        Set<Integer> allSums = new HashSet<>();
        for (int i = 0; i < len; i++) {
            allSums.add(i + 1);
        }
        return allSums;
    }
}
