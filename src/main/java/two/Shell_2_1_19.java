package two;

/*2.1.19 Shellsort worst case. Construct an array of 100 elements containing the numbers 1 through 100
for which shellsort, with the increments 1 4 13 40, uses as large a number of compares as you can find.*/

import edu.princeton.cs.algs4.StdOut;

import java.util.Random;

import static two.Example.exch;

public class Shell_2_1_19 {
    private static int sum = 0;


        public static void sort(Double[] a) { // Sort a[] into increasing order.
            int N = a.length;
            int h = 1;
            while (h < N/3) h = 3*h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
            while (h >= 1) { // h-sort the array.
                for (int i = h; i < N; i++) { // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
                    for (int j = i; j >= h; j -= h) {
                        if(a[j] < a[j-h]) {
                            sum++;
                            exch(a, j, j - h);
                        } else {
                            break;
                        }
                    }
                    //StdOut.println("Number of compares divided by array size: " + sum/N);
                }
                h = h/3;
            }
        }

        public static void main(String[] args) {
            Double[] a = getReverseArray();
            sort(a);
            StdOut.println(sum);
            sum = 0;
            Double[] arr = getRandomArray();
            sort(arr);
            StdOut.println(sum);
            sum = 0;
            Double[] arr2 = getFourtyArray();
            sort(arr2);
            StdOut.println(sum);
            Double[] shuffledArray = shuffledArray();
            sum = 0;
            sort(shuffledArray);
            StdOut.println(sum);

        }

        private static void print(Comparable[] a){
            for(int i = 0; i < a.length; i++){
                StdOut.print(a[i] + ", ");
            }
        }

        private static Double[] getReverseArray(){
            Double[] a = new Double[100];
            for(int i = 0; i < a.length; i++){
                a[i] = 0.0 - i*i;
            }
            return a;
        }

        private static Double[] getRandomArray(){
            Double[] a = new Double[100];
            Random r = new Random();
            for (int i = 0; i < a.length; i++){
                a[i] = r.nextDouble();
            }
            return a;
        }

        private static Double[] getFourtyArray(){
            Double[] a = new Double[100];
            int k = 0;
            for(int i = a.length - 1; i >= 0; i--){
                a[i] = k + 0.0;
                k++;
                if(k == 39){
                    k = 40;
                }
                if(k == 79){
                    k = 80;
                }
            }
            return a;
        }

    public static Double[] shuffledArray() { // Sort a[] into increasing order.
        Double[] a = getOrderedArray();
        int N = a.length;
        int h = 40;
        //while (h < N/3) h = 3*h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
        while (h <= 41) { // h-sort the array.
            for (int i = h; i < N; i++) { // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
                for (int j = i; j >= h; j -= h) {
                    if(a[j] > a[j-h]) {
                        exch(a, j, j - h);
                    }
                }
                //StdOut.println("Number of compares divided by array size: " + sum/N);
            }
            h = 3*h + 1;
        }
        return a;
    }

    private static Double[] getOrderedArray() {
            Double[] a = new Double[100];
            for(int i = 0; i < a.length; i++){
                a[i] = 0.0 + i;
            }
            return a;
    }
}