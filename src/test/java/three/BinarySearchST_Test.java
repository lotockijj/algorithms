package three;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchST_Test {
    private BinarySearchST<Integer, Integer> binarySearchST;
    private final static String RANGE_AS_STRING = "1-2, 3-8, 18-22, 25-27, 29-144, 500-600, 1000-2000";

    @Before
    public void setUp() {
        binarySearchST = new BinarySearchST(256);
        List<String> rangeAsList = Arrays.stream(RANGE_AS_STRING.split(","))
                .map(String::trim).collect(Collectors.toList());
        for (int i = 0; i < rangeAsList.size(); i++) {
            String[] splitKeyValue = rangeAsList.get(i).split("-");
            binarySearchST.put(Integer.parseInt(splitKeyValue[0]), Integer.parseInt(splitKeyValue[1]));
        }
    }

    @Test
    public void getIntervalIndex() {
        assertEquals(2, binarySearchST.getIntervalIndex(5));
        assertEquals(7, binarySearchST.getIntervalIndex(1500));
        assertEquals(NumberUtils.INTEGER_MINUS_ONE, binarySearchST.getIntervalIndex(28));
        assertEquals(NumberUtils.INTEGER_MINUS_ONE, binarySearchST.getIntervalIndex(400));
    }
}