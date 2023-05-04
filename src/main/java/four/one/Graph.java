package four.one;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import three.five.Bag;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Stack;

//4.1.5 Modify Graph to disallow parallel edges and self-loops.

public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");
    private int V;
    private int E;
    private Bag<Integer>[] adj;

    public Graph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be non-negative");
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public Graph(In in) {
        if (in == null) throw new IllegalArgumentException("argument is null");
        try {
            this.V = in.readInt();
            if (V < 0) throw new IllegalArgumentException("number of vertices in a Graph must be non-negative");
            adj = (Bag<Integer>[]) new Bag[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new Bag<>();
            }
            int E = in.readInt();
            if (E < 0) throw new IllegalArgumentException("number of edges in a Graph must be non-negative");
            for (int i = 0; i < E; i++) {
                int v = in.readInt();
                int w = in.readInt();
                validateVertex(v);
                validateVertex(w);
                addEdge(v, w);
            }
        }
        catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input format in Graph constructor", e);
        }
    }

    public Graph(Graph graph, boolean deepCopy){
        this(graph.V);
        adj = (Bag<Integer>[]) new Bag[graph.V];
        for (int i = 0; i < adj.length && deepCopy; i++) {
            Bag<Integer> integers = graph.adj[i];
            Iterator<Integer> iterator = integers.iterator();
            Bag<Integer> bag = new Bag<>();
            while(iterator.hasNext()){
                Integer next = iterator.next();
                bag.add(next);
                if(!(hasEdge(i, next))) {
                    E++;
                }
            }
            adj[i] = bag;
        }
    }

    public Graph(String stream) {
        In in = new In(stream);
        String[] vertexes_edges = in.readLine().split(" ");
        this.V = Integer.parseInt(vertexes_edges[0]);
        this.E = Integer.parseInt(vertexes_edges[1]);
        adj = (Bag<Integer>[]) new Bag[V];
        while (in.hasNextLine()) { // builds the index
            String[] vertexesAsStrings = in.readLine().split(" ");
            int v = Integer.parseInt(vertexesAsStrings[0]);
            if(adj[v] == null) {
                adj[v] = new Bag<>();
            }
            for (int i = 1; i < vertexesAsStrings.length; i++) {
                int w = Integer.parseInt(vertexesAsStrings[i]);
                adj[v].add(w);
                if(adj[w] == null){
                    adj[w] = new Bag<>();
                    adj[w].add(v);
                } else {
                    if(!adj[w].contains(v)){
                        adj[w].add(v);
                    }
                }

            }
        }
    }

    private boolean hasEdge(int v, int w) {
        return innerHasEdge(v, w) || innerHasEdge(w, v);
    }

    private boolean innerHasEdge(int w, int v){
        return Optional.ofNullable(adj[v]).map(e -> {
            for (Integer integer : e) {
                if (integer == w) {
                    return true;
                }
            }
            return false;
        }).orElse(false);
    }

    public Graph(Graph G) {
        this.V = G.V();
        this.E = G.E();
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be non-negative");
        // update adjacency lists
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }

        for (int v = 0; v < G.V(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : G.adj[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
    }

    public int V() { //number of vertices
        return V;
    }

    public int E() { //number of edges
        return E;
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        if(v == w || hasEdge(v, w)) {
            return;
        }
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    // TODO:Write jUnit for this method
    public void deleteEdge(int v, int w){
        adj[v].delete(w);
        adj[w].delete(v);
        E--;
    }

    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int w : G.adj(v)) degree++;
        return degree;
    }

    public static int maxDegree(Graph G) {
        int max = 0;
        for (int v = 0; v < G.V(); v++)
            if (degree(G, v) > max)
                max = degree(G, v);
        return max;
    }

    public static int avgDegree(Graph G) {
        return 2 * G.E() / G.V();
    }

    public static int numberOfSelfLoops(Graph G) {
        int count = 0;
        for (int v = 0; v < G.V(); v++)
            for (int w : G.adj(v))
                if (v == w) count++;
        return count/2; // each edge counted twice
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        In in = new In("tinyGex2.txt");
        //In in = new In("mediumG.txt");
        //In in = new In("tinyG.txt");
        Graph G = new Graph(in);
        StdOut.println(G);
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public Bag<Integer>[] getAdj() {
        return adj;
    }
}
