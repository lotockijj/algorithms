package four.one;

/*
Run SymbolGraph with movies.txt to find the Kevin Bacon number of this year’s Oscar nominees.
 */

public class Exercise_4_1_22 {

    public static void main(String[] args) {
        SymbolGraph symbolGraph = new SymbolGraph("src/main/resources/movies.txt", "/");
        Graph graph = symbolGraph.G();
        Iterable<Integer> adj = graph.adj(symbolGraph.index("Brown, Bryan (I)"));
        for(Integer i : adj){
            System.out.println(symbolGraph.name(i));
        }
    }
}
