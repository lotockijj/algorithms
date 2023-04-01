package golden.key;

/*  Calculator makes only 2 operations 2*a + 1 and (a - 1)/3 .
    How many operations do we need in order to reach from number 1 - a)10, b)8.
    Can we receive from number 1 all digit from 2 to 9.
 */

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Kee_two_9 {
    public static void main(String[] args) {
        int i = 1;
        Random random = new Random();
        Set<Integer> resultSet = new HashSet<>();
        for (int j = 0; j < 1000; j++) {
            i = operationOne(i, random, resultSet);
            i = operationTwo(i, random, resultSet);
        }
        resultSet.forEach(System.out::println);
    }

    private static int operationOne(int i, Random random, Set<Integer> resultSet) {
        int result = i;
        if(random.nextBoolean()) result = 2*i + 1;
        if(result < 11) resultSet.add(result);
        return result;
    }

    private static int operationTwo(int i, Random random, Set<Integer> resultSet) {
        int result = i;
        if(random.nextBoolean()) result = (i - 1)/3;
        if(result < 11) resultSet.add(result);
        return result;
    }
}
