package two.two;

/* Merging sorted queues. Develop a static method that takes two queues of sorted items as arguments
and returns a queue that results from merging the queues into sorted order.*/

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Exercise_2_2_14 {

    public static Queue<Integer> mergeQueues(Queue<Integer> queue1, Queue<Integer> queue2){
        Queue<Integer> result = new LinkedList<>();
        boolean shouldContinueForFirstQueue;
        boolean shouldContinueForSecondQueue;
        int len = queue1.size() + queue2.size();
        for (int i = 0; i < len; i++) {
            shouldContinueForFirstQueue = !queue1.isEmpty();
            shouldContinueForSecondQueue = !queue2.isEmpty();
            if (shouldContinueForFirstQueue && shouldContinueForSecondQueue && queue1.peek() < queue2.peek()) {
                result.add(queue1.poll());
                continue;
            } else if (!shouldContinueForSecondQueue){
                result.add(queue1.poll());
            } else if (shouldContinueForSecondQueue) {
                result.add(queue2.poll());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedList<Integer> queue1 = Arrays.asList(-200, -2, 1, 2, 3, 4, 5, 100).stream().collect(Collectors.toCollection(LinkedList::new));
        LinkedList<Integer> queue2 = Arrays.asList(-100, -3, 7, 9, 10, 11, 22, 101, 201).stream().collect(Collectors.toCollection(LinkedList::new));
        Queue<Integer> queue = mergeQueues(queue1, queue2);
        StdOut.println(queue.size());
        while(!queue.isEmpty()){
            StdOut.print(queue.poll() + ", ");
        }
    }
}
