package one_four;// 4-sum. Develop an algorithm for the 4-sum problem.

public class Exercise_1_4_14 {

    private static int fourSum(int[] arr){
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                for(int k = j + 1; k < arr.length; k++){
                    for(int m = k + 1; m < arr.length; m++){
                        if(arr[i] + arr[j] + arr[k] + arr[m] == 0){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {-4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6};
        int[] arr2 = {-4, -2, 1, 5};
        int[] arr3 = {-100, -2, 1, 101};
        System.out.println(fourSum(arr));
        System.out.println(fourSum(arr2));
        System.out.println(fourSum(arr3));
    }
}
