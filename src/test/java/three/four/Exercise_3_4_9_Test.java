package three.four;


import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exercise_3_4_9_Test {
    private SeparateChainingHashST<String, Integer> separateChainingHashST;

    @Before
    public void setUp() {
        separateChainingHashST = new SeparateChainingHashST<>();
        Exercise_3_4_9.fillSeparateChainingHashST(separateChainingHashST);
    }

    @Test
    public void checkIfValueIsDeleted(){
        separateChainingHashST.delete("S");
        assertEquals(NumberUtils.INTEGER_ZERO, separateChainingHashST.get("S"));
        assertNotNull(separateChainingHashST.get("E"));
    }
}