package three.five.experiments;

/*
Duplicates (revisited). Redo Exercise 2.5.31 using the Dedup filter given on page 490.
Compare the running times of the two approaches. Then use Dedup to run the experiments
for N = 10 7, 10 8, and10 9, repeat the experiments for random long values and discuss the results.
 */

/* Result from Exercise 2.5.31:
574->2.0       361->1.0       222->0.5
5716->2.0       3651->1.0       2132->0.5
56780->2.0       37037->1.0       21358->0.5
567705->2.0       367538->1.0       213092->0.5

424->2.0       628->1.0       793->0.5
4344->2.0       6285->1.0       7885->0.5
43205->2.0       63235->1.0       78605->0.5
432076->2.0       632217->1.0       786635->0.5
 */

import org.apache.commons.lang3.math.NumberUtils;
import three.BinarySearchST;
import three.five.BinarySearchSET;
import three.five.HashST;
import three.five.RedBlackBST_3_5_10;
import three.five.STint;

import java.util.*;

public class Exercise_3_5_30 {

    public static void main(String[] args) {
        // 10000, 100000, 1000000
        int m = 0; // n, 2*n
        int[] arrN = {1000, 10000, 100000, 1000000};
        for (int i = 0; i < arrN.length; i++) {
            for (int j = 0; j < 3; j++) {
                m = getMNumber(j, arrN[i]);
                int duplicates = getDuplicates(arrN[i], m);
                double n = 1.0 * arrN[i] / m;
                System.out.print(duplicates + "->" + n + "       "); // m = n/2 -> 563
            }
            System.out.println();
        }

    }

    private static int getMNumber(int j, int i) {
        if(j == 0) return i/2;
        if(j == 1) return i;
        if(j == 2) return 2*i;
        return 0;
    }

    private static int getDuplicates(int n, int m) {
        STint redBlackBST_3_5_10 = new STint();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            redBlackBST_3_5_10.put(random.nextInt(m - 1));
        }
        return redBlackBST_3_5_10.size();
    }
}
