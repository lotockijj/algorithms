package three.five;

import java.util.List;

public class SparseVerctor {
    private LinearProbingHashST_3_5_8<Integer, Double> linearProbHashST;

    public SparseVerctor(){
        linearProbHashST = new LinearProbingHashST_3_5_8<>(256);
    }

    public int size(){
        return linearProbHashST.size();
    }

    public void put(int i, double x){
        linearProbHashST.put(i, x);
    }

    public Double[] get(Integer i){
        if(!linearProbHashST.contains(i)){
            return new Double[0];
        } else {
            return linearProbHashST.get(i).toArray(new Double[linearProbHashST.get(i).size()]);
        }
    }

    public double dot(double[] that){
        double sum = 0.0;
        for(int i : linearProbHashST.getKeys()){
            Double[] doubles = get(i);
            for (int j = 0; j < doubles.length; j++) {
                sum += that[i] * doubles[i];
            }
        }
        return sum;
    }

    public double[] getResultMultiplicationVector(double[] vector){
        double[] resultVector = new double[vector.length];
        List<Integer> keys = linearProbHashST.getKeys();
        for (int i = 0; i < keys.size(); i++) {
            Double[] doubles = get(keys.get(i));
            double sum = 0.0;
            for (int j = 0; j < vector.length; j++) {
                sum += doubles[j] * vector[j];
            }
            resultVector[i] = sum;
        }
        return resultVector;
    }

    public double[] getResultAdditionVector(double[] vector){
        double[] resultVector = new double[vector.length];
        List<Integer> keys = linearProbHashST.getKeys();
        for (int i = 0; i < keys.size(); i++) {
            Double[] doubles = get(keys.get(i));
            double sum = 0.0;
            for (int j = 0; j < vector.length; j++) {
                sum += doubles[j] + vector[j];
            }
            resultVector[i] = sum;
        }
        return resultVector;
    }
}
