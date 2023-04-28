package four.one;

/*
Create a copy constructor for Graph that takes as input a graph G and creates and initializes a new copy
of the graph. Any changes a client makes to G should not affect the newly created graph.
 */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

// TODO create JUnit tests for exercise .
public class Exercise_4_1_3__4_1_4 {

    public static void main(String[] args) {
        In in = new In("tinyG.txt");
        Graph G = new Graph(in);
        Graph copyGraph = new Graph(G, true);
        G.addEdge(4, 9);
        StdOut.println(G);
        StdOut.println(copyGraph);
    }
}
