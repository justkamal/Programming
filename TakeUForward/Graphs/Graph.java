package Graphs;

import java.util.ArrayList;

public class Graph {
    private ArrayList<ArrayList<Integer>> adjList;
    private boolean isDirected;

    public Graph(int size, boolean isDirected){
        adjList = new ArrayList<>(size+1);
        for (int i = 1; i <= size+1; ++i)
            adjList.add(new ArrayList<>());
        this.isDirected = isDirected;
    }

    public void addEdge(int src, int dest){
        adjList.get(src).add(dest);
        if (!isDirected)
            adjList.get(dest).add(src);
    }

    public ArrayList<ArrayList<Integer>> getList(){
        return adjList;
    }
}
