package three.five;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MultiSET_Test {
    private MultiSET<String> multiSET;
    private final static int LEN = 10;

    @Before
    public void setUp(){
        multiSET = new MultiSET<>();
        for (int i = 0; i < LEN; i++) {
            multiSET.put(i + 1 + "");
        }
    }

    @Test
    public void get() {
        assertEquals("5", multiSET.get("5"));
    }

    @Test
    public void put() {
        multiSET.put("11");
        assertTrue(multiSET.contains("11"));
    }

    @Test
    public void size() {
        assertEquals(LEN, multiSET.size());
    }

    @Test
    public void keys() {
        List<String> keys = multiSET.keys();
        assertEquals(LEN, keys.size());
    }

    @Test
    public void delete() {
        multiSET.delete("5");
        assertFalse(multiSET.contains("5"));
    }

    @Test
    public void contains() {
        assertTrue(multiSET.contains("3"));
    }

    @Test
    public void getFirstKey() {
        assertEquals("10", multiSET.getFirstKey());
    }

    @Test
    public void universe(){
        String[] numbers = {"2", "3", "4"};
        MultiSET<String> universeMultiSet = multiSET.universe(numbers);
        assertEquals(3, universeMultiSet.size());
        assertTrue(universeMultiSet.contains("2")
                && universeMultiSet.contains("3") && universeMultiSet.contains("4"));
    }

    @Test
    public void complement(){
        String[] numbers = {"12", "3", "4"};
        MultiSET<String> complementMultiSet = multiSET.complement(numbers);
        assertEquals(NumberUtils.INTEGER_ONE, complementMultiSet.size());
        assertTrue(complementMultiSet.contains("12"));
        assertFalse(complementMultiSet.contains("3") && complementMultiSet.contains("4"));
    }

    @Test
    public void union(){
        String[] numbers = {"12", "3", "4"};
        MultiSET<String> complementMultiSet = multiSET.complement(numbers);
        multiSET.union(complementMultiSet);
        assertEquals(LEN + NumberUtils.INTEGER_ONE, multiSET.size());
        assertTrue(multiSET.contains("12"));
    }

    @Test
    public void intersection(){
        String[] numbers = {"11", "12", "4"};
        MultiSET<String> intersectionMultiSet = multiSET.universe(numbers);
        multiSET.intersection(intersectionMultiSet);
        assertEquals(NumberUtils.INTEGER_ONE, multiSET.size());
        assertTrue(multiSET.contains("4"));
    }

    @Test
    public void isEmpty(){
        assertFalse(multiSET.isEmpty());
        for (int i = 0; i < LEN; i++) {
            multiSET.delete(i + 1 + "");
        }
        assertTrue(multiSET.isEmpty());
    }
}