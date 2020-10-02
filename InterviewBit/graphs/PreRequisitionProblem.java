package graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class PreRequisitionProblem {

	public boolean cycleDetect(HashMap<Integer, ArrayList<Integer>> adj, int src, boolean[] visited,
			boolean[] recStack) {
		if(recStack[src])
			return true;
		
		if(visited[src])
			return false;
		
		visited[src] = true;
		recStack[src] = true;
		
		if(adj.containsKey(src)) {
			for(int neighbour : adj.get(src)) {
				if(cycleDetect(adj, neighbour, visited, recStack))
					return true;
			}
		}
		
		recStack[src] = false;
		
		return false;
	}

	public int solve(int n, int[] u, int[] v) {
		HashMap<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();

		for (int i = 0; i < u.length; ++i) {
			ArrayList<Integer> neighbour = adj.getOrDefault(u[i], new ArrayList<Integer>());
			neighbour.add(v[i]);
			adj.put(u[i], neighbour);
		}

		boolean[] visited = new boolean[n + 1];
		boolean[] recStack = new boolean[n + 1];

		for (int src : adj.keySet()) {
			if (cycleDetect(adj, src, visited, recStack))
				return 0;
		}

		return 1;
	}

	public static void main(String[] args) {
		int[] u = {1,3,4,5};
		int[] v = {2,1,5,3};
		int n = 5;

		PreRequisitionProblem obj = new PreRequisitionProblem();
		System.out.println(obj.solve(n, u, v));

	}

}
