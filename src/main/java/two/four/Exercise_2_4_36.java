package two.four;

/*Performance driver I. Write a performance driver client program that uses insert
to fill a priority queue, then uses remove the maximum to remove half the keys, then
uses insert to fill it up again, then uses remove the maximum to remove all the keys, doing
so multiple times on random sequences of keys of various lengths ranging from small to large;
measures the time taken for each run; and prints out or plots the average running times. */

import edu.princeton.cs.algs4.Stopwatch;

import java.util.Random;

public class Exercise_2_4_36 {
    private static int size = 1000;
    private static int times = 10;
    private static Random random = new Random();

    public static void main(String[] args) {
        Stopwatch timer = new Stopwatch();
        MaxPQ<Double> queue = new MaxPQ<>(size);
        double average = 0.0;
        for (int i = 0; i < times; i++) {
            double result = doInsertRemove(queue, timer);
            System.out.print(result + ", ");
            average += result;
        }
        System.out.println("\n" + average/times);
    }

    public static double doInsertRemove(MaxPQ<Double> queue, Stopwatch timer){
        for (int i = 0; i < size; i++) {
            queue.insert(random.nextDouble());
        }
        for (int i = 0; i < size/2; i++) {
            queue.delMax();
        }
        for (int i = 0; i < size/2; i++) {
            queue.insert(random.nextDouble());
        }
        for (int i = 0; i < size; i++) {
            queue.delMax();
        }
        return timer.elapsedTime();
    }
}
