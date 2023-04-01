package two.five;

/*Duplicates. Write a client that takes integers M, N, and T as command-line arguments,
then uses the code given in the text to perform T trials of the following experiment:
Generate N random int values between 0 and M – 1 and count the number of
duplicates. Run your program for T = 10 and N = 10 3, 10 4, 10 5, and 10 6, with M = N / 2,
and N, and 2N. Probability theory says that the number of duplicates should be about
(1 – e –alfa(power) where alfa = N / M — print a table to help you confirm that your experiments
validate that formula.*/

import java.util.Arrays;
import java.util.Random;

public class Exercise_2_5_31 {

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
        Random random = new Random();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(m - 1);
        }
        Arrays.sort(a);
        int duplicates = 0;
        for (int i = 1; i < a.length; i++) {
            if(a[i] == a[i - 1]){
                duplicates++;
            }
        }
        return duplicates;
    }
}
