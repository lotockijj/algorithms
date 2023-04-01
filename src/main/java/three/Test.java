package three;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

public class Test {

    public static void main(String[] args) {
        String str = "S E A R C H E X A M P L E";
        String[] arr = str.split(" ");
        ST<String, Integer> st;
        st = new ST<>();
        for (int i = 0; i < arr.length; i++) {
            String key = arr[i];
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.print(s + " " + st.get(s) + "    ");
    }
}
