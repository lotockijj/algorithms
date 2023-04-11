package three.five;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise_3_5_5Test {
    private STint sTint;
    private STdouble stDouble;
    private static final int LEN = 10;

    @Before
    public void setUp() {
        sTint = fillSTint();
        stDouble = fillSTdouble();
    }

    @Test
    public void checkSize(){
        assertEquals(LEN, sTint.size());
        assertEquals(LEN, stDouble.size());
    }

    @Test
    public void checkPut(){
        sTint.put(LEN + NumberUtils.INTEGER_ONE);
        assertEquals(LEN + NumberUtils.INTEGER_ONE, sTint.size());
        stDouble.put(LEN + NumberUtils.DOUBLE_ONE);
        assertEquals(LEN + NumberUtils.DOUBLE_ONE, stDouble.size());
    }

    private STint fillSTint() {
        STint sTint = new STint();
        for (int i = 0; i < LEN; i++) {
            sTint.put(i + 1);
        }
        return sTint;
    }

    private STdouble fillSTdouble() {
        STdouble sTdouble = new STdouble();
        for (int i = 0; i < LEN; i++) {
            sTdouble.put(i + 1);
        }
        return sTdouble;
    }
}