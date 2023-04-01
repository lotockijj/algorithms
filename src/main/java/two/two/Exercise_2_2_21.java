package two.two;

/* Triplicates. Given three lists of N names each, devise a linearithmic algorithm to determine
if there is any name common to all three lists, and if so, return the first such name. */

import edu.princeton.cs.algs4.StdOut;

import static java.util.Arrays.sort;

public class Exercise_2_2_21 {


    private static String findCommon(String[] names1, String[] names2, String[] names3) {
        sort(names1);
        sort(names2);
        sort(names3);
        int index1 = 0, index2 = 0, index3 = 0, size1 = names1.length, size2 = names2.length, size3 = names3.length;
        int maxSize = size1 > size2 ? size1 : size2 > size3 ? size2 : size3;
        for (int i = 0; i < maxSize; i++) {
            if(index1 < size1 && index2 < size2 && names1[index1] == names2[index2]){
                return names1[index1];
            } else if(index1 < size1 && index2 < size2 && names1[index1].compareTo(names2[index2]) == 1){
                index2++;
            } else {
                index1++;
            }

            if(index1 < size1 && index3 < size3 && names1[index1] == names3[index3]){
                return names1[index1];
            } else if(index1 < size1 && index3 < size3 && names1[index1].compareTo(names3[index3]) == 1){
                index3++;
            } else {
                index1++;
            }

            if(index2 < size2 && index3 < size3 && names2[index2] == names3[index3]){
                return names2[index2];
            } else if(index2 < size2 && index3 < size3 && names2[index2].compareTo(names3[index3]) == 1){
                index3++;
            } else {
                index2++;
            }

        }
        return null;
    }

    public static void main(String[] args) {
        String[] names1 = {"a", "c", "y", "b", "z"};
        String[] names2 = {"roma", "vasya", "tanya", "a"};
        String[] names3 = {"Belz", "Lviv", "Kyiv", "Tbilisi", "a", "Nevada"};
        String common = findCommon(names1, names2, names3);
        StdOut.print(common);
    }
}
