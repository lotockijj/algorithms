package three.five;

/*
Sparse matrices. Develop an API and an implementation for sparse 2D matrices.
Support matrix addition and matrix multiplication. Include constructors for row and column vectors.
 */

public class Exercise_3_5_23 {

    public static void main(String[] args) {
        exampleFromBook();
        SparseVerctor sparseVerctor = new SparseVerctor();
        fillSparseVerctor(sparseVerctor);
        double[] doubles = fillVector(5);
        double dot = sparseVerctor.dot(doubles);
        System.out.println(dot);
        double[] resultMultiplicationVector = sparseVerctor.getResultMultiplicationVector(doubles);
        System.out.print("Multiplication: ");
        for (int i = 0; i < resultMultiplicationVector.length; i++) {
            System.out.print(resultMultiplicationVector[i] + ", ");
        }
        double[] resultAdditionVector = sparseVerctor.getResultAdditionVector(doubles);
        System.out.print("\nAddition: ");
        for (int i = 0; i < resultAdditionVector.length; i++) {
            System.out.print(resultAdditionVector[i] + ", ");
        }
    }

    private static void fillSparseVerctor(SparseVerctor sparseVerctor){
        String[] splitRows = matrix.split("\n");
        for (int i = 0; i < splitRows.length; i++) {
            String[] splitColumns = splitRows[i].split(" ");
            for (int j = 0; j < splitColumns.length; j++) {
                sparseVerctor.put(i, Double.parseDouble(splitColumns[j]));
            }
        }
    }

    private static void exampleFromBook() {
        int n = 5;
        double[][] a = fillMatrix(n);
        double[] x = fillVector(n);
        double[] b = new double[n];
        for (int i = 0; i < n; i++) {
            double sum = 0.0;
            for (int j = 0; j < n; j++) {
                sum += a[i][j] * x[j];
            }
            b[i] = sum;
            System.out.println(sum);
        }
    }

    private static double[][] fillMatrix(int n){
        double [][] a = new double[n][n];
        String[] splitRows = matrix.split("\n");
        for (int i = 0; i < splitRows.length; i++) {
            String[] splitColumns = splitRows[i].split(" ");
            for (int j = 0; j < splitColumns.length; j++) {
                a[i][j] = Double.parseDouble(splitColumns[j]);
            }
        }
        return a;
    }

    private static double[] fillVector(int n){
        double[] x = new double[n];
        String[] spl = vector.split(" ");
        for (int i = 0; i < spl.length; i++) {
            x[i] = Double.parseDouble(spl[i]);
        }
        return x;
    }

    private static String matrix = "0 0.90 0 0 0\n" +
            "0 0 0.36 0.36 0.18\n" +
            "0 0 0 0.90 0\n" +
            "0.90 0 0 0 0\n" +
            "0.47 0 0.47 0 0";

    private static String vector = "0.05 0.04 0.36 0.37 0.19";
}
