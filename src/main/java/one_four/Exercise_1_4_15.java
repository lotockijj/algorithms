package one_four;/*
uses a linear algorithm to count the pairs that sum to zero after the array is sorted
(instead of the binary-search-based linearithmic algorithm). Then apply a similar idea to
develop a quadratic algorithm for the 3-sum problem. */

public class Exercise_1_4_15 {

    private static int twoSumFaster(int[] arr){
        int start = arr[0];
        int end = arr[arr.length - 1];
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(start >= end) {
                break;
            }
            if(start + end > 0){
                end = arr[arr.length - i];
            }
            if(start + end < 0) {
                start = arr[i++];
            }
            if(start + end == 0){
                count++;
                start = arr[i + 1];
                end = arr[arr.length - i - 2];
            }
        }
        return count;
    }

    private static int threeSumFaster(int[] arr){
        int count = 0;
        for(int i = 0; i < arr.length - 2; i++){
            for(int j = i + 1, k = arr.length - 1; j < k;){
               if(arr[i] + arr[j] + arr[k] < 0){
                   j++;
               } else if(arr[i] + arr[j] + arr[k] > 0){
                   k--;
               } else {
                   j++;
                   k--;
                   count++;
               }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = {-5, -4, 3, 5};
        int[] arr2 = {-100, -5, -4, 3, 5, 6, 7, 100};
        int[] arr3 = {-100, -88, -4, 1, 4, 88, 100};
        System.out.println(twoSumFaster(arr1));
        System.out.println(twoSumFaster(arr2));
        System.out.println(twoSumFaster(arr3));

        int[] arr4 = {-5, 2, 3};
        int[] arr5 = {-5, -4, -3, 2, 3, 7};
        System.out.println(threeSumFaster(arr4));
        System.out.println(threeSumFaster(arr5));
    }

}
