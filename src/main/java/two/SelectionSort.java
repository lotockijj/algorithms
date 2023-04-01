package two;

import edu.princeton.cs.algs4.StdOut;

public class SelectionSort {

    public static void sort(Double[] a){
        for(int i = 0; i < a.length; i++){
            for(int j = i + 1; j < a.length; j++){
                if(Example.lessDouble(a[j] , a[i])){
                    Double temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Double[] a = {-10.0, 0.0, 1.0, 2.0, 8.0, 3.0, 5.0, -5.0};
        sort(a);
        for (int i = 0; i < a.length; i++){
            StdOut.print(a[i] + ", ");
        }
    }
}
