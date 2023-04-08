package three.four;

/*
Hash attack. Find 2N(square) strings, each of length 2N(square), that have the same hashCode()
value, supposing that the hashCode() implementation for String is the following:
    public int hashCode(){
        int hash = 0;
        for (int i = 0; i < length(); i ++)
        hash = (hash * 31) + charAt(i);
        return hash;
    }
Strong hint : Aa and BB have the same value.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise_3_4_32 {
    private static final String[] stringsUpperCase = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");
    private static final String[] stringsLowerCase = "a b c d e f g h i j k l m n o p q r s t u v w x y z".split(" ");

    public static void main(String[] args) {
        Map<String, Integer> stringsHashCodes = new HashMap<>();
        for (int i = 0; i < stringsUpperCase.length; i++) {
            for (int j = 0; j < stringsLowerCase.length; j++) {
                String str1 = stringsUpperCase[i] + stringsLowerCase[j];
                String str2 = stringsUpperCase[i] + stringsUpperCase[i];
                String str3 = stringsUpperCase[j] + stringsUpperCase[i];
                String str4 = stringsUpperCase[j] + stringsUpperCase[j];
                stringsHashCodes.put(str1, hashCode(str1));
                stringsHashCodes.put(str2, hashCode(str2));
                stringsHashCodes.put(str3, hashCode(str3));
                stringsHashCodes.put(str4, hashCode(str4));
            }
        }
        Map<Integer, List<String>> duplicates = getDuplicates(stringsHashCodes);
        duplicates.entrySet().stream().filter(e -> e.getValue().size() > 1).forEach(e -> System.out.print(e + ", "));
        System.out.println("\nNumber of duplicates: " + duplicates.size());
    }

    private static Map<Integer, List<String>> getDuplicates(Map<String, Integer> stringsHashCodes) {
        Map<Integer, List<String>> playersPercentileCount = new HashMap<>();
        for(Map.Entry<String, Integer> entry : stringsHashCodes.entrySet()) {
            if(playersPercentileCount.containsKey(entry.getValue())) {
                List<String> duplicates = playersPercentileCount.get(entry.getValue());
                duplicates.add(entry.getKey());
                playersPercentileCount.put(entry.getValue(), duplicates);
            }
            else {
                List<String> strings = new ArrayList<>();
                strings.add(entry.getKey());
                playersPercentileCount.put(entry.getValue(), strings);
            }
        }
        return playersPercentileCount;
    }


    private static int hashCode(String str){
        int hash = 0;
        for (int i = 0; i < str.length(); i ++)
            hash = (hash * 31) + str.charAt(i);
        return hash;
    }
}
