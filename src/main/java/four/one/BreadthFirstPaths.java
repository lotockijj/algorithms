package four.one;

import edu.princeton.cs.algs4.Queue;

import java.util.Stack;

public class BreadthFirstPaths{
    private boolean[] marked; // Is a shortest path to this vertex known?
    private int[] edgeTo; // last vertex on known path to this vertex
    private final int s; // source
    private final int[] distTo;

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    public BreadthFirstPaths(Graph G, int s, boolean stackInsteadOfQueue) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        this.s = s;
        bfsUsingStack(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new Queue<Integer>();
        marked[s] = true; // Mark the source
        queue.enqueue(s); // and put it on the queue.
        while (!queue.isEmpty()){
            int v = queue.dequeue(); // Remove next vertex from the queue.
            for (int w : G.adj(v))
                if (!marked[w]) // For every unmarked adjacent vertex,
                {
                    edgeTo[w] = v; // save last edge on a shortest path,
                    marked[w] = true; // mark it because path is known,
                    queue.enqueue(w); // and add it to the queue.
                    distTo[w] = distTo[v] + 1;
                }
        }
    }

    private void bfsUsingStack(Graph G, int s) {
        Stack<Integer> stack = new Stack<>();
        marked[s] = true; // Mark the source
        stack.push(s); // and put it on the queue.
        while (!stack.isEmpty()){
            int v = stack.pop(); // Remove next vertex from the queue.
            for (int w : G.adj(v))
                if (!marked[w]) // For every unmarked adjacent vertex,
                {
                    edgeTo[w] = v; // save last edge on a shortest path,
                    marked[w] = true; // mark it because path is known,
                    stack.push(w); // and add it to the queue.
                    distTo[w] = distTo[v] + 1;
                } else {
                    if(distTo[v] > distTo(w) + 1){
                        distTo[v] = distTo[w] + 1;
                    }
                }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

    public int distTo(int v){
        return distTo[v];
    }


}