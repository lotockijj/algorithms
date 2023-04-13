package three.five;

/*
Write a program that takes a string on standard input and an integer k as command-line argument and puts
on standard output a sorted list of the k-grams found in the string, each followed by its index in the string.
 */

import three.three.BST;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Exercise_3_5_15 {

    public static void main(String[] args) {
        int k = 3;
        String[] s = strings.replace("\n", " ").split(" ");
        BST<String, String> bst = new BST<>();
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < s.length - k; i++) {
            String temp = s[i] + " " + s[i + 1] + " " + s[i + 2];
            bst.put(s[i], temp);
            stringList.add(temp);
        }
        Iterable<String> values = bst.values();
        List<String> result = StreamSupport.stream(values.spliterator(), false).sorted().collect(Collectors.toList());
        for (int i = 0; i < result.size(); i++) {
            System.out.println(i + " - " + result.get(i));
        }
        System.out.println();
        stringList.forEach(e -> System.out.print(e + ", "));
    }

    private static final String strings = "it was the best of times it was the worst of times\n" +
            "it was the age of wisdom it was the age of foolishness\n" +
            "it was the epoch of belief it was the epoch of incredulity";
}
