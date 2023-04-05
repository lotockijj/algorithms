package three.four;

/*
How many empty lists do you expect to see when you insert N keys into a hash
table with SeparateChainingHashST, for N=10, 102, 103, 104, 105, and 106? Hint : See
Exercise 2.5.31.
 */

public class Exercise_3_4_8 {

    public static void main(String[] args) {
        findEmptyListsInSeparateChainingHashSt(10);
        findEmptyListsInSeparateChainingHashSt(100);
        findEmptyListsInSeparateChainingHashSt(1000);
        findEmptyListsInSeparateChainingHashSt(10000);
        findEmptyListsInSeparateChainingHashSt(100000);
    }

    private static void findEmptyListsInSeparateChainingHashSt(int numberOfValues) {
        SeparateChainingHashST<String, Integer> separateChainingHashST = new SeparateChainingHashST<>();
        for (int i = 0; i < numberOfValues; i++) {
            separateChainingHashST.put("" + i, i);
        }
        System.out.println("For number of values " + numberOfValues + " - " + separateChainingHashST.getEmptyLists());
    }
}
