package four.one;

import java.util.HashSet;
import java.util.Set;

// TODO create unit tests for this class.
public class Search_UF {
    private Set<Integer> bags;
    private int count;

    public Search_UF(Graph_UF graph_uf, int s) {
        bags = new HashSet<>();
        int v = graph_uf.find(s);
        int[] id = graph_uf.getId();
        for (int i = 0; i < id.length; i++) {
            if(id[i] == v){
                bags.add(i);
                count++;
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

    public Set<Integer> getBags() {
        return bags;
    }

    public int getCount() {
        return count;
    }
}
