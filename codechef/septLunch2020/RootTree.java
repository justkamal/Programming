package septLunch2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class RootTree {
	private static BufferedReader br;
	private static StringTokenizer strz;

	public static int computeCount(HashMap<Integer, ArrayList<Integer>> graph, HashMap<Integer, Integer> countMap,
			int root) {
		if (!graph.containsKey(root))
			return 0;
		if (countMap.containsKey(root))
			return countMap.get(root);

		int count = 0;
		for (int child : graph.get(root))
			count += 1 + computeCount(graph, countMap, child);

		countMap.put(root, count);
		return countMap.get(root);
	}

	public static void main(String[] args) throws java.lang.Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
			for (int i = 0; i < n - 1; ++i) {
				strz = new StringTokenizer(br.readLine());
				int src = Integer.parseInt(strz.nextToken());
				int des = Integer.parseInt(strz.nextToken());

				ArrayList<Integer> child = graph.getOrDefault(src, new ArrayList<Integer>());
				child.add(des);
				graph.put(src, child);
			}
			HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();

			for (int node : graph.keySet())
				computeCount(graph, countMap, node);

			int min = n-1;
			for (int node : countMap.keySet())
				min = Math.min(min, (n-1) - countMap.get(node));

			System.out.println(min);
		}
	}
}
