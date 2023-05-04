package four.one;

/*
Add a distTo() method to the BreadthFirstPaths API and implementation, which returns the number of edges
on the shortest path from the source to a given vertex. A distTo() query should run in constant time.
 */

import edu.princeton.cs.algs4.In;

public class Exercise_4_1_13 {

    public static void main(String[] args) {
        In in = new In("tinyGex2.txt");
        Graph graph = new Graph(in);
        BreadthFirstPaths breadthFirstPaths = new BreadthFirstPaths(graph, 0);
        System.out.println(breadthFirstPaths.distTo(0));// should be 0;
        System.out.println(breadthFirstPaths.distTo(2));// should be 1;
        System.out.println(breadthFirstPaths.distTo(6));// should be 1;
        System.out.println(breadthFirstPaths.distTo(3));// should be 2;
        System.out.println(breadthFirstPaths.distTo(10));// should be 2;
    }
}
