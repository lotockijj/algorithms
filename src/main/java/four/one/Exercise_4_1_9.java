package four.one;

/*
Show, in the style of the figure on page 533, a detailed trace of the call dfs(0) for the graph built by Graph’s
input stream constructor for the file tinyGex2.txt (see Exercise 4.1.2). Also, draw the tree represented by edgeTo[].
 */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_4_1_9 {

    public static void main(String[] args) {
        In in = new In("tinyGex2.txt");
        Graph graph = new Graph(in);
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, 0);
        int count = depthFirstSearch.count();
        System.out.println("\n" + count);

        BreadthFirstPaths breadthFirstPaths = new BreadthFirstPaths(graph, 0);
        Iterable<Integer> path = breadthFirstPaths.pathTo(5);
        for (int n : path){
            StdOut.print(n + ", ");
        }
    }
}
