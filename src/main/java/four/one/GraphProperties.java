package four.one;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphProperties {
    private BreadthFirstPaths breadthFirstPaths;
    private int[] eccentricity;

    public GraphProperties(Graph G) { // constructor (exception if G not connected)
       eccentricity = new int[G.V()];
        for (int i = 0; i < eccentricity.length; i++) {
            breadthFirstPaths = new BreadthFirstPaths(G, i);
            eccentricity[i] = breadthFirstPaths.getMaxDist();
        }
    }

    public int eccentricity(int v) { // eccentricity of v
        return eccentricity[v];
    }

    public int diameter() { // diameter of G
        return NumberUtils.max(eccentricity);
    }

    public int radius() {   // radius of G
        return NumberUtils.min(eccentricity);
    }

    public List<Integer> center() {   // a center of G
        List<Integer> centers = new ArrayList<>();
        for (int i = 0; i < eccentricity.length; i++) {
            if(eccentricity[i] == radius()){
                centers.add(i);
            }
        }
        return centers;
    }

    @Override
    public String toString() {
        return "GraphProperties: " +
                "\nDiameter: " + diameter() +
                "\nRadius:   " + radius() +
                "\nCenter:   " + center();
    }
}
