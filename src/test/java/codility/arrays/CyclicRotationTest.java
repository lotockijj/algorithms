package codility.arrays;

import codility.arrays.CyclicRotation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class CyclicRotationTest {
    private CyclicRotation cyclicRotation;

    @Before
    public void setUp(){
        cyclicRotation = new CyclicRotation();
    }

    @Test
    public void solution() {
        int[] A = {3, 8, 9, 7, 6}; //9, 7, 6, 3, 8
        int[] result = cyclicRotation.solution(A, 3);
        assertEquals(3, result[3]);
        assertEquals(9, result[0]);
        assertEquals(7, result[1]);
        assertEquals(6, result[2]);
    }

    @Test
    public void solution2() {
        int[] A = {0, 0, 0}; // 0, 0, 0
        int[] result = cyclicRotation.solution(A, 1);
        assertEquals(0, result[0]);
        assertEquals(0, result[1]);
        assertEquals(0, result[2]);
    }

    @Test
    public void solution3() {
        int[] A = {1, 2, 3, 4}; // 0, 0, 0
        int[] result = cyclicRotation.solution(A, 4);
        int[] expectedArray = {1, 2, 3, 4};
        assertArrayEquals(expectedArray, result);
    }
}