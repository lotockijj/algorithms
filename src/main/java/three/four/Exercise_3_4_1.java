package three.four;

/*
1 Insert the keys E A S Y Q U T I O N in that order into an initially empty table
of M = 5 lists, using separate chaining. Use the hash function 11 k % M to transform
the kth letter of the alphabet into a table index.
 */

import three.SequentialSearchST;

public class Exercise_3_4_1 {

    public static void main(String[] args) {
        SeparateChainingHashST<String, Integer> separateChainingHashST = new SeparateChainingHashST(5);
        String[] keysAsString = "E A S Y Q U T I O N".split(" ");
        for (int i = 0; i < keysAsString.length; i++) {
            if(separateChainingHashST.get(keysAsString[i]) == null){
                separateChainingHashST.put(keysAsString[i], 1);
            } else {
                separateChainingHashST.put(keysAsString[i], separateChainingHashST.get(keysAsString[i]) + 1);
            }
        }
    }
}
