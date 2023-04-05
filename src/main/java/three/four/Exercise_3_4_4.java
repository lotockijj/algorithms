package three.four;

/*
Write a program to find values of a and M, with M as small as possible, such that
the hash function (a * k) % M for transforming the kth letter of the alphabet into a
table index produces distinct values (no collisions) for the keys S E A R C H X M P L.
The result is known as a perfect hash function.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise_3_4_4 {

    public static void main(String[] args) {
        String[] strings = "S E A R C H X M P L".split(" ");
        System.out.println(findSmallestValue(strings));
    }

    private static StringBuilder findSmallestValue(String[] strings) {
        StringBuilder stringBuilderTemp = new StringBuilder();
        List<Integer> hashCodes = new ArrayList<>();
        int tempSum = 45;
        for (int i = 40; i >= 0; i--) {
            for (int j = 40; j >= 1; j--) {
                for (int k = 0; k < strings.length; k++) {
                    int hashCode = hashFunction(i, strings[k].charAt(0), j);
                    hashCodes.add(hashCode);
                }
                if(hashCodes.stream().collect(Collectors.toSet()).size() == strings.length){
                    if(tempSum >= i + j) {
                        stringBuilderTemp.setLength(0);
                        stringBuilderTemp.append(i).append("  ").append(j);
                    }
                }
                hashCodes.clear();
            }
        }
        return stringBuilderTemp;
    }

    private static int hashFunction(int a, int k, int m) {
        return (a * k) % m;
    }
}
