package interviewBit.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Dijktras {

	static class Pair {
		int node, weight;

		public Pair(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "[node=" + node + ", weight=" + weight + "]";
		}

	}

	public int[] solve(int n, int[][] edge, int src) {
		HashMap<Integer, ArrayList<Pair>> graph = new HashMap<Integer, ArrayList<Pair>>();
		PriorityQueue<Pair> pQueue = new PriorityQueue<Pair>(new Comparator<Pair>() {
			@Override
			public int compare(Pair edge1, Pair edge2) {
				return edge1.weight - edge2.weight;
			}
		});

		for (int i = 0; i < edge.length; ++i) {
			int u = edge[i][0];
			int v = edge[i][1];
			int weight = edge[i][2];

			Pair pair = new Pair(v, weight);
			ArrayList<Pair> list = graph.getOrDefault(u, new ArrayList<Pair>());
			list.add(pair);
			graph.put(u, list);

			pair = new Pair(u, weight);
			list = graph.getOrDefault(v, new ArrayList<Pair>());
			list.add(pair);
			graph.put(v, list);
		}

		int[] dist = new int[n];
		Arrays.fill(dist, -1);
		dist[src] = 0;

		pQueue.add(new Pair(src, 0));

		/*
		 * Personal note : No concept of visited, need to relax all edge till they keep yielding min path
		 * */
		
		while (!pQueue.isEmpty()) {
			Pair source = pQueue.poll();

			if (graph.containsKey(source.node)) {
				for (Pair neighbour : graph.get(source.node)) {
					int d = dist[source.node] + neighbour.weight;
					if (d < dist[neighbour.node] || dist[neighbour.node] == -1) {
						pQueue.add(neighbour);
						dist[neighbour.node] = d;
					}
				}
			}
		}

		return dist;
	}

	public static void main(String[] args) {
		Dijktras obj = new Dijktras();
		int n = 6;
		int[][] edge = { { 0, 2, 4 }, { 0, 5, 10 }, { 1, 2, 6 }, { 1, 5, 8 }, { 2, 3, 10 }, { 2, 4, 8 }, { 3, 4, 5 },
				{ 4, 5, 3 } };
		int src = 1;
		System.out.println(Arrays.toString(obj.solve(n, edge, src)));
	}
}