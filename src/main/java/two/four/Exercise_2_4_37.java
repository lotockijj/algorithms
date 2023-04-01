package two.four;

/* Performance driver II. Write a performance driver client program that uses insert
to fill a priority queue, then does as many remove the maximum and insert operations
as it can do in 1 second, doing so multiple times on random sequences of keys of
various lengths ranging from small to large; and prints out or plots the average number
of remove the maximum operations it was able to do. */

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Exercise_2_4_37 {
    private static int size = 1000;
    private static int numberOfRemove = 0;
    private static int times = 10;
    private static Random random = new Random();

    public static void main(String[] args) {
        MaxPQ<Double> queue = new MaxPQ<>(size);
        int average = 0;
        for (int i = 0; i < size; i++) {
            queue.insert(random.nextDouble());
        }
        for (int i = 0; i < times; i++) {
            doInsertRemove(queue);
            average += numberOfRemove;
            numberOfRemove = 0;
        }
        System.out.println(average/times);
    }

    public static void doInsertRemove(MaxPQ<Double> queue){
        long start = System.currentTimeMillis();
        long end = start + 1000;
        while (System.currentTimeMillis() < end){
            queue.delMax();
            queue.insert(random.nextDouble());
            numberOfRemove++;
        }
    }
}
