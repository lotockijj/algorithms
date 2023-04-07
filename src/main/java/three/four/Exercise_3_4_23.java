package three.four;

/*
Consider modular hashing for string keys with R = 256 and M = 255. Show that this is a bad
choice because any permutation of letters within a string hashes to the same value.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Exercise_3_4_23 {

    public static void main(String[] args) {
        int R = 256;
        int M = 255;
        String[] strings = ("Consider modular hashing for string keys with R = 256 and M = 255. Show that this is a bad " +
                "choice because any permutation of letters within a string hashes to the same value. " +
                "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z").split(" ");
        List<Integer> hashes = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            int hash = hash(strings[i], R, M);
            System.out.print(hash + ", ");
            hashes.add(hash);
        }
        System.out.print("\nDuplicates: ");
        Set<Integer> uniques = new HashSet<>();
        hashes.stream()
                .filter(e -> !uniques.add(e))
                .forEach(e -> System.out.print(e + ", "));
        double percentOfDuplicates = 1.0 * uniques.size()/strings.length;
        System.out.println("\nRelation of distinct to unique: " + 1.0*Math.round(percentOfDuplicates*100)/100);
    }

    private static int hash(String letter, int R, int M){
        int hash = 0;
        for (int i = 0; i < letter.length(); i++) {
            hash = (R * hash + letter.charAt(i)) % M;
        }
        return hash;
    }


}
