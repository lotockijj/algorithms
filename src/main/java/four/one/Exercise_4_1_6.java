package four.one;

/*
4.1.6 Consider the four-vertex graph with edges 0-1, 1-2, 2-3, and 3-0. Draw an array of adjacency-lists
that could not have been built calling addEdge() for these edges no matter what order.
 */

public class Exercise_4_1_6 {

    public static void main(String[] args) {
        Graph G = new Graph(4);
        G.addEdge(0, 1);
        G.addEdge(1, 2);
        G.addEdge(2, 3);
        G.addEdge(3, 0);
        G.addEdge(3, 1);
        G.addEdge(2, 0);
        G.addEdge(0, 2);

        System.out.println(G);
    }
}
