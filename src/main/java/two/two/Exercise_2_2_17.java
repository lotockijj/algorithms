package two.two;

/*Linked-list sort. Implement a natural mergesort for linked lists. (This is the method of choice
for sorting linked lists because it uses no extra space and is guaranteed to be linearithmic.) */

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Exercise_2_2_17 {

    private static void sort(LinkedList<Integer> a){
        int lengthOfFirstSubArray = findSubArray(a, 0);
        for (int i = 0; i < a.size(); i++) {
            int lengthOfSecondSubArray = findSubArray(a, lengthOfFirstSubArray);
            lengthOfFirstSubArray = merge(a, lengthOfFirstSubArray, lengthOfSecondSubArray);
            i = lengthOfFirstSubArray;
        }
    }

    private static int merge(LinkedList<Integer> a, int lengthOfFirstSubArray, int lengthOfSecondSubArray) {
        int len = lengthOfFirstSubArray + lengthOfSecondSubArray;
        int loop = lengthOfFirstSubArray + lengthOfSecondSubArray;
        int[] temp = new int[lengthOfFirstSubArray + lengthOfSecondSubArray];
        int count = 0;
        int firstSubArrayIndex = 0;
        int secondSubArrayIndex = lengthOfFirstSubArray;
        for (int i = 0; i < loop; i++) {
            if(lengthOfFirstSubArray > 0 && secondSubArrayIndex < len
                    && a.get(firstSubArrayIndex) < a.get(secondSubArrayIndex)){
                temp[count] = a.get(firstSubArrayIndex);
                firstSubArrayIndex++;
                lengthOfFirstSubArray--;
            } else if(lengthOfSecondSubArray > 0){
                temp[count] = a.get(secondSubArrayIndex);
                secondSubArrayIndex++;
                lengthOfSecondSubArray--;
            } else if(!(secondSubArrayIndex < len)){
                temp[count] = a.get(firstSubArrayIndex);
                firstSubArrayIndex++;
                lengthOfFirstSubArray++;
            }
            count++;
        }
        int count2 = 0;
        for (int i = 0; i < len; i++) {
            a.set(i, temp[count2]);
            count2++;
        }
        return count;
    }

    private static int findSubArray(LinkedList<Integer> a, int i) {
        int result = 1;
        for (int j = i + 1; j < a.size(); j++) {
            if(a.get(j - 1) < a.get(j)){
                result++;
            } else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedList<Integer> numbers = Arrays.asList(1, -7, 3, -9, 5, 8, 9, -1, -2, -3, 10, 11)
                .stream()
                .collect(Collectors.toCollection(LinkedList::new));
        sort(numbers);
        printNumbers(numbers);
    }

    private static void printNumbers(LinkedList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            StdOut.print(numbers.get(i) + ", ");
        }
    }

}
