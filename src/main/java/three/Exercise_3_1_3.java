package three;

/* Develop a symbol-table implementation OrderedSequentialSearchST that uses an ordered linked list
   as the underlying data structure to implement our ordered symbol-table API. */

import java.util.Random;

public class Exercise_3_1_3 {
    public static void main(String[] args) {
        OrderedSequentialSearchST orderedSequentialSearchST = new OrderedSequentialSearchST();
        Random random = new Random();
        //9, 1, 3 ...
        for (int i = 0; i < 10; i++) {
            //orderedSequentialSearchST.put(random.nextInt(10), random.nextInt(20));
        }
        orderedSequentialSearchST.put(9, 1);
        orderedSequentialSearchST.put(1, 1);
        orderedSequentialSearchST.put(3, 1);
        orderedSequentialSearchST.put(5, 1);
        System.out.println(orderedSequentialSearchST);
    }
}
