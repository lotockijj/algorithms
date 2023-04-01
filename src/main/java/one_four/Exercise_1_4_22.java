package one_four;/*Binary search with only addition and subtraction. [Mihai Patrascu] Write a
program that, given an array of N distinct int values in ascending order, determines
whether a given integer is in the array. You may use only additions and subtractions
and a constant amount of extra memory. The running time of your program should be
proportional to log N in the worst case.
Answer : Instead of searching based on powers of two (binary search), use Fibonacci
numbers (which also grow exponentially). Maintain the current search range to be the
interval [i, i + F k] and keep F k and F k–1 in two variables. At each step compute Fk–2 via
subtraction, check element i + Fk–2 , and update the current range to either [i, i + Fk–2]
or [i + Fk–2, i + Fk–2 + Fk–1].*/

public class Exercise_1_4_22 {

    private static int find(int[] a, int t){
        int left = 0;
        int right = a.length - 1;
        int fib = 1;
        boolean outOfBound = false;
        while(left <= right){
            if(fib > a.length - 1) {
                outOfBound = true;
                break;
            }
            if(a[fib] < t){
                left = fib;
                fib = fib == 1 ? fibonacci(3) : fibonacci(fib + 2);
            } else if(a[fib] > t){
                right = fib;
                break;
            }
        }
        if(outOfBound){
            int previousFibonacci = previousFibonacci(fib - 1);
            for(int i = previousFibonacci; i < a.length; i++){
                if(a[i] == t) {
                    return 1;
                }
            }
        } else {
            int top = right > a.length - 1 ? a.length - 1 : right;
            for (int i = left; i < top; i++) {
                if (a[i] == t) {
                    return 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = { -1, 1, 2, 3, 4, 5, 6, 1000};
        System.out.println(find(a, 4));
        System.out.println(find(a, 1000));
        System.out.println(find(a, -1000));
    }

    private static int fibonacci(int n){
        if(n <= 1){
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static int previousFibonacci(int n)
    {
        double a = n / ((1 + Math.sqrt(5)) / 2.0);
        return (int)Math.round(a);
    }
}
