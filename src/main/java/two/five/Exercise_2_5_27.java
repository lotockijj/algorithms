package two.five;

/* Sorting parallel arrays. When sorting parallel arrays, it is useful to have a version
of a sorting routine that returns a permutation, say index[], of the indices in sorted
order. Add a method indirectSort() to Insertion that takes an array of Comparable
objects a[] as argument, but instead of rearranging the entries of a[] returns an integer
array index[] so that a[index[0]] through a[index[N-1]] are the items in ascending order.
*/

import edu.princeton.cs.algs4.StdOut;

public class Exercise_2_5_27 {

    public static void main(String[] args) {
        int[] arr = {1, 7, 4, 2, 5, 3, 6};
        int[] indexArr = getIndexArr(arr);
        sort(arr, indexArr);
        printIndexArr(indexArr);
    }

    private static void printIndexArr(int[] indexArr) {
        for (int i = 0; i < indexArr.length; i++) {
            StdOut.print(indexArr[i] + ", ");
        }
    }

    public static void sort(int[] a, int[] indexArr){
        for(int i = 1; i < a.length; i++){
            for(int j = i; j > 0 && less(a[indexArr[j]], a[indexArr[j - 1]]); j--){
                int temp = indexArr[j];
                indexArr[j] = indexArr[j - 1];
                indexArr[j - 1] = temp;
            }
        }
    }

    public static boolean less(int v, int w) {
        return v < w;
    }

    private static int[] getIndexArr(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = i;
        }
        return result;
    }
}
