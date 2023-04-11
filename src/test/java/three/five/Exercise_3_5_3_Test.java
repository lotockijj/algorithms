package three.five;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.jena.reasoner.rulesys.builtins.LE;
import org.junit.Before;
import org.junit.Test;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class Exercise_3_5_3_Test {
    private BinarySearchSET binarySearchSET;
    private static final int CAPACITY = 32;
    private static final int LEN = 10;

    @Before
    public void setUp() {
        binarySearchSET = fillBinarySearchSet();
    }

    @Test
    public void checkSize(){
        assertEquals(LEN, binarySearchSET.size());
    }

    @Test
    public void checkGet(){
        assertEquals(5, binarySearchSET.get(5));
    }

    @Test
    public void checkRank(){
        assertEquals(4, binarySearchSET.rank(5));
    }

    @Test
    public void checkPut(){
        binarySearchSET.put(LEN);
        assertEquals(LEN, binarySearchSET.get(LEN));
        assertEquals(LEN - NumberUtils.INTEGER_ONE, binarySearchSET.rank(LEN));
        assertEquals(LEN + NumberUtils.INTEGER_ONE, binarySearchSET.size());
    }

    @Test
    public void checkDelete(){
        binarySearchSET.delete(LEN);
        assertNull( binarySearchSET.get(LEN));
        assertEquals(LEN - NumberUtils.INTEGER_ONE, binarySearchSET.size());
    }

    @Test
    public void checkGetKeys(){
        List<Integer> keys = Arrays.asList(binarySearchSET.getKeys())
                .stream()
                .map(Integer.class::cast)
                .collect(Collectors.toList());
        assertEquals(CAPACITY, keys.size());
        assertEquals(NumberUtils.INTEGER_ONE, keys.get(NumberUtils.INTEGER_ZERO));
    }

    @Test
    public void checkFloor(){
        assertEquals(NumberUtils.INTEGER_ONE, binarySearchSET.floor(NumberUtils.INTEGER_ZERO));
    }

    @Test
    public void checkIsEmpty(){
        assertFalse(binarySearchSET.isEmpty());
        for (int i = 0; i < LEN; i++) {
            binarySearchSET.delete(i + 1);
        }
        assertTrue(binarySearchSET.isEmpty());
    }

    private BinarySearchSET fillBinarySearchSet(){
        BinarySearchSET binarySearchSET = new BinarySearchSET(CAPACITY);
        for (int i = 0; i < LEN; i++) {
            binarySearchSET.put(i + 1);
        }
        return binarySearchSET;
    }
}