package one_four;

import edu.princeton.cs.algs4.StdOut;
// Write a program that, given two sorted arrays of N int values, prints all
// elements that appear in both arrays, in sorted order. The running time of your program
// should be proportional to N in the worst case.

public class Exercise_1_4_12 {

    private static void intersection(int[] a, int[] b){
        int length = a.length > b.length ? a.length : b.length;
        int tempA;
        int tempB;
        int indexA = 0;
        int indexB = 0;
        for(int i = 0; i < length; i++){
            tempA = a[indexA];
            tempB = b[indexB];
            if(tempA > tempB){
                indexB++;
                continue;
            } else if(tempB > tempA){
                indexA++;
                continue;
            } else {
                StdOut.print(tempA + " ");
                indexA++;
                indexB++;
            }
            if(indexA >= a.length || indexB >= b.length) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {-1, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] b = {2, 3, 7, 11, 12};
        intersection(a, b);
    }

}
