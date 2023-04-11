package three.one;

/*  Develop a symbol-table implementation ArrayST that uses an (unordered) array
    as the underlying data structure to implement our basic symbol-table API. */

import three.ArrayST;

import java.util.Random;

public class Exercise_3_1_2 {
    public static void main(String[] args) {
        fillAndPrintDoubleValuesForArrayST();
        fillAndPrintIntegerValuesForArrayST();
    }

    private static void fillAndPrintIntegerValuesForArrayST() {
        int capacity = 10;
        ArrayST arrayST = new ArrayST(capacity);
        Random random = new Random();
        for (int i = 0; i < capacity; i++) {
            arrayST.put(i, random.nextInt(10));
        }
        for (int i = 0; i < capacity; i++) {
            System.out.print(arrayST.getValue(i) + ", ");
        }
    }

    private static void fillAndPrintDoubleValuesForArrayST() {
        int capacity = 10;
        ArrayST arrayST = new ArrayST(capacity);
        Random random = new Random();
        for (int i = 0; i < capacity; i++) {
            arrayST.put(i, random.nextDouble());
        }
        for (int i = 0; i < capacity; i++) {
            System.out.println(arrayST.getValue(i) + ", ");
        }
        System.out.println();
    }
}
