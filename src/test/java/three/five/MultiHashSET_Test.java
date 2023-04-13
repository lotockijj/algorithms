package three.five;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MultiHashSET_Test {
    private MultiHashSET<String, Integer> multiHashSET;
    private final static int LEN = 10;

    @Before
    public void setUp(){
        multiHashSET = new MultiHashSET<>();
        for (int i = 0; i < LEN; i++) {
            multiHashSET.put(i + 1 + "", i + 1);
        }
    }

    @Test
    public void put() {
        multiHashSET.put("11", 11);
        assertTrue(multiHashSET.contains("11"));
    }

    @Test
    public void get() {
        multiHashSET.put("12", 12);
        assertEquals(12, multiHashSET.get("12"));
    }

    @Test
    public void delete() {
        multiHashSET.delete("2");
        assertFalse(multiHashSET.contains("2"));
    }

    @Test
    public void contains() {
        assertTrue(multiHashSET.contains("3"));
    }

    @Test
    public void multiHashSET() {
        String[] strings = {"111", "222", "333"};
        Integer[] integers = {444, 555, 666};
        MultiHashSET<String, Integer> multiHashSET_universe = multiHashSET.createMultiHashSET(strings, integers);
        assertTrue(multiHashSET_universe.contains("111")
                && multiHashSET_universe.contains("222")
                && multiHashSET_universe.contains("333"));
    }

    @Test
    public void getKeys() {
        assertEquals(LEN, multiHashSET.getKeys().size());
    }

    @Test
    public void getVals() {
        assertEquals(LEN, multiHashSET.getVals().size());
    }

    @Test
    public void complement(){
        String[] strings = {"1", "2", "777", "888"};
        Integer[] integers = {1, 2, 999, 1111};
        multiHashSET.complement(strings, integers);
        assertTrue(multiHashSET.contains("777") && multiHashSET.contains("888"));
        assertEquals(LEN + 2, multiHashSET.getKeys().size());
    }

    @Test
    public void union(){
        MultiHashSET<String, Integer> unionMultiHashSet = new MultiHashSET<>();
        for (int i = 20; i <= 30; i = i + 5) {
            unionMultiHashSet.put(i + "", i);
        }
        multiHashSET.union(unionMultiHashSet);
        assertTrue(multiHashSET.contains("20")
                && multiHashSET.contains("25")
                && multiHashSET.contains("30"));
        assertEquals(LEN + 3, multiHashSET.getKeys().size());
    }

    @Test
    public void intersection(){
        MultiHashSET<String, Integer> intersectionMultiHashSET = new MultiHashSET<>();
        for (int i = 5; i <= 7; i++) {
            intersectionMultiHashSET.put(i + "", i);
        }
        intersectionMultiHashSET.put("2222", 2222);
        multiHashSET.intersection(intersectionMultiHashSET);
        assertTrue(!multiHashSET.contains("5")
                && !multiHashSET.contains("6")
                && !multiHashSET.contains("7"));
        assertEquals(LEN - 3, multiHashSET.size());
    }

    @Test
    public void size(){
        assertEquals(LEN, multiHashSET.size());
    }

    @Test
    public void isEmpty(){
        assertFalse(multiHashSET.isEmpty());
        for (int i = 0; i < LEN; i++) {
            multiHashSET.delete(i + 1 + "");
        }
        assertTrue(multiHashSET.isEmpty());
    }
}