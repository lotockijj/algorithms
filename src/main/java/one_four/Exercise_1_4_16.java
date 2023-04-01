package one_four;/*Closest pair (in one dimension). Write a program that, given an array a[] of N
  double values, finds a closest pair : two values whose difference is no greater than the
  the difference of any other pair (in absolute value). The running time of your program
  should be linearithmic in the worst case.*/

import java.util.Arrays;

public class Exercise_1_4_16 {

    private static Pair findClosestPair(double[] a){
        Arrays.sort(a);
        double firstValue = a[0];
        double secondValue = a[1];
        double diff = secondValue - firstValue;

        for(int i = 2; i < a.length - 1; i++){
            if(a[i] - a[i + 1] < 0){
                if((a[i] - a[i + 1])*(-1) < diff ){
                    diff = (a[i] - a[i + 1])*(-1);
                    firstValue = a[i];
                    secondValue = a[i + 1];
                }
            } else if(a[i] - a[i+1] < diff){
                diff = a[i] + a[i + 1];
                firstValue = a[i];
                secondValue = a[i + 1];
            }
        }
        return new Pair(firstValue, secondValue);
    }

    private static Pair findFarthestPair(double[] a){
        Arrays.sort(a);
        double firstValue = a[0];
        double secondValue = a[1];
        double diff = secondValue - firstValue;

        for(int i = 2; i < a.length - 1; i++){
            if(a[i] - a[i + 1] < 0){
                if((a[i] - a[i + 1])*(-1) > diff ){
                    diff = (a[i] - a[i + 1])*(-1);
                    firstValue = a[i];
                    secondValue = a[i + 1];
                }
            } else if(a[i] - a[i+1] > diff){
                diff = a[i] + a[i + 1];
                firstValue = a[i];
                secondValue = a[i + 1];
            }
        }
        return new Pair(firstValue, secondValue);
    }

    public static void main(String[] args) {
        double[] arr1 = {-10.1, -10, -5, -4, 1, 2, 5.5, 7.7};
        double[] arr2 = {-10.1, -10, -5, -4, 1, 2, 5.5, 7.7, 7.75};
        double[] arr3 = {-10.1, -10, -5, -4, 1, 2, 5.5, 5.501, 7.7, 7.75};
        System.out.println(findClosestPair(arr1));
        System.out.println(findClosestPair(arr2));
        System.out.println(findClosestPair(arr3));

        double[] arr4 = {-100.01, -50, 1, 2, 3, 5, 6};
        System.out.println(findFarthestPair(arr4));
    }

    private static class Pair{
        public double firstValue;
        public double secondValue;

        public Pair(double firstValue, double secondValue) {
            this.firstValue = firstValue;
            this.secondValue = secondValue;
        }

        @Override
        public String toString() {
            return firstValue + " " + secondValue;
        }
    }
}
