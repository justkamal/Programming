import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MaxTokenProfit {

    static class Graph {
        int v;                                                  //no of vertices
        ArrayList<ArrayList<HashMap<Integer, Integer>>> adj;    //adjacency list

        // Constructor
        Graph(int v) {
            this.v = v;
            this.adj = new ArrayList<>();

            for (int i = 0; i < v; i++) {
                this.adj.add(new ArrayList<>());
            }
        }

        // Function to add an edge into the graph
        void addEdge(int u, int v, int weight) {
            this.adj.get(u).add(new HashMap<>());
            this.adj.get(u)
                    .get(this.adj.get(u).size() - 1)
                    .put(v, weight);

            this.adj.get(v).add(new HashMap<>());
            this.adj.get(v)
                    .get(this.adj.get(v).size() - 1)
                    .put(u, weight);
        }
    }

    private static StringTokenizer strTkn;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = br.read();
        Graph pathMatrix = new Graph(n);
        readInput(br, n, pathMatrix);

        int nT = br.read();                     //no of tokens
        Graph tokenMatrix = new Graph(n);
        readInput(br, nT, tokenMatrix);

        System.out.println(computeMaxProfit(pathMatrix, tokenMatrix));
    }

    private static void readInput(BufferedReader br, int n, Graph adjList) throws IOException {
        for (int i = 0; i < n - 1; ++i) {
            strTkn = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(strTkn.nextToken());
            int dest = Integer.parseInt(strTkn.nextToken());
            int cost = Integer.parseInt(strTkn.nextToken());
            adjList.addEdge(src, dest, cost);
        }
    }

    /**
     * @Approach: do bfs to form all possible paths from every node to every node
     * form string by concatenating all the nodes which are part of the path
     * if every character in string to every other character forms a useful token, add token cost to pathTokenSum
     * also separately compute path length of every character to every character in string and add to pathLength
     * of all the strings, whichever combination gives maxProfit out of pathTokenSum - pathLength, save that profit
     * output the max found profit
     */
    private static int computeMaxProfit(Graph adjList, Graph tokenCost) {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder path = new StringBuilder();
        HashSet<Integer> visited = new HashSet<>();

        queue.add(1);
        visited.add(1);

        while (!queue.isEmpty()) {
            int source = queue.poll();
            path.append(source);

            //add neighbours
            if (!adjList.adj.get(source).isEmpty()) {
                adjList.adj.get(source).forEach(map -> {
                    map.keySet().forEach(neighbour -> {
                        if (!visited.contains(neighbour)){

                        }
                    });
                });
            }
        }

        return 0;
    }
}
