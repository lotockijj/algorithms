package one_four;/*Local minimum of a matrix. Given an N-by-N array a[] of N 2 distinct inte-
gers, design an algorithm that runs in time proportional to N to find a local minimum:
a pair of indices i and j such that a[i][j] < a[i+1][j], a[i][j] < a[i][j+1],
a[i][j] < a[i-1][j], and a[i][j] < a[i][j-1]. The running time of your pro-
gram should be proportional to N in the worst case.*/

public class Exercise_1_4_19 {

    private static int[][] findLocalMinimum(int[][] a){
        int[][] res = new int[1][1];
        int len = res.length;
        int len2 = res[0].length;
        for(int i = len/2; i > 0; i /= 2){
            for(int j = len2; j > 0; j /= 2){
                if(a[i][j] < a[i + 1][j] && a[i][j] < a[i][j + 1]
                && a[i][j] < a[i - 1][j] && a[i][j] < a[i][j - 1]){
                   res[0][0] = a[i][j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] a = {{-100, 10, 20, 40, 50, 100}, {-2, -1, 4, 3, 9, 60}, {17, 23, 24, 29, 33, 37}};
        int[][] localMinimum = findLocalMinimum(a);
        System.out.println(localMinimum[0][0]);
    }
}
