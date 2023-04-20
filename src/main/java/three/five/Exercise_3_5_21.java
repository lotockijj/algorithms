package three.five;

/*
Inverted concordance. Write a program InvertedConcordance that takes a concordance on standard input and
puts the original string on standard output stream.
Note : This computation is associated with a famous story having to do with the Dead Sea Scrolls.
The team that discovered the original tablets enforced a secrecy rule that essentially resulted in their
making public only a concordance. After a while, other researchers figured out how to invert the concordance,
and the full text was eventually made public.
 */

import com.apicatalog.jsonld.StringUtils;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class Exercise_3_5_21 {

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
        LinearProbingHashST_3_5_8<Integer, String> invertedLinearProbingHashST = new LinearProbingHashST_3_5_8<>(256);
        List<String> keys = linearProbingHashST_3_5_8.getKeys();
        for (int i = 0; i < keys.size(); i++) {
            String s = keys.get(i);
            List<Integer> integers = linearProbingHashST_3_5_8.get(s);
            for (int j = 0; j < integers.size(); j++) {
                invertedLinearProbingHashST.put(integers.get(j), s);
            }
        }
        List<String> invertedValues = invertedLinearProbingHashST.getVals();
        int firstLine = 5;
        for (int i = 0; i < invertedValues.size(); i++) {
            String s = invertedValues.get(i);
            if(s != null) {
                if(i != 0 && s.equals("it")) {
                    System.out.print("\n" + s + " ");
                } else {
                    System.out.print(s + " ");
                }
            }
        }
    }
}
