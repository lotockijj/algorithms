package three.four;

/*
Modify your implementation of the previous exercise to include an integer field
for each key-value pair that is set to the number of entries in the table at the time that
pair is inserted. Then implement a method that deletes all keys (and associated values)
for which the field is greater than a given integer k. Note : This extra functionality is useful
in implementing the symbol table for a compiler.
 */

public class Exercise_3_4_3 {

    public static void main(String[] args) {
        SeparateChainingLinkedListST<String, Integer> separateChainingLinkedListST = new SeparateChainingLinkedListST();
        String[] keysAsString = "E A S Y Q U T I O N TEST E A S Y Q U T I O N".split(" ");

        for (int i = 0; i < keysAsString.length; i++) {
            if(separateChainingLinkedListST.get(keysAsString[i]) == null){
                separateChainingLinkedListST.put(keysAsString[i], 1);
            } else {
                separateChainingLinkedListST.put(keysAsString[i], separateChainingLinkedListST.get(keysAsString[i]) + 1);
            }
        }
        //separateChainingLinkedListST.removeIfTheAraMoreDuplicates(2);

    }
}
