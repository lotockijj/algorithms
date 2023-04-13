package three.five;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class Exercise_3_5_17Test {
    private MathSET<String> mathSET;
    private final static String[] UNIVERSE_SET = {"A", "B", "C", "D", "E",  "F", "G", "H", "I", "J"};

    @Before
    public void setUp() {
        mathSET = new MathSET<>(UNIVERSE_SET);
    }

    @Test
    public void createSet(){
        assertNotNull(mathSET);
        assertFalse(mathSET.isEmpty());
        assertEquals(10, mathSET.size());
    }

    @Test
    public void addKey(){
        mathSET.add("K");
        assertTrue(mathSET.contains("K"));
    }

    @Test
    public void complement(){
        Set<String> set = Set.of("L", "M", "N");
        MathSET<String> complementMathSet = mathSET.complement(set);
        assertTrue(complementMathSet.contains("L") && complementMathSet.contains("M") && complementMathSet.contains("N"));
    }

    @Test
    public void union(){
        Set<String> set = Set.of("L", "M", "N");
        MathSET<String> complementMathSet = mathSET.complement(set);
        mathSET.union(complementMathSet);
        assertTrue(mathSET.contains("L") && mathSET.contains("M") && mathSET.contains("N"));
    }

    @Test
    public void intersection(){
        MathSET<String> intersectionMathSet = new MathSET<>(
                new String[]{"A", "B", "C", "D", "E",  "F", "G"});
        mathSET.intersection(intersectionMathSet);
        assertFalse(mathSET.contains("H") || mathSET.contains("I") || mathSET.contains("J"));
    }
}