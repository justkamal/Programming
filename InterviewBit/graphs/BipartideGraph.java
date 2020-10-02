package graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class BipartideGraph {

	public boolean isBipartite(HashMap<Integer, ArrayList<Integer>> graph, int src, boolean[] visited, int[] color) {

		for (int neighbour : graph.get(src)) {

			// if vertex u is not explored before
			if (visited[neighbour] == false) {

				// mark present vertex as visited
				visited[neighbour] = true;

				// mark its color opposite to its batch
				color[neighbour] = 1 - color[src];

				// if the subtree rooted at vertex v is not bipartite
				if (!isBipartite(graph, neighbour, visited, color))
					return false;
			}

			// if two adjacent are colored with same color then
			// the graph is not bipartite
			else if (color[neighbour] == color[src])
				return false;
		}
		return true;
	}

	public int solve(int v, int[][] edge) {
		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();

		for (int i = 0; i < edge.length; ++i) {
			int src = edge[i][0];
			int des = edge[i][1];

			ArrayList<Integer> neighbour = null;

			neighbour = graph.getOrDefault(src, new ArrayList<Integer>());
			neighbour.add(des);
			graph.put(src, neighbour);

			neighbour = graph.getOrDefault(des, new ArrayList<Integer>());
			neighbour.add(src);
			graph.put(des, neighbour);
		}

		boolean[] visited = new boolean[v];
		int[] color = new int[v];
		boolean ans = true;

		for (Integer src : graph.keySet()) {
			ans &= isBipartite(graph, src, visited, color);
			if (!ans)
				return 0;
		}

		return ans ? 1 : 0;
	}

	public static void main(String[] args) {
		BipartideGraph obj = new BipartideGraph();
		int[][] edge = { { 7, 8 }, { 1, 2 }, { 0, 9 }, { 1, 3 }, { 6, 7 }, { 0, 3 }, { 2, 5 }, { 3, 8 }, { 4, 8 } };
		System.out.println(obj.solve(10, edge));
	}

}
