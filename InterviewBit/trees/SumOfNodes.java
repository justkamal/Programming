package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SumOfNodes {
	
	int[] ans, count;
    List<Set<Integer>> graph;
    int N;
    
    public int[] solve(int[][] edges) {
        this.N = edges.length + 1;
        graph = new ArrayList<Set<Integer>>();
        ans = new int[N];
        count = new int[N];
        Arrays.fill(count, 1);

        for (int i = 0; i < N; ++i)
            graph.add(new HashSet<Integer>());
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return ans;
    }

    public void dfs(int node, int parent) {
        for (int child: graph.get(node))
            if (child != parent) {
                dfs(child, node);
                count[node] += count[child];
                ans[node] += ans[child] + count[child];
            }
    }

    public void dfs2(int node, int parent) {
        for (int child: graph.get(node))
            if (child != parent) {
                ans[child] = ans[node] + N - 2*count[child];
                dfs2(child, node);
            }
    }
	
	public static void main(String[] args){
		int[][] arr = {{3, 1}, {2, 1}, {0, 2}, {3, 4}};
		SumOfNodes obj = new SumOfNodes();
		obj.solve(arr);
	}
}
