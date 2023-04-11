package three.one;

/* Software caching. Since the default implementation of contains() calls get(),
the inner loop of FrequencyCounter
if (!st.contains(word)) st.put(word, 1);
else st.put(word, st.get(word) + 1);
leads to two or three searches for the same key. To enable clear client code like this
without sacrificing efficiency, we can use a technique known as software caching, where
we save the location of the most recently accessed key in an instance variable. Modify
SequentialSearchST and BinarySearchST to take advantage of this idea.*/

import three.BinarySearchST;
import three.SequentialSearchST;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise_3_1_25 {
    private final static String path = "C:\\Users\\Роман\\Downloads\\alglorithms\\tale.txt";

    public static void main(String[] args) {
        SequentialSearchST<String, Integer> sequentialSearchST = new SequentialSearchST<>();
        BinarySearchST<Integer, String> binarySearchST = new BinarySearchST<>(100);
        //Exercise_3_1_25.findFrequencyCounter(sequentialSearchST, path, 10);
        Exercise_3_1_25.fillSequentialSearchST(sequentialSearchST);
        System.out.println(sequentialSearchST.keys());
    }

    public static void findFrequencyCounter(SequentialSearchST<String, Integer>  sequentialSearchST,
                                                                           String path, int length) {
        try (FileInputStream inputStream = new FileInputStream(path)){
            Scanner sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                List<String> strings = Arrays.asList(sc.nextLine().split(" "))
                        .stream()
                        .map(e -> e.trim())
                        .filter(e -> !e.isEmpty())
                        .filter(e -> e.length() >= length)
                        .collect(Collectors.toList());
                for (int i = 0; i < strings.size(); i++) {
                    String word = strings.get(i);
                    if (!sequentialSearchST.contains(word)) {
                        sequentialSearchST.put(word, 1);
                    } else {
                        sequentialSearchST.put(word, sequentialSearchST.get(word) + 1);
                    }
                }
            }
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fillSequentialSearchST(SequentialSearchST<String, Integer> sequentialSearchST){
        String[] testString = {"s", "s", "1", "1", "s", "t", "t", "t", "q"};
        for (int i = 0; i < testString.length; i++) {
            String word = testString[i];
            if (!sequentialSearchST.contains(word)) {
                sequentialSearchST.put(word, 1);
            } else {
                sequentialSearchST.put(word, sequentialSearchST.get(word) + 1);
            }
        }
    }
}
