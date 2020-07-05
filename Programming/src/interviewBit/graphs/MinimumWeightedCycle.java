package interviewBit.graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class MinimumWeightedCycle {

	public static class Pair {
		int des, wt;

		Pair(int x, int wt) {
			this.des = x;
			this.wt = wt;
		}
	}

	public int solve(int nV, int[][] edge) {
		int minWeightCycle = Integer.MAX_VALUE;

		HashMap<Integer, ArrayList<Pair>> graph = new HashMap<>();

		for (int i = 0; i < edge.length; i++) {

			if (edge[i][0] != edge[i][1]) {
				ArrayList<Pair> curr = graph.getOrDefault(edge[i][0], new ArrayList<>());
				curr.add(new Pair(edge[i][1], edge[i][2]));
				graph.put(edge[i][0], curr);

				curr = graph.getOrDefault(edge[i][1], new ArrayList<>());
				curr.add(new Pair(edge[i][0], edge[i][2]));
				graph.put(edge[i][1], curr);
			} else { // self loops
				minWeightCycle = Math.min(edge[i][2], minWeightCycle);
			}
		}
		PriorityQueue<Pair> pQueue = new PriorityQueue<Pair>(new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				return p1.wt - p2.wt;
			}
		});

		for (int u = 1; u <= nV; u++) {
			boolean[] visited = new boolean[nV + 1];
			pQueue.clear();
			pQueue.add(new Pair(u, 0));
			if (graph.containsKey(u)) { // if there is self loop then the hashmap won't contain that key
				ArrayList<Pair> neighbours = new ArrayList<>();
				neighbours.addAll(graph.get(u));
				// we iterate through all the neighbours of the current node and remove the edge
				// between them and check find
				// the shortest path between them,if a cycle is present then there will be a way
				// to reach from u->v.
				for (Pair neighbour : neighbours) {

					// removing current edge
					Pair v = neighbour;
					ArrayList<Pair> neighbours1 = graph.get(u);
					neighbours1.remove(v);
					graph.put(u, neighbours1);

					// finding the shortest path using dijkstra to reach u->v when the edge between
					// u->v is removed
					while (!pQueue.isEmpty()) {
						Pair curr = pQueue.remove();
						// System.out.println(curr.x+" "+curr.wt);

						// a cycle exists ,v found
						if (curr.des == v.des) {
							minWeightCycle = Math.min(minWeightCycle, curr.wt + v.wt);
							break;
						}
						visited[curr.des] = true;
						if (graph.containsKey(curr.des)) {
							ArrayList<Pair> children = graph.get(curr.des);
							for (Pair child : children) {
								if (!visited[child.des]) {
									pQueue.add(new Pair(child.des, curr.wt + child.wt));
									// System.out.println(curr.x+" -> "+child.x);
								}
							}
						}
					}

					// adding the edge u->v back to the graph to check paths for other v's
					neighbours1.add(v);
					graph.put(u, neighbours1);
				}
			}
		}
		return minWeightCycle;

	}

	public static void main(String[] args) {
		int[][] edge = { { 1, 2, 1 }, { 1, 5, 2 }, { 5, 4, 3 }, { 4, 3, 1 }, { 3, 2, 5 }, { 2, 5, 8 }, { 5, 3, 6 }, };
		MinimumWeightedCycle obj = new MinimumWeightedCycle();
		System.out.println(obj.solve(5, edge));
	}
}