package two.two;

import edu.princeton.cs.algs4.StdDraw;
import two.Example;

public class Exercise_2_1_17 {
    //Sort
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i <N; i++) {
            int min = i;
            for (int j = i + 1; j <N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
            draw(a);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clear();
        }
        draw(a);
    }

    public static void sort(Double[] a){
        for(int i = 1; i < a.length; i++){
            for(int j = i; j > 0 && Example.less(a[j], a[j - 1]); j--){
                Double temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
                draw(a);
            }
            clear();
        }
        draw(a);
    }

    //Drawing
    public static void draw(Comparable[] a) {
        int N=a.length;
        for(int i=0;i<N;i++) {
            double x=1.0*i/N;
            double y=(double)a[i]/2.0;
            double rw=0.5/N;
            double rh=(double)a[i]/2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }
    //Clear
    public static void clear() {
        StdDraw.clear();
    }
    //Interact two elements
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    //Display all elements
    private static void show(Comparable[] a) {
        for (int i = 0; i <a.length; i++)
            System.out.print(a[i] + "");
        System.out.println();
    }
    //Compare the size of two elements
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) <0;
    }
    //Determine whether to sort
    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i <a.length; i++)
            if (less(a[i], a[i-1]))
                return false;
        return true;
    }

    public static void main(String[] args) {
        int N=50;
//        Comparable[] a=new Comparable[N];
//        for(int i=0;i<N;i++)
//            a[i]=Math.random();
//        sort(a);
        Double[] a = new Double[N];
        for(int i = 0; i < N; i++){
            a[i] = Math.random();
        }
        sort(a);
    }
}
