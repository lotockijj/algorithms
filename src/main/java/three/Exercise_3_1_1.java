package three;

/* Write a client that creates a symbol table mapping letter grades to numerical
scores, as in the table below, then reads from standard input a list of letter grades and
computes and prints the GPA (the average of the numbers corresponding to the grades).
A+      A      A-     B+    B      B-      C+      C      C-      D       F
4.33    4.00   3.67   3.33  3.00   2.67    2.33    2.00   1.67    1.00    0.00
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise_3_1_1 {
    private final static String grades = "A+      A      A-     B+    B      B-      C+      C      C-      D       F";
    private final static String scores = "4.33    4.00   3.67   3.33  3.00   2.67    2.33    2.00   1.67    1.00    0.00";

    public static void main(String[] args) {
        String[] grades = {"A", "A", "B", "B", "C", "C"};
        String[] grades2 = {"A", "A", "B", "B", "C", "C", "A-"};
        computeAvarageGrade(grades);
        computeAvarageGrade(grades2);

        BinarySearchST binarySearchST = new BinarySearchST(11);
        computeAvarageGradeFromBinarySearchST(binarySearchST, grades);
        computeAvarageGradeFromBinarySearchST(binarySearchST, grades2);

        SequentialSearchST sequentialSearchST = new SequentialSearchST();
        computeAvarageGradeFromSequentialSearchST(sequentialSearchST, grades);
        computeAvarageGradeFromSequentialSearchST(sequentialSearchST, grades2);
    }

    private static void computeAvarageGradeFromSequentialSearchST(SequentialSearchST sequentialSearchST, String[] grades) {
        Map<String, Double> gradesScores = getGrades();
        for(Map.Entry<String, Double> e : gradesScores.entrySet()){
            sequentialSearchST.put(e.getKey(), e.getValue());
        }
        double sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += (Double) sequentialSearchST.get(grades[i]);
        }
        System.out.println(sum/grades.length);
    }

    private static void computeAvarageGradeFromBinarySearchST(BinarySearchST binarySearch, String[] grades) {
        Map<String, Double> gradesScores = getGrades();
        for(Map.Entry<String, Double> e : gradesScores.entrySet()){
            binarySearch.put(e.getKey(), e.getValue());
        }
        double sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += (Double) binarySearch.get(grades[i]);
        }
        System.out.println(sum/grades.length);
    }

    private static void computeAvarageGrade(String[] grades) {
        Map<String, Double> gradesScores = getGrades();
        double sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += gradesScores.get(grades[i]);
        }
        System.out.println(sum/grades.length);
    }

    private static Map<String, Double> getGrades() {
        Map<String, Double> gradesMap = new HashMap<>();
        String[] gradesArr = Arrays.asList(grades.split(" "))
                .stream()
                .map(e -> e.trim())
                .filter(e -> !e.isEmpty())
                .collect(Collectors.toList())
                .toArray(String[]::new);
        Double[] scoresArr = Arrays.asList(scores.split(" "))
                .stream()
                .map(e -> e.trim())
                .filter(e -> !e.isEmpty())
                .map(Double::valueOf)
                .collect(Collectors.toList())
                .toArray(Double[]::new);
        for (int i = 0; i < gradesArr.length; i++) {
            gradesMap.put(gradesArr[i], scoresArr[i]);
        }
        return gradesMap;
    }
}
