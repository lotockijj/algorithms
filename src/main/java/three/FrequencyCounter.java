package three;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class FrequencyCounter { // ctrl + D
    public static String lastWord;
    public static int numberOfWords = 0;

    public static void main(String[] args) {
        int minlen = Integer.parseInt("2"); // key-length cutoff
        ST<String, Integer> st = new ST<>();
        while (!StdIn.isEmpty()) { // Build symbol table and count frequencies.
            String word = StdIn.readString();// ctrl + D
            if (word.length() < minlen) continue; // Ignore short keys.
            if (!st.contains(word)) st.put(word, 1);
            else st.put(word, st.get(word) + 1);
        }
// Find a key with the highest frequency count.
        String max = "";
        st.put(max, 0);
        for (String word : st.keys())
            if (st.get(word) > st.get(max))
                max = word;
        StdOut.println(max + " " + st.get(max));
    }

    public static int findDistinctKeys(List<Integer> numbers){
        Set<Integer> distinct = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            distinct.add(numbers.get(i));
        }
        return distinct.size();
    }

    public static ST<String, Integer> findFrequencyCounter(String path, int length) {
        ST<String, Integer> st = new ST<>();

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
                    lastWord = word;
                    if (!st.contains(word)) {
                        st.put(word, 1);
                        numberOfWords++;
                    } else {
                        st.put(word, st.get(word) + 1);
                        numberOfWords++;
                    }
                }
            }
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return st;
    }
}