package three;

/* Give a trace of the process of inserting the keys E A S Y Q U E S T I O N into an
   initially empty table using SequentialSearchST. How many compares are involved ? */

import java.util.List;

public class Exercise_3_1_10 {

    public static void main(String[] args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<>();
        String[] strings = "E A S Y Q U E S T I O N".split(" ");
        fillSequentialSearchST(st, strings);
        System.out.println("Count of compares: " + SequentialSearchST.countOfCompares);
    }

    private static void fillSequentialSearchST(SequentialSearchST<String, Integer> st, String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            st.put(strings[i], i + 1);
            List<String> keys = st.keys();
            printKeys(keys);
        }
    }

    private static void printKeys(List<String> keys) {
        for (int i = 0; i < keys.size(); i++) {
            System.out.print(keys.get(i) + ", ");
        }
        System.out.println();
    }
}
