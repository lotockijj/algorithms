package four.one;

/*
Show, in the style of the figures in this section, a detailed trace of TwoColor for finding a two-coloring
of the graph built by Graph’s input stream constructor for the file tinyGex2.txt (see Exercise 4.1.2).
What is the order of growth of the running time of the TwoColor constructor, in the worst case?

Order of growth is E + V (Edges + Vertexes)
 */

import edu.princeton.cs.algs4.In;

public class Exercise_4_1_21 {

    public static void main(String[] args) {
        In in = new In("tinyGex2.txt");
        Graph graph = new Graph(in);
        TwoColor twoColor = new TwoColor(graph);
        System.out.println(twoColor.isBipartite());
    }
}
