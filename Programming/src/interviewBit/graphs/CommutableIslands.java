package interviewBit.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CommutableIslands {
	
	class Edge{
		int src, des, weight;
		
		public Edge(int src, int des, int weight) {
			this.src = src;
			this.des = des;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "(" + src + ", " + des + ", " + weight + ")";
		}
		
		
	}
	
	int[] parent;
	
	public int findCluster(int node) {
		if(parent[node] == node)
			return node;
		int root = findCluster(parent[node]);
		parent[node] = root;
		return root;
	}
	
	public boolean union(int src, int des) {
		int clusterId1 = findCluster(src);
		int clusterId2 = findCluster(des);
		if(clusterId1 != clusterId2) {
			parent[clusterId2] = clusterId1;
			return true;
		}else {
			return false;
		}
	}	
	
	public int computeMinCost(ArrayList<Edge> edgeList) {
		int minCost = 0;
			
		for(Edge edge : edgeList) {
			if(union(edge.src, edge.des))
				minCost += edge.weight;
		}
		
		return minCost;
	}
	
	public int solve(int v, int[][] edge) {
		ArrayList<Edge> edgeList = new ArrayList<Edge>();
		
		parent = new int[v];
		for(int i = 0; i < v; ++i)
			parent[i] = i;
		
		for(int i = 0; i < edge.length; ++i) {
			int src = edge[i][0]-1;
			int des = edge[i][1]-1;
			int weight = edge[i][2];
			
			edgeList.add(new Edge(src, des, weight));
		}
		
		Collections.sort(edgeList, new Comparator<Edge>() {
			@Override
			public int compare(Edge e1, Edge e2) {
				return e1.weight - e2.weight;
			}
			
		});
		
		return computeMinCost(edgeList);
    }
	
	public static void main(String[] args) {
		CommutableIslands obj = new CommutableIslands();
		int v = 3;
		int[][] edge = {
						  {1, 2, 10},
						  {2, 3, 5},
						  {1, 3, 9},
						};
		System.out.println(obj.solve(v, edge));
	}

}