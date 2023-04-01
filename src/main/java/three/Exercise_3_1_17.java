package three;

/* Implement the floor() method for BinarySearchST.
                       09:01:10 Houston
    floor(09:05:00) -> 09:03:13 Chicago
                       09:10:11 Seattle

 */

public class Exercise_3_1_17 {

    public static void main(String[] args) {
        BinarySearchST<String, Integer> binarySearchST = new BinarySearchST<>(10);
        fillBinarySearchST(binarySearchST);
        System.out.println(binarySearchST.floor("8"));
        System.out.println(binarySearchST.floor("4"));
    }

    private static void fillBinarySearchST(BinarySearchST<String, Integer> binarySearchST) {
        for (int i = 0; i < 9; i++) {
            if(Integer.toString(i).equals("7")) continue;
            if(Integer.toString(i).equals("3")) continue;
            binarySearchST.put(Integer.toString(i + 1), i + 1);
        }
    }
}
