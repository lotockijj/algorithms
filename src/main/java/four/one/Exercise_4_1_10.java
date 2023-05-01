package four.one;

/*
Prove that every connected graph has a vertex whose removal (including all adjacent edges) will not disconnect the graph,
and write a DFS method that finds such a vertex. Hint : Consider a vertex whose adjacent vertices are all marked.
 */


import java.util.List;

public class Exercise_4_1_10 {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        printEdgesThatNotDisconnectGraph(graph); //0, 4
        graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        printEdgesThatNotDisconnectGraph(graph);//0,2,4,5,6
    }

    private static void printEdgesThatNotDisconnectGraph(Graph graph) {
        DepthFirstSearch_4_1_10 depthFirstSearch_4_1_10 = new DepthFirstSearch_4_1_10(graph);
        List<Integer> notDisconnectedVertexes = depthFirstSearch_4_1_10.getNotDisconnectedVertexes();
        notDisconnectedVertexes.forEach(e -> System.out.print(e + ", "));
        System.out.println();
    }
}
