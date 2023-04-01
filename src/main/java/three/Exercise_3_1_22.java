package three;

/*Self-organizing search. A self-organizing search algorithm is one that rearranges
items to make those that are accessed frequently likely to be found early in the search.
Modify your search implementation for Exercise 3.1.2 to perform the following action
on every search hit: move the key-value pair found to the beginning of the list, moving
all pairs between the beginning of the list and the vacated position to the right one position.
This procedure is called the move-to-front heuristic.*/

public class Exercise_3_1_22 {

    public static void main(String[] args) {
        ArrayST<Integer, String> arrayST = new ArrayST<>(5);
        fillArraySt(arrayST);
        arrayST.getValue(4);
        arrayST.getValue(5);
        arrayST.getValue(4);
        printArrayST(arrayST);
    }

    private static void printArrayST(ArrayST<Integer, String> arrayST) {
        Object[] keys = arrayST.getKeys();
        Object[] values = arrayST.getValues();
        for (int i = 0; i < keys.length; i++) {
            System.out.println(keys[i] + " " + values[i]);
        }
    }

    private static void fillArraySt(ArrayST<Integer, String> arrayST) {
        arrayST.put(1, "1");
        arrayST.put(2, "2");
        arrayST.put(3, "3");
        arrayST.put(4, "4");
        arrayST.put(5, "5");
    }
}
