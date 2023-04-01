package three;

/*Frequency count from a dictionary. Modify FrequencyCounter to take the
name of a dictionary file as its argument, count frequencies of the words from standard
input that are also in that file, and print two tables of the words with their frequencies,
one sorted by frequency, the other sorted in the order found in the dictionary file. */

import edu.princeton.cs.algs4.ST;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Exercise_3_1_26 {
    private final static String path = "C:\\Users\\Роман\\Downloads\\alglorithms\\tale.txt";

    public static void main(String[] args) {
        ST<String, Integer> st = new ST<>();
        List<String> searchWords = Arrays.asList("word", "search", "east", "west", "count", "while", "and", "man", "could", "fair", "lie");
        findFrequencyCounter(st, path, searchWords);
        Iterator<String> iterator = st.keys().iterator();
        List<String> keys = new ArrayList<>();
        while(iterator.hasNext()){
            keys.add(iterator.next());
        }
        //keys.sort(Comparator.naturalOrder());
        //keys.forEach(e -> System.out.println(e + " " + st.get(e)));
        //Map<Integer, String> stMap = new TreeMap<>();
        Map<Integer, String> stMap = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            stMap.put(st.get(keys.get(i)), keys.get(i));
        }
        System.out.println("St map: ");
        stMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
        //stMap.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    public static void findFrequencyCounter(ST<String, Integer> st, String path, List<String> searchWords) {

        try (FileInputStream inputStream = new FileInputStream(path)){
            Scanner sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                List<String> strings = Arrays.asList(sc.nextLine().split(" "))
                        .stream()
                        .map(e -> e.trim())
                        .filter(e -> !e.isEmpty())
                        .filter(e -> searchWords.contains(e))
                        .collect(Collectors.toList());
                for (int i = 0; i < strings.size(); i++) {
                    String word = strings.get(i);
                    if (!st.contains(word)) {
                        st.put(word, 1);
                    } else {
                        st.put(word, st.get(word) + 1);
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
}
