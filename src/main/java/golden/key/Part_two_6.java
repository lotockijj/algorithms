package golden.key;

/* Multiplying 32 and 46 has and it has such ability: if you change digit in numbers the result of multiplying doesn't change .
  Find all pairs of two digit numbers that have such ability.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Part_two_6 {
    private static int count = 0;

    public static void main(String[] args) {
        List<List<Integer>> resultOfLists = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if(i == j) continue;
                for (int k = 1; k <= 9; k++) {
                    for (int l = 1; l <= 9; l++) {
                        if(k == l) continue;
                        if(i == k && j == l) continue;
                        if(i == l && j == k) continue;
                        int firstTwoValues = getStringSum(i, j);
                        int secondTwoValues = getStringSum(k, l);
                        int thirdTwoValues = getStringSum(j, i);
                        int fourthTwoValues = getStringSum(l, k);
                        if(firstTwoValues*secondTwoValues == thirdTwoValues*fourthTwoValues){
                            if(doesntContainValues(resultOfLists, firstTwoValues, secondTwoValues, thirdTwoValues, fourthTwoValues)){
                                resultOfLists.add(Arrays.asList(firstTwoValues, secondTwoValues, thirdTwoValues, fourthTwoValues));
                                count++;
                            }
                        }
                    }
                }
            }
        }
        printValues(resultOfLists);
        System.out.println("Size:" + count);
    }

    private static void printValues(List<List<Integer>> resultOfLists) {
        for (int i = 0; i < resultOfLists.size(); i++) {
            System.out.println(resultOfLists.get(i));
        }
    }

    private static boolean doesntContainValues(List<List<Integer>> resultOfLists, int firstTwoValues,
                                               int secondTwoValues, int thirdTwoValues, int fourthTwoValues) {
        for (int i = 0; i < resultOfLists.size(); i++) {
            List<Integer> values = resultOfLists.get(i);
            if(     values.contains(firstTwoValues) &&
                    values.contains(secondTwoValues) &&
                    values.contains(thirdTwoValues) &&
                    values.contains(fourthTwoValues)){
                return false;
            }
        }
        return true;
    }

    private static int getStringSum(int i, int j){
        return Integer.valueOf(String.valueOf(i) + String.valueOf(j));
    }
}
