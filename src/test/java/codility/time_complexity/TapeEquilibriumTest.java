package codility.time_complexity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TapeEquilibriumTest {
    private TapeEquilibrium tapeEquilibrium;

    @BeforeEach
    public void setUp() {
        tapeEquilibrium = new TapeEquilibrium();
    }

    @Test
    public void solution() {
        int[] A = {3, 1, 2, 4, 3};
        assertEquals(1, tapeEquilibrium.solution(A));
    }

    @Test
    public void solution2() {
        int[] A = {3, 1, 2, 10, 4, 6, 3};
        assertEquals(3, tapeEquilibrium.solution(A));
    }

    @Test
    public void solution3() {
        int[] A = {-3, 1, 2, 10, 4, 6, -3};
        assertEquals(3, tapeEquilibrium.solution(A));
    }

    @Test
    public void solution4() {
        int[] A = {-3, -1, -2, 10, 4, 6, -3};
        assertEquals(3, tapeEquilibrium.solution(A));
    }

    @Test
    public void solution5() {
        int[] A = {-3, -1, -2, -10, 4, 6, -3};
        assertEquals(3, tapeEquilibrium.solution(A));
    }
}