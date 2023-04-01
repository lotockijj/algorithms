package two.two;

/* Bottom-up queue mergesort. Develop a bottom-up mergesort implementation based on the following approach:
Given N items, create N queues, each containing one of the items. Create a queue of the N queues.
Then repeatedly apply the merging operation of Exercise 2.2.14 to the first two queues and reinsert
the merged queue at the end. Repeat until the queue of queues contains only one queue. */

import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Exercise_2_2_15 {

    private static Queue<Integer> mergeValuesIntoQueue(int ... values){
        Map<String, LinkedList<Integer>> temp = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String nameOfQueue = String.valueOf(i);
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(values[i]);
            temp.put(nameOfQueue, queue);
        }
        Queue<Integer> tempQueue = merge(values, 0, values.length - 1);
        return tempQueue;
    }

    private static Queue<Integer> merge(int[] values, int start, int end) {
        if(end - start == 1){
            Queue<Integer> firstQueue = new LinkedList<>();
            Queue<Integer> secondQueue = new LinkedList<>();
            firstQueue.add(values[start]);
            secondQueue.add(values[end]);
            return Exercise_2_2_14.mergeQueues(firstQueue, secondQueue);
        } else if(end == start){
            Queue<Integer> queue = new LinkedList<>();
            queue.add(values[end]);
            return queue;
        } else {
            int mid = (end - start)/2 + start;
            Queue<Integer> mergeFirst = merge(values, start, mid);
            Queue<Integer> mergeSecond = merge(values, mid + 1, end);
            return Exercise_2_2_14.mergeQueues(mergeFirst, mergeSecond);
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = mergeValuesIntoQueue(2, 7, 9, 13, 265, -10, 222, -100, -1);
        queue.stream().forEach(e -> StdOut.print(e + ", "));
    }
}
