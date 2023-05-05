package four.one;

/*
The eccentricity of a vertex v is the length of the shortest path from that vertex to the furthest vertex from v.
The diameter of a graph is the maximum eccentricity of any vertex. The radius of a graph is the smallest
eccentricity of any vertex. A center is a vertex whose eccentricity is the radius. Implement the following API:

public GraphProperties(Graph G) // constructor (exception if G not connected)
public int eccentricity(int v) // eccentricity of v
public int diameter() // diameter of G
public int radius()   // radius of G
public int center()   // a center of G
 */

import edu.princeton.cs.algs4.In;

// TODO: 05.05.2023 Write JUnit, try to improve performance for big graphs
public class Exercise_4_1_16 {

    public static void main(String[] args) {
        In in = new In("tinySimple.txt");
        Graph graph = new Graph(in);
        GraphProperties graphProperties = new GraphProperties(graph);
        System.out.println(graphProperties);

        in = new In("tinySimple2.txt");
        graph = new Graph(in);
        GraphProperties graphProperties2 = new GraphProperties(graph);
        System.out.println(graphProperties2);
    }
}
