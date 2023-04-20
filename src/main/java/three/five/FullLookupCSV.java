package three.five;

import edu.princeton.cs.algs4.In;

public class FullLookupCSV {

    public LinearProbingHashST_3_5_8<Integer, String> getFullLookCSV(In in){
        LinearProbingHashST_3_5_8<Integer, String> linearProbingHashST = new LinearProbingHashST_3_5_8<>(256);
        boolean isItHeadOfCSV = true;
        Integer[] csv = new Integer[0];
        while(in.hasNextLine()){
            String line = in.readLine();
            String[] tokens = line.split(",");
            if(isItHeadOfCSV) {
                csv = new Integer[tokens.length];
                for (int i = 0; i < csv.length; i++) {
                    csv[i] = Integer.valueOf(tokens[i]);
                }
            } else {
                for (int i = 0; i < csv.length; i++) {
                    linearProbingHashST.put(csv[i], tokens[i]);
                }
            }
            isItHeadOfCSV = false;
        }
        return linearProbingHashST;
    }
}
