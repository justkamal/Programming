package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    private static Graph graph = new Graph(5, false);

    public static void main(String[] args) {
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        /*graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 5);
        graph.addEdge(4, 6);*/
        graph.addEdge(3, 5);
        System.out.println("BFS");
        bfs(1, graph.getList());
        System.out.println("DFS");
        dfs(1, graph.getList());
    }

    public static void bfs(int src, ArrayList<ArrayList<Integer>> adjList) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited.add(src);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            queue.addAll(adjList.get(node).stream().filter(neighbour -> !visited.contains(neighbour)).toList());
            visited.addAll(adjList.get(node));
            System.out.println(node);
        }
    }

    public static void dfs(int src, ArrayList<ArrayList<Integer>> adjList){
        HashSet<Integer> visited = new HashSet<>();
        visited.add(src);
        System.out.println(src);
        doDfs(src, adjList, visited);
    }

    private static void doDfs(int src, ArrayList<ArrayList<Integer>> adjList, HashSet<Integer> visited) {
        adjList.get(src).forEach(neighbour -> {
            if (!visited.contains(neighbour)) {
                visited.add(neighbour);
                System.out.println(neighbour);
                doDfs(neighbour, adjList, visited);
            }
        });
    }
}