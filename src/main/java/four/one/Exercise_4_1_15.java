package four.one;

/*
Modify the input stream constructor for Graph to also allow adjacency lists from standard input
(in a manner similar to SymbolGraph), as in the example tinyGadj.txt shown at right.
After the number of vertices and edges, each line contains a vertex and its list of adjacent vertices.
 */

public class Exercise_4_1_15 {

    public static void main(String[] args) {
        Graph graph = new Graph("src/main/resources/tinyGadj.txt");
        System.out.println(graph);
    }
}
