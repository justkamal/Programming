package Research;

import java.util.Vector;

public class Solution {
	public static void main(String[] args) {
		int A = 3;
		int[][] B = { { 0, 1 }, { 0, 2 }, { 1, 2 } };
		
		Solution sol = new Solution();
		sol.solve(A, B);
	}

	public int solve(int A, int[][] B) {

		Graph g = new Graph(A);
		for (int i = 0; i < B.length; i++) {
			g.addEdge(B[i][0], B[i][1]);
		}
		int ans = g.dfs(0, 0);
		return ans;
	}
}

class Graph {
	int V;
	Vector<Integer>[] adj;
	int[] colour;

	Graph(int V) {
		this.V = V;
		this.adj = new Vector[V];
		for (int i = 0; i < V; i++) {
			this.adj[i] = new Vector<>();
		}
		colour = new int[this.V];
		for (int i = 0; i < V; i++) {
			colour[i] = -1;
		}

	}

	public void addEdge(int a, int b) {
		adj[a].add(b);
		adj[b].add(a);
	}

	int dfs(int a, int curr_color) {
		colour[a] = curr_color;
		if (adj[a] != null) {
			System.out.println(adj[a].toString());
		}

		for (int i = 0; i < adj[a].size(); i++) {
			if (colour[adj[a].get(i)] == curr_color) {
				return 0;
			} else if (colour[adj[a].get(i)] == (1 - curr_color)) {
				continue;
			} else {
				dfs(adj[a].get(i), 1 - curr_color);
			}
		}
		return 1;
	}
}
