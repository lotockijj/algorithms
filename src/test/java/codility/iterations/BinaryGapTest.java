package codility.iterations;

import codility.iterations.BinaryGap;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnit4.class)
public class BinaryGapTest {
    private BinaryGap binaryGap;

    @Before
    public void initialize(){
        binaryGap = new BinaryGap();
    }

    @Test
    public void solution() {
        assertEquals(2, binaryGap.solution(9));
        assertEquals(1, binaryGap.solution(20));
        assertEquals(4, binaryGap.solution(529));
        assertEquals(0, binaryGap.solution(15));
        assertEquals(3, binaryGap.solution(561892));
        assertEquals(4, binaryGap.solution(74901729));
        assertEquals(5, binaryGap.solution(1376796946));
    }

}