package four.one;

/*
Show, in the style of the figures in this section, a detailed trace of Cycle for finding a cycle
in the graph built by Graph’s input stream constructor for the file tinyGex2.txt (see Exercise 4.1.2).
What is the order of growth of the running time of the Cycle constructor, in the worst case?

Order of growth is E + V (Edges + Vertexes)
 */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_4_1_20 {

    public static void main(String[] args) {
        In in = new In("tinyGex2.txt");
        Graph graph = new Graph(in);
        Cycle cycle = new Cycle(graph);
        boolean[] marked = cycle.getMarked();
        int[] cycles = cycle.getCycles();
        for (int i = 0; i < marked.length; i++) {
            StdOut.print(marked[i] + ", ");
        }
        StdOut.println();
        for (int i = 0; i < cycles.length; i++) {
            StdOut.print(cycles[i] + ", ");
        }
    }
}
