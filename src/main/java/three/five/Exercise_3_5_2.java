package three.five;

/*
Develop a SET implementation SequentialSearchSET by starting with the code for SequentialSearchST and
eliminating all of the code involving values.
 */

public class Exercise_3_5_2 {

    public static void main(String[] args) {
        SequentialSearchSET sequentialSearchSET = new SequentialSearchSET();
        for (int i = 0; i < 10; i++) {
            sequentialSearchSET.put(i + 1);
        }
        System.out.println("Contains 5: " + sequentialSearchSET.contains(5));
        System.out.println("Get 5: " + sequentialSearchSET.get(5));
        System.out.println("Delete 5: " + sequentialSearchSET.delete(5));
        System.out.println("Contains 5 after 5 was deleted: " + sequentialSearchSET.contains(5));
    }
}
