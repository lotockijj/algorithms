package two.two;

/* Shuffling a linked list. Develop and implement a divide-and-conquer algorithm
that randomly shuffles a linked list in linearithmic time and logarithmic extra space. */

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.stream.Collectors;

public class Exercise_2_2_18 {

    private static void shuffleLinkedList(LinkedList<Integer> numbers) {
        Random r = new Random();
        shuffleHalf(numbers, r, 0, numbers.size());
    }

    private static void shuffleHalf(LinkedList<Integer> numbers, Random r, int low, int high) {
        int mid = low + (high - low)/2;
        if(mid == 1){
            return;
        }
        for (int j = low; j < high; j++) {
            if(r.nextBoolean() && mid + j < numbers.size() && mid > 1){
                int temp = numbers.get(j);
                numbers.set(j, numbers.get(mid + j));
                numbers.set(mid + j, temp);
            }
        }
        if(mid > 1 && mid > low && mid < high){
            shuffleHalf(numbers, r, low, mid);
            shuffleHalf(numbers, r, mid + 1, high);
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> numbers = Arrays.asList(-100, -50, -3, -2, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10).stream()
                .collect(Collectors.toCollection(LinkedList::new));
        shuffleLinkedList(numbers);
        printLinkedList(numbers);
    }

    private static void printLinkedList(LinkedList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            StdOut.print(numbers.get(i) + ", ");
        }
    }
}
