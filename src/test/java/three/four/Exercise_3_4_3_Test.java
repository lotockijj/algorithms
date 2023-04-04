package three.four;

import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

public class Exercise_3_4_3_Test {
    private SeparateChainingLinkedListST<String, Integer> separateChainingLinkedListST;

    @Before
    public void setUp() {
        separateChainingLinkedListST = new SeparateChainingLinkedListST();
    }

    @Test
    public void testRemoveIfTheAraMoreDuplicates(){
        String[] keysAsString = "E A S Y Q U T I O N TEST TEST2 E A S Y Q U T I O N".split(" ");
        for (int i = 0; i < keysAsString.length; i++) {
            if(separateChainingLinkedListST.get(keysAsString[i]) == null){
                separateChainingLinkedListST.put(keysAsString[i], 1);
            } else {
                separateChainingLinkedListST.put(keysAsString[i], separateChainingLinkedListST.get(keysAsString[i]) + 1);
            }
        }
        separateChainingLinkedListST.removeIfTheAraMoreDuplicates(2);
        Iterable<String> keys = separateChainingLinkedListST.keys();
        int expectedSize = 2;
        int actualSize = 0;
        Iterator<String> iterator = keys.iterator();
        while(iterator.hasNext()){
            actualSize++;
            iterator.next();
        }
        assertEquals(expectedSize, actualSize);
    }
}