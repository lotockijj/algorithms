package two.five;

/*One way to describe the result of a sorting algorithm is to specify a permutation p[] of the numbers 0 to a.length-1,
such that p[i] specifies where the key originally in a[i] ends up.
Give the permutations that describe the results of insertion sort, selection sort, shellsort, mergesort, quicksort,
and heapsort for an array of seven equal keys. */

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Random;

public class Exercise_2_5_11 {

    private class Data implements Comparable<Data>{
        public int number;
        public int order;

        public Data(int number, int order) {
            this.number = number;
            this.order = order;
        }

        @Override
        public int compareTo(Data data) {
            if(this.number > data.number) return 1;
            if(this.number < data.number) return -1;
            return 0;
        }

        @Override
        public String toString() {
            return /*number + " - " +*/ order + "";
        }
    }

    public static void main(String[] args) {
        Data[] data = getData(7);
        printData(data);
        selectionSort(data);
        printData(data);
    }

    private static void printData(Data[] data) {
        Arrays.stream(data).forEach(e-> StdOut.print(e + ",  "));
        StdOut.println();
    }

    private static Data[] getData(int len) {
        Data[] data = new Data[8];
        Exercise_2_5_11 exercise_2_5_11 = new Exercise_2_5_11();
        for (int i = 0; i < len; i++) {
            data[i] = exercise_2_5_11.new Data(7, i);
        }
        data[7] = exercise_2_5_11.new Data(8, 8);
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                if(i != j){
                    if(random.nextBoolean()){
                        exch(data, i, j);
                    }
                }
            }
        }
        return data;
    }

    private static void selectionSort(Data[] data){
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                if(i != j){
                    if(data[i].number < data[j].number){
                        exch(data, i, j);
                    }
                }
            }
        }
    }

    private static void exch(Data[] data, int i, int j){
        Data temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}

