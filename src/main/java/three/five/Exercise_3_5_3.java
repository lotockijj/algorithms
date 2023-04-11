package three.five;

/*
Develop a SET implementation BinarySearchSET by starting with the code for
BinarySearchST and eliminating all of the code involving values.
 */

public class Exercise_3_5_3 {

    public static void main(String[] args) {
        BinarySearchSET binarySearchSET = new BinarySearchSET(32);
        for (int i = 0; i < 10; i++) {
            binarySearchSET.put(i + 1);
        }
        System.out.println("Get 5: " + binarySearchSET.get(5));
        binarySearchSET.delete(5);
        System.out.println("Contains 5 after 5 was deleted: " + binarySearchSET.get(5));
    }
}
