package three.five;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class List_3_5_27_Test {
    private List_3_5_27<Integer> list_3_5_27;

    @Before
    public void setUp() {
        list_3_5_27 = new List_3_5_27<>();
    }

    @Test
    public void addFront() {
        list_3_5_27.addFront(1);
        list_3_5_27.addFront(2);
        list_3_5_27.addFront(1);
        list_3_5_27.addFront(3);
        list_3_5_27.addFront(7);
        list_3_5_27.addFront(100);

        Object[] arr = list_3_5_27.getArr();
        int actualResult = (int) arr[0];
        assertEquals(100, actualResult);
        actualResult = (int) arr[2];
        assertEquals(3, actualResult);
        actualResult = (int) arr[5];
        assertEquals(NumberUtils.INTEGER_ONE, actualResult);
        assertEquals(6, list_3_5_27.getCount());
    }

    @Test
    public void addBack() {
        list_3_5_27.addFront(1);
        list_3_5_27.addFront(1);
        list_3_5_27.addBack(3);

        Object[] arr = list_3_5_27.getArr();
        int actualResult = (int) arr[2];

        assertEquals(3, actualResult);
        assertEquals(3, list_3_5_27.getCount());
    }

    @Test
    public void deleteFront() {
        list_3_5_27.addFront(1);
        list_3_5_27.addFront(1);
        list_3_5_27.addFront(3);

        Integer deletedItem = list_3_5_27.deleteFront();

        Object[] arr = list_3_5_27.getArr();
        int actualResult = (int) arr[0];

        assertEquals(3, deletedItem);
        assertEquals(NumberUtils.INTEGER_ONE, actualResult);
        assertEquals(2, list_3_5_27.getCount());
    }

    @Test
    public void deleteBack() {
        list_3_5_27.addFront(1);
        list_3_5_27.addFront(3);

        Integer deletedItem = list_3_5_27.deleteBack();

        assertEquals(NumberUtils.INTEGER_ONE, deletedItem);
        assertEquals(NumberUtils.INTEGER_ONE, list_3_5_27.getCount());
    }

    @Test
    public void deleteByItem() {
        list_3_5_27.addFront(1);
        list_3_5_27.addFront(2);
        list_3_5_27.addFront(3);
        list_3_5_27.addFront(4);
        list_3_5_27.addFront(5);

        list_3_5_27.deleteByItem(2);
        list_3_5_27.deleteByItem(4);
        Object[] arr = list_3_5_27.getArr();

        int actualResult = (int) arr[2];
        assertEquals(NumberUtils.INTEGER_ONE, actualResult);

        actualResult = (int) arr[0];
        assertEquals(5, actualResult);

    }

    @Test
    public void add() {
        list_3_5_27.addFront(1);
        list_3_5_27.addFront(2);
        list_3_5_27.addFront(4);
        list_3_5_27.add(2, 3);

        Object[] arr = list_3_5_27.getArr();

        int actualResult = (int) arr[2];
        assertEquals(3, actualResult);
    }

    @Test
    public void deleteByIndex() {
        list_3_5_27.addFront(1);
        list_3_5_27.addFront(2);
        list_3_5_27.addFront(3);
        list_3_5_27.addFront(4);
        list_3_5_27.addFront(5);

        list_3_5_27.deleteByIndex(1);
        list_3_5_27.deleteByIndex(2);
        Object[] arr = list_3_5_27.getArr();

        int actualResult = (int) arr[2];
        assertEquals(NumberUtils.INTEGER_ONE, actualResult);

        actualResult = (int) arr[0];
        assertEquals(5, actualResult);
    }

    @Test
    public void contains() {
        list_3_5_27.addFront(1);
        list_3_5_27.addFront(2);
        list_3_5_27.addFront(3);
        list_3_5_27.addFront(4);
        list_3_5_27.addFront(5);

        assertTrue(list_3_5_27.contains(1));
        assertTrue(list_3_5_27.contains(2));
        assertTrue(list_3_5_27.contains(3));
        assertTrue(list_3_5_27.contains(4));
        assertTrue(list_3_5_27.contains(5));
    }

    @Test
    public void isEmpty() {
        assertTrue(list_3_5_27.isEmpty());

        list_3_5_27.addFront(1);

        assertFalse(list_3_5_27.isEmpty());
    }

    @Test
    public void size() {
        list_3_5_27.addFront(1);
        list_3_5_27.addFront(2);
        list_3_5_27.addFront(3);
        list_3_5_27.addFront(4);
        list_3_5_27.addFront(5);

        assertEquals(5, list_3_5_27.size());
    }
}