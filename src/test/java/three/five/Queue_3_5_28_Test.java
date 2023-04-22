package three.five;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Queue_3_5_28_Test {
    private Queue_3_5_28<Integer> queue_3_5_28;

    @Before
    public void setUp() {
        queue_3_5_28 = new Queue_3_5_28<>();
    }

    @Test
    public void add() {
        assertTrue(queue_3_5_28.add(NumberUtils.INTEGER_ONE));
        assertFalse(queue_3_5_28.add(NumberUtils.INTEGER_ONE));
    }
}