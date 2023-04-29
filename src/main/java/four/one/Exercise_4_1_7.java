package four.one;

//Develop a test client for Graph that reads a graph from the input stream named
//as command-line argument and then prints it, relying on toString().

public class Exercise_4_1_7 {
    private final static String TEST_STRING = "6,4,0-1,1-2,1-3,1-4,5-5";

    public static void main(String[] args) {
        String[] splittedTestString = TEST_STRING.split(",");
        Graph G = new Graph(Integer.parseInt(splittedTestString[0]));
        for (int i = 2; i < splittedTestString.length; i++) {
            int v = Integer.parseInt(splittedTestString[i].split("-")[0]);
            int w = Integer.parseInt(splittedTestString[i].split("-")[1]);
            G.addEdge(v, w);
        }
        System.out.println(G);
    }
}
