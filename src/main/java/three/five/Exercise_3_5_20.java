package three.five;

/*
Concordance. Write an ST client Concordance that puts on standard output a
concordance of the strings in the standard input stream (see page 498).
An interesting special case is known as a concordance, which associates each word in a text with the
set of positions in the text where that word occurs (see Exercise 3.5.20).
 */

import com.apicatalog.jsonld.StringUtils;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class Exercise_3_5_20 {

    public static void main(String[] args) throws IOException {
        LinearProbingHashST_3_5_8<String, Integer> linearProbingHashST_3_5_8 = new LinearProbingHashST_3_5_8<>(256);
        String path = "C:\\Users\\Роман\\Downloads\\alglorithms2\\tinyTale.txt";
        FileInputStream fis = new FileInputStream(path);
        String data = IOUtils.toString(fis, "UTF-8");
        String[] words = data.split("[.:;\\s\\n\\t]");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if(StringUtils.isNotBlank(word)) {
                linearProbingHashST_3_5_8.put(word, i);
            }
        }
        List<String> keys = linearProbingHashST_3_5_8.getKeys();
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            List<Integer> integers = linearProbingHashST_3_5_8.get(key);
            System.out.print(key + ": ");
            integers.forEach(e -> System.out.print(e + ", "));
            System.out.println();
        }
    }
}
