package three.five;

/*
UniQueue. Create a data type that is a queue, except that an element may only be inserted the queue once.
Use an existence symbol table to keep track of all elements that have ever been inserted and ignore requests to re-insert such items.
 */

public class Exercise_3_5_28 {

    public static void main(String[] args) {
        Queue_3_5_28<Integer> queue_3_5_28 = new Queue_3_5_28<>();
        System.out.println("Added 1 first time: " + queue_3_5_28.add(1) +
                "  Added 1 second time: " + queue_3_5_28.add(1));
    }
}
