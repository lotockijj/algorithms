package three.five;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class Exercise_3_5_8Test {
    private LinearProbingHashST_3_5_8 probingHashST_3_5_8;
    private final static int LEN = 10;

    @Before
    public void setUp() {
        probingHashST_3_5_8 = fillLinearProbingHashST_3_5_8_with_Integers();
    }

    @Test
    public void checkPutIntegerValues(){
        assertEquals(LEN, probingHashST_3_5_8.getKeys().size());
        assertEquals(LEN, probingHashST_3_5_8.getVals().size());
    }

    @Test
    public void checkPutTheSameIntegersValue(){
        probingHashST_3_5_8.put(1, 11);
        assertEquals(LEN, probingHashST_3_5_8.getKeys().size());
        assertEquals(LEN + NumberUtils.INTEGER_ONE, probingHashST_3_5_8.getVals().size());
    }

    @Test
    public void checkPutDoubleValues(){
        probingHashST_3_5_8 = fillLinearProbingHashST_3_5_8_with_Double();
        assertEquals(LEN, probingHashST_3_5_8.getKeys().size());
        assertEquals(LEN, probingHashST_3_5_8.getVals().size());
    }

    @Test
    public void checkPutTheSameDoubleValue(){
        probingHashST_3_5_8 = fillLinearProbingHashST_3_5_8_with_Double();
        probingHashST_3_5_8.put(1.0, 11.0);
        assertEquals(LEN, probingHashST_3_5_8.getKeys().size());
        assertEquals(LEN + NumberUtils.INTEGER_ONE, probingHashST_3_5_8.getVals().size());
    }

    @Test
    public void checkDeleteTheSameDoubleValue(){
        probingHashST_3_5_8 = fillLinearProbingHashST_3_5_8_with_Double();
        probingHashST_3_5_8.put(1.0, 100.0);
        probingHashST_3_5_8.put(1.0, 100.0);
        assertEquals(LEN + 2, probingHashST_3_5_8.getVals().size());
        probingHashST_3_5_8.delete(1.0);
        assertEquals(LEN - NumberUtils.INTEGER_ONE, probingHashST_3_5_8.getKeys().size());
        assertEquals(LEN - NumberUtils.INTEGER_ONE, probingHashST_3_5_8.getVals().size());
    }

    private LinearProbingHashST_3_5_8 fillLinearProbingHashST_3_5_8_with_Integers() {
        LinearProbingHashST_3_5_8 linearProbingHashST_3_5_8 = new LinearProbingHashST_3_5_8();
        for (int i = 0; i < LEN; i++) {
            linearProbingHashST_3_5_8.put(i, i);
        }
        return linearProbingHashST_3_5_8;
    }

    private LinearProbingHashST_3_5_8 fillLinearProbingHashST_3_5_8_with_Double() {
        LinearProbingHashST_3_5_8 linearProbingHashST_3_5_8 = new LinearProbingHashST_3_5_8();
        for (int i = 0; i < LEN; i++) {
            linearProbingHashST_3_5_8.put(i + 1.0, i + 1.0);
        }
        return linearProbingHashST_3_5_8;
    }
}