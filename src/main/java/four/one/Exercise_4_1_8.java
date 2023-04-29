package four.one;

/*Develop an implementation for the Search API on page 528 that uses UF, as described in the text. */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// TODO add all test .txt files to resources folder .
public class Exercise_4_1_8 {

    public static void main(String[] args) throws FileNotFoundException { // Solve dynamic connectivity problem on StdIn.
        File file = new File("tinyG.txt");
        Scanner sc=new Scanner(file);
        int N = sc.nextInt();
        int skipBecauseForUF = sc.nextInt();
        Graph_UF graph_uf = new Graph_UF(N); // Initialize N components.
        while (sc.hasNext()) {
            int p = sc.nextInt();
            int q = sc.nextInt(); // Read pair to connect.
            if (graph_uf.connected(p, q)) continue; // Ignore if connected.
            graph_uf.union(p, q); // Combine components
            //StdOut.println(p + " " + q); // and print connection.
        }
        //StdOut.println(graph_uf.count() + " components");
        if(sc != null){
            sc.close();
        }

        Search_UF search_uf = new Search_UF(graph_uf, 0);
        System.out.println("Count should be 7: " + search_uf.getCount());
        search_uf.getBags().forEach(e -> System.out.print(e + " "));
    }
}
