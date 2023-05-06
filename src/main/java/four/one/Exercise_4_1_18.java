package four.one;

/*
The girth of a graph is the length of its shortest cycle.If a graph is acyclic,then its girth is infinite.
Add a method girth() to GraphProperties that returns the girth of the graph. Hint : Run BFS from each vertex.
The shortest cycle containing s is the shortest path from s to some vertex v, plus the edge from v back to s.
 */

import edu.princeton.cs.algs4.In;

// TODO: 06.05.2023 Write extensive JUnit tests.
public class Exercise_4_1_18 {

    public static void main(String[] args) {
        In in = new In("tinySimple2.txt");
        //In in = new In("simpleCycle.txt");
        Graph graph = new Graph(in);
        GraphProperties graphProperties = new GraphProperties(graph);
        System.out.println(graphProperties);
    }
}
