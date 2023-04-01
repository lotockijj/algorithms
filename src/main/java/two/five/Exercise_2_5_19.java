package two.five;

/* Kendall tau distance. Write a program KendallTau.java that computes the
Kendall tau distance between two permutations in linearithmic time. 0-1, 3-1, 2-4, 5-4 */

import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;
import java.util.Map;

public class Exercise_2_5_19 {

    public static void main(String[] args) {
        int[] firstArr =  {0, 3, 1, 6, 2, 5, 4};
        int[] secondArr = {1, 0, 3, 6, 4, 2, 5};
        printKendalTauDistance(firstArr, secondArr);
        int[] thirdArr = {4, 2, 3, 5, 6, 7, 8, 9, 1};
        int[] forthArr = {1, 2, 7, 9, 3, 6, 8, 5, 4};
        printKendalTauDistance(thirdArr, forthArr);
    }

    private static void printKendalTauDistance(int[] firstArr, int[] secondArr) {
        int sizeOfPermutation = 0;
        for (int i = 0; i < firstArr.length; i++) {
            for (int j = 0; j < secondArr.length; j++) {
                if(firstArr[i] == secondArr[j]){
                    for (int k = i - 1; k >= 0 ; k--) {
                        for (int l = j + 1; l < secondArr.length; l++) {
                            if(firstArr[k] == secondArr[l]){
                                StdOut.println(firstArr[k] + " " + secondArr[j]);
                                sizeOfPermutation++;
                            }
                        }
                    }
                }
            }
        }
        StdOut.println("Size: " + sizeOfPermutation);
    }
}
