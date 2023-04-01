package one_four;/*Local minimum of an array. Write a program that, given an array a[] of N dis-
tinct integers, finds a local minimum: an index i such that a[i-1] < a[i] < a[i+1].
Your program should use ~2lg N compares in the worst case..
Answer : Examine the middle value a[N/2] and its two neighbors a[N/2 - 1] and
a[N/2 + 1]. If a[N/2] is a local minimum, stop; otherwise search in the half with the
smaller neighbor.*/

import edu.princeton.cs.algs4.StdOut;

public class Exercise_1_4_18 {

    private static int[] findLocalMinimum(int[] a){
        int[] result = new int[3];
        int len = a.length;
        for(int i = len/2; i > 0; i/=2){
            if(a[i - 1] < a[i] && a[i] < a[i + 1]) {
                result[0] = a[i - 1];
                result[1] = a[i];
                result[2] = a[i + 1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {-100, 1, 2, 3, 7, 9, 15, 100};
        int[] res = findLocalMinimum(a);
        for(int i = 0; i < res.length; i++){
            StdOut.print(res[i] + "  ");
        }
    }
}
