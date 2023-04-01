package one_four;/*Bitonic search. An array is bitonic if it is comprised of an increasing sequence
of integers followed immediately by a decreasing sequence of integers. Write a program
that, given a bitonic array of N distinct int values, determines whether a given integer
is in the array. Your program should use ~3lg N compares in the worst case. */

public class Exercise_1_4_20 {

    private static int bitonicSearch(int[] a, int t){
        int max = findMax(a);
        if(a[max] == t) return 1;
        int result = searchLeft(a, 0, max, t);
        if(result == 1){
            return 1;
        } else {
            result = searchRight(a, max, a.length - 1, t);
        }
        return result;
    }

    private static int searchRight(int[] a, int left, int right, int t) {
        while(left != right){
            int mid = (left + right)/2;
            if(a[mid] > t){
                left = mid;
                mid = (left + right)/2;
            } else if(a[mid] < t){
                right = mid;
                mid = (left + right)/2;
            }
            if(a[mid] == t) {
                return 1;
            }
            if(mid == right || mid == left) break;
        }
        return -1;
    }

    private static int searchLeft(int[] a, int left, int right, int t){
        while(left != right){
            int mid = (left + right)/2;
            if(a[mid] < t){
                left = mid;
                mid = (left + right)/2;
            } else if(a[mid] > t){
                right = mid;
                mid = (left + right)/2;
            }
            if(a[mid] == t) {
                return 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] bitonicArray1 = { -1, 1, 2, 3, 4, 5, 6, 100, 89, 9, 8, 7, -1, -3, -66, -100, -1000};
        int[] bitonicArray2 = {1, 2, 3, 4, 5, 7, 6};
        System.out.println(bitonicSearch(bitonicArray1, -33));
        System.out.println(bitonicSearch(bitonicArray2, 3));
    }

    private static int findMax(int[] a){
        int middle = a.length/2 - 1;
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            if(a[middle] > a[middle - 1]){
                left = middle;
                middle = (left + right)/2;
            } else if( a[middle] < a[middle - 1]){
                right = middle;
                middle = (left + right)/2;
            }
            if(middle == right || middle == left) break;
        }
        return middle;
    }
}
