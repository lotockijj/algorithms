package three;

//Implement size(), delete(), and keys() for SequentialSearchST.

import java.util.List;

public class Exercise_3_1_5 {
    public static void main(String[] args) {
        SequentialSearchST<String, String> sequentialSearchST = new SequentialSearchST<>();
        fillSequentialSearchSt(sequentialSearchST);
        System.out.println("size() -> " + sequentialSearchST.size());
        List<String> keys = sequentialSearchST.keys();
        System.out.println();
        keys.forEach(e -> System.out.print(e + ", "));
        sequentialSearchST.delete("3");
        System.out.println();
        System.out.println("size() after deletion -> " + sequentialSearchST.size());

    }

    private static void fillSequentialSearchSt(SequentialSearchST<String, String> sequentialSearchST) {
        sequentialSearchST.put("1", "one");
        sequentialSearchST.put("2", "two");
        sequentialSearchST.put("3", "three");
        sequentialSearchST.put("4", "four");
        sequentialSearchST.put("5", "five");
    }
}
