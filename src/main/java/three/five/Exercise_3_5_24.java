package three.five;

/*
Non-overlapping interval search. Given a list of non-overlapping intervals of items, write a function
that takes an item as argument and determines in which, if any, interval that item lies.
For example, if the items are integers and the intervals are 1643-2033, 5532-7643, 8999-10332, 5666653-5669321,
then the query point 9122 lies in the third interval and 8122 lies in no interval.
 */

import three.BinarySearchST;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise_3_5_24 {
    private final static String RANGE_AS_STRING = "1643-2033, 5532-7643, 8999-10332, 5666653-5669321";

    public static void main(String[] args) {
        BinarySearchST<Integer, Integer> binarySearchST = new BinarySearchST<>(16);
        List<String> rangeAsList = Arrays.stream(RANGE_AS_STRING.split(","))
                .map(String::trim).collect(Collectors.toList());
        for (int i = 0; i < rangeAsList.size(); i++) {
            String[] splitKeyValue = rangeAsList.get(i).split("-");
            binarySearchST.put(Integer.parseInt(splitKeyValue[0]), Integer.parseInt(splitKeyValue[1]));
        }
        System.out.println(binarySearchST.getIntervalIndex(9122));
        System.out.println(binarySearchST.getIntervalIndex(8122));
    }
}
