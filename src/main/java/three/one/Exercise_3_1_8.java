package three.one;

// What is the most frequently used word of ten letters or more in Tale of Two Cities?

import edu.princeton.cs.algs4.ST;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Exercise_3_1_8 {

    public static List<String> readFileInList(String fileName) {
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void main(String[] args) {
        List l = readFileInList("C:\\Users\\Роман\\Downloads\\alglorithms\\aTaleOfTwoCities.txt");
        Iterator<String> itr = l.iterator();
        ST<String, Integer> words = new ST<>();
        while (itr.hasNext()) {
            List<String> result = Arrays.asList(itr.next().split(" "))
                    .stream()
                    .filter(e -> !e.isEmpty())
                    .filter(e -> e.length() == 10).collect(Collectors.toList());
            for (int i = 0; i < result.size(); i++) {
                if(words.contains(result.get(i))){
                    words.put(result.get(i), words.get(result.get(i)) + 1);
                } else {
                    words.put(result.get(i), 1);
                }
            }
        }
        System.out.println(words.max()); // -> yourselves
    }
}
