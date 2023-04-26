package four.one;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.*;

public class Search {
    private Set<Integer> bags;
    private int count;

    public Search(Graph G, int s) { //find vertices connected to a source vertex s
        bags = new HashSet<>();
        addAdjacent(G, s);
    }

    private void addAdjacent(Graph G, int s){
        Iterable<Integer> adj = G.adj(s);
        Iterator<Integer> iterator = adj.iterator();
        while(iterator.hasNext()){
            Integer next = iterator.next();
            if(!bags.contains(next)){
                bags.add(next);
                count++;
                addAdjacent(G, next);
            }
        }
    }

    public boolean marked(int v) {//is v connected to s?
        boolean result = false;
        if(bags.contains(v)){
            result = true;
        }
        return result;
    }

    public int count() {//how many vertices are connected to s?
        return count;
    }

    public static void main(String[] args) {
        //In in = new In("mediumG.txt");
        In in = new In("tinyG.txt");
        Graph G = new Graph(in);
        Search search = new Search(G, 0);
        System.out.println("Marked 1 should return true: " + search.marked(1)
        + "\nMarked 11 should return false: " + search.marked(11));

        Graph G2 = new Graph(new In("tinyG.txt"));
        int s = 0;
        Search search2 = new Search(G2, s);
        for (int v = 0; v < G.V(); v++)
            if (search2.marked(v))
                StdOut.print(v + " ");
        StdOut.println();
        if (search.count() != G.V())
            StdOut.print("NOT ");
        StdOut.println("connected");
    }
}
