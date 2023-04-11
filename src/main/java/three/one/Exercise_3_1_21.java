package three.one;

/* Memory usage. Compare the memory usage of BinarySearchST with that of
   SequentialSearchST for N key-value pairs, under the assumptions described in Section 1.4.
   Do not count the memory for the keys and values themselves, but do count
   references to them. For BinarySearchST, assume that array resizing is used, so that the
   array is between 25 percent and 100 percent full.
   */

import edu.princeton.cs.algs4.BinarySearchST;
import edu.princeton.cs.algs4.In;
import three.SequentialSearchST;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise_3_1_21 {

    public static void main(String[] args) {
        String path = "C:\\Users\\Роман\\Downloads\\alglorithms\\tale.txt";
        BinarySearchST<String, Integer> binarySearchST = new BinarySearchST<>();
        long startTime = new Date().getTime();
        fillBinarySearchST(binarySearchST, path);
        long finishTime = new Date().getTime();
        System.out.println(finishTime - startTime);
        startTime = new Date().getTime();
        SequentialSearchST<String, Integer> sequentialSearchST = new SequentialSearchST<>();
        fillSequentialSearchST(sequentialSearchST, path);
        finishTime = new Date().getTime();
        System.out.println(finishTime - startTime);
    }

    private static void fillSequentialSearchST(SequentialSearchST<String, Integer> sequentialSearchST, String path) {
        try (FileInputStream inputStream = new FileInputStream(path)){
            Scanner sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                List<String> strings = Arrays.asList(sc.nextLine().split(" "))
                        .stream()
                        .map(e -> e.trim())
                        .filter(e -> !e.isEmpty())
                        .collect(Collectors.toList());
                for (int i = 0; i < strings.size(); i++) {
                    String word = strings.get(i);
                    if (sequentialSearchST.get(word) == null) {
                        sequentialSearchST.put(word, 1);
                    } else {
                        sequentialSearchST.put(word, sequentialSearchST.get(word) + 1);
                    }
                }
            }
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fillBinarySearchST(BinarySearchST<String, Integer> binarySearchST, String path) {
        try (FileInputStream inputStream = new FileInputStream(path)){
            Scanner sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                List<String> strings = Arrays.asList(sc.nextLine().split(" "))
                        .stream()
                        .map(e -> e.trim())
                        .filter(e -> !e.isEmpty())
                        .collect(Collectors.toList());
                for (int i = 0; i < strings.size(); i++) {
                    String word = strings.get(i);
                    if (!binarySearchST.contains(word)) {
                        binarySearchST.put(word, 1);
                    } else {
                        binarySearchST.put(word, binarySearchST.get(word) + 1);
                    }
                }
            }
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
