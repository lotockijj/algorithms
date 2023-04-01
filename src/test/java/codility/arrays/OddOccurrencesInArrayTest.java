package codility.arrays;


import codility.arrays.OddOccurrencesInArray;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnit4.class)
public class OddOccurrencesInArrayTest {
    private OddOccurrencesInArray oddOccurrencesInArray;

    @Before
    public void setUp() {
        oddOccurrencesInArray = new OddOccurrencesInArray();
    }

    @Test
    public void solution() {
        int[] A = {9, 3, 9, 7, 3, 9};
        int solution = oddOccurrencesInArray.solution(A);
        assertEquals(7, solution);
    }

    @Test
    public void solution2() {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 6, 5, 4, 3, 2, 1, 9, 7};
        int solution = oddOccurrencesInArray.solution(A);
        assertEquals(9, solution);
    }
}