package codility.time_complexity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PermMissingElemTest {
    private PermMissingElem permMissingElem;

    @BeforeEach
    public void setUp() {
        permMissingElem = new PermMissingElem();
    }

    @Test
    public void solution() {
        int[] A = {2, 3, 1, 5};
        assertEquals(4, permMissingElem.solution(A));
    }

    @Test
    public void solution2() {
        int[] A = {2, 3, 1, 5, 8, 7, 9, 4, 10};
        assertEquals(6, permMissingElem.solution(A));
    }
}