package three;

// Implement the delete() method for BinarySearchST.

public class Exercise_3_1_16 {

    public static void main(String[] args) {
        BinarySearchST<String, Integer> binarySearchST = new BinarySearchST<>(10);
        fillBinarySearchST(binarySearchST);
        printKeysValues(binarySearchST);
        binarySearchST.delete("5");
        printKeysValues(binarySearchST);
    }

    private static void printKeysValues(BinarySearchST<String, Integer> binarySearchST) {
        Comparable[] keys = binarySearchST.getKeys();
        for (int i = 0; i < keys.length; i++) {
            System.out.print(keys[i] + ", ");
        }
        System.out.println();
    }

    public static void fillBinarySearchST(BinarySearchST<String, Integer> binarySearchST) {
        for (int i = 0; i < 9; i++) {
            binarySearchST.put(Integer.toString(i + 1), i + 1);
        }
    }

}
