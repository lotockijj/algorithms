package two.two;

/* Natural mergesort. Write a version of bottom-up mergesort that takes advantage of order
in the array by proceeding as follows each time it needs to find two arrays to merge:
find a sorted subarray (by incrementing a pointer until finding an entry that
is smaller than its predecessor in the array), then find the next, then merge them.
Analyze the running time of this algorithm in terms of the array size and the number of
maximal increasing sequences in the array.
 */

import edu.princeton.cs.algs4.StdOut;

public class Exercise_2_2_16 {

    public static void naturalMergeSort(int[] a){
        int lengthOfFirstSubArray = findSubArray(a, 0);
        for (int i = 0; i < a.length; i++) {
            int lengthOfSecondSubArray = findSubArray(a, lengthOfFirstSubArray);
            lengthOfFirstSubArray = merge(a, lengthOfFirstSubArray, lengthOfSecondSubArray);
            i = lengthOfFirstSubArray;
        }
    }

    private static int merge(int[] a, int lengthOfFirstSubArray, int lengthOfSecondSubArray) {
        int len = lengthOfFirstSubArray + lengthOfSecondSubArray;
        int loop = lengthOfFirstSubArray + lengthOfSecondSubArray;
        int[] temp = new int[lengthOfFirstSubArray + lengthOfSecondSubArray];
        int count = 0;
        int firstSubArrayIndex = 0;
        int secondSubArrayIndex = lengthOfFirstSubArray;
        for (int i = 0; i < loop; i++) {
            if(lengthOfFirstSubArray > 0 && secondSubArrayIndex < len && a[firstSubArrayIndex] < a[secondSubArrayIndex]){
                temp[count] = a[firstSubArrayIndex];
                firstSubArrayIndex++;
                lengthOfFirstSubArray--;
            } else if(lengthOfSecondSubArray > 0){
                temp[count] = a[secondSubArrayIndex];
                secondSubArrayIndex++;
                lengthOfSecondSubArray--;
            } else if(!(secondSubArrayIndex < len)){
                temp[count] = a[firstSubArrayIndex];
                firstSubArrayIndex++;
                lengthOfFirstSubArray++;
            }
            count++;
        }
        int count2 = 0;
        for (int i = 0; i < len; i++) {
            a[i] = temp[count2];
            count2++;
        }
        return count;
    }

    private static int findSubArray(int[] a, int i) {
        int result = 1;
        for (int j = i + 1; j < a.length; j++) {
            if(a[j - 1] < a[j]){
                result++;
            } else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, -3, -2, 5, 7, 23, 6, 8, 9};
        naturalMergeSort(a1);
        printArr(a1);
        int[] a2 = {1, -7, 3, -9, 5, 8, 9, -1, -2, -3, 10, 11};
        naturalMergeSort(a2);
        printArr(a2);
    }

    private static void printArr(int[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + ", ");
        }
        StdOut.println();
    }
}
