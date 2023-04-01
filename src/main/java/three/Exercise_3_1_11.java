package three;

/*   Give a trace of the process of inserting the keys E A S Y Q U E S T I O N into
     an initially empty table using BinarySearchST. How many compares are involved? */

public class Exercise_3_1_11 {

    public static void main(String[] args) {
        BinarySearchST<String, Integer> binarySearchST = new BinarySearchST<>(12);
        String[] strings = "E A S Y Q U E S T I O N".split(" ");
        fillBinarySearchST(binarySearchST, strings);
        System.out.println("Count of compares: " + BinarySearchST.countOfCompares);
    }

    private static void fillBinarySearchST(BinarySearchST<String, Integer> binarySearchST, String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            binarySearchST.put(strings[i], i + 1);
            Comparable[] objects = binarySearchST.getKeys();
            printKeys(objects);
        }
    }

    private static void printKeys(Comparable[] keys) {
        for (int i = 0; i < keys.length; i++) {
            if(keys[i] != null) {
                System.out.print(keys[i] + ", ");
            }
        }
        System.out.println();
    }
}
