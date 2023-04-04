package three.four;

/*
Develop an alternate implementation of SeparateChainingHashST that directly
uses the linked-list code from SequentialSearchST.
 */

public class Exercise_3_4_2 {

    public static void main(String[] args) {
        SeparateChainingLinkedListST<String, Integer> separateChainingLinkedListST = new SeparateChainingLinkedListST();
        String[] keysAsString = "E A S Y Q U T I O N".split(" ");
        for (int i = 0; i < keysAsString.length; i++) {
            if(separateChainingLinkedListST.get(keysAsString[i]) == null){
                separateChainingLinkedListST.put(keysAsString[i], 1);
            } else {
                separateChainingLinkedListST.put(keysAsString[i], separateChainingLinkedListST.get(keysAsString[i]) + 1);
            }
        }
    }
}
