package three.five;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class Exercise_3_5_11Test {
    private MultiSET multiSET;
    private final static int LEN = 10;

    @Before
    public void setUp() {
        multiSET = fillMultiSet(10);
    }

    private MultiSET fillMultiSet(int i) {
        MultiSET<Integer> multiSET = new MultiSET<>();
        for (int j = 0; j < LEN; j++) {
            multiSET.put(i);
        }
        return multiSET;
    }

    @Test
    public void checkIfDuplicatesArePresent(){
        multiSET.put(1);
        assertEquals(LEN + NumberUtils.INTEGER_ONE, multiSET.size());
    }
}