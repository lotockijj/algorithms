package three.five;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise_3_5_26_Test {
    private Exercise_3_5_26<String> exercise_3_5_26;
    private final static String TEST_STRING = "any whatever try don't ever give up";

    @Before
    public void setUp() {
        exercise_3_5_26 = new Exercise_3_5_26<>();
        fillData();
    }

    private void fillData() {
        String[] testData = TEST_STRING.split(" ");
        for (int i = 0; i < testData.length; i++) {
            exercise_3_5_26.access(testData[i]);
        }
    }

    @Test
    public void accessLastInserted() {
        exercise_3_5_26.access("each");
        assertEquals("each", exercise_3_5_26.remove());
    }

    @Test
    public void accessLastAccessed(){
        exercise_3_5_26.access("try");
        assertEquals("try", exercise_3_5_26.remove());
    }

    @Test
    public void remove() {
       assertEquals("up", exercise_3_5_26.remove());
    }
}