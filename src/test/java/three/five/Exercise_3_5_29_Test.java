package three.five;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Exercise_3_5_29_Test {
    private Exercise_3_5_29<String, String> exercise_3_5_29;
    private final static int LEN = 10;

    @Before
    public void setUp() {
        exercise_3_5_29 = fillDataIntoExercise_3_5_29();
    }

    private Exercise_3_5_29<String, String> fillDataIntoExercise_3_5_29() {
        Exercise_3_5_29<String, String> exercise_3_5_29 = new Exercise_3_5_29<>();
        for (int i = 0; i < LEN; i++) {
            String str = i + 1 + "";
            exercise_3_5_29.insert(str, str);
        }
        return exercise_3_5_29;
    }

    @Test
    public void insert() {
        exercise_3_5_29.insert("11", "11");

        assertEquals("11", exercise_3_5_29.getValueForKey("11"));
    }

    @Test
    public void getValueForKey() {
        assertEquals("1", exercise_3_5_29.getValueForKey("1"));
        assertEquals("5", exercise_3_5_29.getValueForKey("5"));
        assertEquals("10", exercise_3_5_29.getValueForKey("10"));
    }

    @Test
    public void getRandomKey() {
        assertNotNull(exercise_3_5_29.getRandomKey());
    }

    @Test
    public void deleteRandomKey() {
        String deleteRandomKey = exercise_3_5_29.deleteRandomKey();
        assertNotNull(deleteRandomKey);
    }
}