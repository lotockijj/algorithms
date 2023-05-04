package four.one;

/*
Suppose you use a stack instead of a queue when running breadth-first search.
Does it still compute the shortest paths?

We can adjust code in BreadthFirstPaths in order to achieve this. Not efficient, should be tested on bigger graphs.
 */

import edu.princeton.cs.algs4.In;

public class Exercise_4_1_14 {

    public static void main(String[] args) {
        In in = new In("tinyGex2.txt");
        Graph graph = new Graph(in);
        BreadthFirstPaths breadthFirstPaths = new BreadthFirstPaths(graph, 0, true);
        System.out.println(breadthFirstPaths.distTo(0));// should be 0;
        System.out.println(breadthFirstPaths.distTo(2));// should be 1;
        System.out.println(breadthFirstPaths.distTo(6));// should be 1;
        System.out.println(breadthFirstPaths.distTo(3));// should be 2;
        System.out.println(breadthFirstPaths.distTo(10));// should be 2;
    }
}
