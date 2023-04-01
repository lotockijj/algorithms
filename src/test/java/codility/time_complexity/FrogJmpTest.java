package codility.time_complexity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FrogJmpTest {
    private FrogJmp frogJmp;

    @BeforeEach
    public void setUp() {
        frogJmp = new FrogJmp();
    }

    @Test
    public void solution() {
        int result = frogJmp.solution(10, 85, 30);
        assertEquals(3, result);
    } //

    @Test
    public void solution2() {
        int result = frogJmp.solution(3, 999111321, 7);
        assertEquals(142730189, result);
    }
}