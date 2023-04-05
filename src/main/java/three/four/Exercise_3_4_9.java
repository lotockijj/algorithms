package three.four;

//Implement an eager delete() method for SeparateChainingHashST.

public class Exercise_3_4_9 {

    public static void main(String[] args) {
        SeparateChainingHashST<String, Integer> separateChainingHashST = new SeparateChainingHashST<>();
        fillSeparateChainingHashST(separateChainingHashST);
        separateChainingHashST.delete("S");
    }

    public static void fillSeparateChainingHashST(SeparateChainingHashST<String, Integer> separateChainingHashST) {
        String[] strings = "S E A R C H X M P L".split(" ");
        for (int i = 0; i < strings.length; i++) {
            separateChainingHashST.put(strings[i], i);
        }
    }
}
