package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycle {
    public static void main(String[] args) {
        DetectCycle mainObj = new DetectCycle();

    }

    class Node {
        public int x, parent;

        public Node(int x, int parent) {
            this.x = x;
            this.parent = parent;
        }
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; ++i) {
            if (!visited[i]) {
                if (detectCycle(V, adj, i, visited))
                    return true;
            }
        }
        return false;
    }

    public boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(src, -1));
        visited[src] = true;

        while (!queue.isEmpty()){
            Node node = queue.poll();
            for (int neighbour : adj.get(node.x)){
                if (!visited[neighbour]){
                    queue.add(new Node(neighbour, node.x));
                    visited[neighbour] = true;
                } else if (node.parent != neighbour){
                    return true;
                }
            }
        }
        return false;
    }
}
