package graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class FirstDepthFirstSearch {

	public boolean dfs(HashMap<Integer, ArrayList<Integer>> graph, int src, final int des, boolean[] visited) {
		if (visited[src])
			return false;

		visited[src] = true;

		if (src == des)
			return true;
		
		boolean check = false;
		
		if (graph.containsKey(src)) {
			for (int neighbour : graph.get(src)) {
				if (!visited[neighbour]) {
					check |= dfs(graph, neighbour, des, visited);
				}
			}
		}

		return check;
	}

	public int solve(int[] A, final int des, final int src) {
		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();

		for (int i = 0; i < A.length; ++i) {
			int s = A[i];
			int d = i + 1;

			ArrayList<Integer> neighbour = null;

			neighbour = graph.getOrDefault(s, new ArrayList<Integer>());
			neighbour.add(d);
			graph.put(s, neighbour);

			neighbour = graph.getOrDefault(d, new ArrayList<Integer>());
			neighbour.add(s);
			graph.put(d, neighbour);
		}

		if (!graph.containsKey(src))
			return 0;

		ArrayList<Integer> neighbour = graph.get(src);
		for (int i = 0; i < neighbour.size(); ++i) {
			boolean[] visited = new boolean[A.length + 1];
			int temp = neighbour.get(i);
			neighbour.remove(i);
			boolean check = dfs(graph, src, des, visited);
			if (check)
				return 1;

			neighbour.add(temp);
		}

		return 0;
	}

	public static void main(String[] args) {
		FirstDepthFirstSearch obj = new FirstDepthFirstSearch();
		System.out.println(obj.solve(new int[] {1, 1, 1, 3, 3, 2, 2, 7, 6}, 9, 1));

	}

}
