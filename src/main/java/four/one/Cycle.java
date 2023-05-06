package four.one;

import java.util.Arrays;

public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;
    private int lenOfCycle;
    private int[] cycles;

    public Cycle(Graph G){
        marked = new boolean[G.V()];
        cycles = new int[G.V()];
        for (int s = 0; s < G.V(); s++) {
            lenOfCycle = 0;
            if (!marked[s])
                dfs(G, s, s);
        }
    }

    private void dfs(Graph G, int v, int u){
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                lenOfCycle++;
                dfs(G, w, v);
            } else if (w != u) {
                hasCycle = true;
                cycles[u] = lenOfCycle;
                lenOfCycle = 0;
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    public int getGirth() {
        return Arrays.stream(cycles).filter(e -> e != 0).min().orElse(-1);
    }
}
