package three.five.experiments;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import three.five.HashST;

public class BlackFilter {

    public static void main(String[] args) {
        HashST set;
        set = new HashST();
        In in = new In(args[0]);
        while(!in.isEmpty()){
            set.put(Integer.parseInt(in.readString()), 1);
        }
        while(StdIn.isEmpty()){
            String word = StdIn.readString();
            if(!set.contains(Integer.parseInt(word))){ // !
                StdOut.println(word);
            }
        }
    }
}
