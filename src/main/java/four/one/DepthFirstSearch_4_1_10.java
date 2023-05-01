package four.one;

import three.five.Bag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// TODO: Consider renaming this class and write junit tests.
public class DepthFirstSearch_4_1_10  {
    private boolean[] marked;
    private List<Integer> notDisconnectedVertexes;
    private DepthFirstSearch depthFirstSearch;


    public DepthFirstSearch_4_1_10(Graph G) {
        marked = new boolean[G.V()];
        notDisconnectedVertexes = new ArrayList<>();
        dfs(G);
    }

    private void dfs(Graph G) {
        Bag<Integer>[] adj = G.getAdj();
        for (int i = 0; i < adj.length; i++) {
            Iterator<Integer> iterator = adj[i].iterator();
            List<Integer> adjacentVertexes = new ArrayList<>();
            while(iterator.hasNext()){
                Integer next = iterator.next();
                adjacentVertexes.add(next);
                G.deleteEdge(next, i); //or make copy of graph
            }

            //if all adjacent vertex are still connected the graph will not be disconnected

            depthFirstSearch = new DepthFirstSearch(G, adjacentVertexes.get(0));

            boolean graphNotDisconnected = true;
            for (int j = 0; j < adjacentVertexes.size(); j++) {
                if (!depthFirstSearch.marked(adjacentVertexes.get(j))) {
                    graphNotDisconnected = false;
                }
            }

            if(graphNotDisconnected){
                notDisconnectedVertexes.add(i);
            }

            for (int j = 0; j < adjacentVertexes.size(); j++) {
                G.addEdge(adjacentVertexes.get(j), i);
            }
        }
    }

    private void resetArray() {
        Arrays.fill(marked, false);
    }

    private boolean allAdjacentVertexesHaveConnections(boolean[] marked, Iterable<Integer> adj) {
        boolean result = true;
        for (int w : adj) {
            if(!hasPathTo(w)){
                result = false;
            }
        }
        return result;
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public List<Integer> getNotDisconnectedVertexes() {
        return notDisconnectedVertexes;
    }
}