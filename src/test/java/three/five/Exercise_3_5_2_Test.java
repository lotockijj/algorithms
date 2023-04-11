package three.five;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Exercise_3_5_2_Test {
    private SequentialSearchSET sequentialSearchSET;

    @BeforeEach
    public void setUp() {
        sequentialSearchSET = fillSequentialSearchSET();
    }

    @Test
    public void containsKey(){
        assertTrue(sequentialSearchSET.contains(5));
        assertFalse(sequentialSearchSET.contains(45));
    }

    @Test
    public void getKey(){
        assertEquals(5, sequentialSearchSET.get(5));
    }

    @Test
    public void deleteKey(){
        assertTrue(sequentialSearchSET.delete(5));
        assertFalse(sequentialSearchSET.contains(5));
    }

    private SequentialSearchSET fillSequentialSearchSET(){
        SequentialSearchSET sequentialSearchSET = new SequentialSearchSET();
        for (int i = 0; i < 10; i++) {
            sequentialSearchSET.put(i + 1);
        }
        return sequentialSearchSET;
    }
}