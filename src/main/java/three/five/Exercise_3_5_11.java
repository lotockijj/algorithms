package three.five;

// Develop a MultiSET class that is like SET, but allows equal keys and thus implements a mathematical multiset.

public class Exercise_3_5_11 {

    public static void main(String[] args) {
        MultiSET<Integer> multiSET = new MultiSET<>();
        for (int i = 0; i < 10; i++) {
            multiSET.put(i);
        }
        multiSET.put(1);
        multiSET.put(1);
        multiSET.put(1);
        multiSET.keys().forEach(e -> System.out.print(e + ", "));
    }
}
