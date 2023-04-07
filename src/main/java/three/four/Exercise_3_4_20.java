package three.four;

/*
Add a method to LinearProbingHashST that computes the average cost of a
search hit in the table, assuming that each key in the table is equally likely to be sought.
 */

public class Exercise_3_4_20 {

    public static void main(String[] args) {
        String[] strings = "S E A R C H X M P L N T V Z W I".split(" ");
        LinearProbingHashST<String, Integer> linearProbingHashST = new LinearProbingHashST<>();
        for (int i = 0; i < strings.length; i++) {
            linearProbingHashST.put(strings[i], i);
        }
        System.out.println("Average cost of a search hit for letter ");
        for (int i = 0; i < strings.length; i++) {
            linearProbingHashST.get(strings[i]);
            System.out.println(strings[i] + ": " + linearProbingHashST.getAverageCostOfSearchHit());
        }
    }
}
