package codeforces.contest_633;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class LinovaKingdom {

	private static BufferedReader br;
	private static StringTokenizer strz;

	public static int dfs(HashMap<Integer, ArrayList<Integer>> tree, int root, int dist, int[] depth, int[] childCount,
			boolean[] visited) {
		
		if (visited[root])
			return 0;
		visited[root] = true;
		depth[root] = dist;
		int nChild = 0;

		for (int child : tree.get(root)) {
			if (!visited[child])
				nChild += dfs(tree, child, dist + 1, depth, childCount, visited);
		}
		childCount[root] = nChild;
		return 1 + nChild;
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		strz = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(strz.nextToken());
		int k = Integer.parseInt(strz.nextToken());

		HashMap<Integer, ArrayList<Integer>> tree = new HashMap<Integer, ArrayList<Integer>>();

		for (int i = 0; i < n - 1; ++i) {
			strz = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(strz.nextToken()) - 1;
			int des = Integer.parseInt(strz.nextToken()) - 1;

			ArrayList<Integer> neighbour = null;

			neighbour = tree.getOrDefault(src, new ArrayList<Integer>());
			neighbour.add(des);
			tree.put(src, neighbour);

			neighbour = tree.getOrDefault(des, new ArrayList<Integer>());
			neighbour.add(src);
			tree.put(des, neighbour);
		}
		
		boolean[] visited = new boolean[n];
		int[] childCount = new int[n];
		int[] depth = new int[n];
		Integer[] cost = new Integer[n];
		
		dfs(tree, 0 , 0, depth, childCount, visited);
		
		for(int node = 0; node < n; ++node)
			cost[node] = depth[node] - childCount[node];
		
		Arrays.sort(cost, Collections.reverseOrder());
		long maxSum = 0;

		for (int i = 0; i < k; ++i)
			maxSum += cost[i];

		System.out.println(maxSum);
	}

}