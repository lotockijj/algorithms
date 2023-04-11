package three.five;

/*
3.5.1 Implement SET and HashSET as “wrapper class” clients of ST and HashST, respectively (provide dummy values and ignore them).

3.5.4 Develop classes HashSTint and HashSTdouble for maintaining sets of keys of
primitive int and double types, respectively. (Convert generics to primitive types in
the code of LinearProbingHashST.)
*/

public class Exercise_3_5_1__3_5_4 {

    public static void main(String[] args) {
        ST st = new ST();
        HashST hashST = new HashST();
        for (int i = 0; i < 10; i++) {
            st.put(i + 1, 1.0 + i);
            hashST.put(i + 1, 1.0 + i);
        }
        System.out.println("ST:");
        st.getKeys().forEach(System.out::print);

        System.out.println("\nHashST: ");
        int[] keys = hashST.getKeys();
        double[] values = hashST.getVals();
        for (int i = 0; i < keys.length; i++) {
            if(keys[i] != 0) {
                System.out.print(keys[i] + "-" + values[i] + ", ");
            }
        }
    }
}
