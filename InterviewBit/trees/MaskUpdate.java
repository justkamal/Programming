package trees;

import java.util.ArrayList;

public class MaskUpdate {

	public int rangeQuery(int[] tree, int root, int L, int R, int start, int end) {
		if (root > tree.length || L > R)
			return 0;

		if (L == start && R == end) 
			return tree[root];
		
		int mid = (start + end) / 2;

		return rangeQuery(tree, 2 * root + 1, L, Math.min(R, mid), start, mid)
				+ rangeQuery(tree, 2 * root + 2, Math.max(L, mid + 1), R, mid + 1, end);
	}

	public int updateQuery(int[] tree, int root, int L, int R, int start, int end) {
 		if (root > tree.length || L > R)
			return 0;

		if (L == R) {
			tree[root] ^= 1;	//leaf node
		} else {
			int mid = (start + end) / 2;
			int left = updateQuery(tree, 2 * root + 1, L, Math.min(R, mid), start, mid);
			int right = updateQuery(tree, 2 * root + 2, Math.max(L, mid + 1), R, mid + 1, end);
			tree[root] = left + right;
		}

		return tree[root];
	}

	public int solve(int n, ArrayList<ArrayList<Integer>> query) {
		int res = 0;

		int[] tree = new int[4 * n];
		
		for (ArrayList<Integer> q : query) {
			if (q.get(0) == 0) {
				updateQuery(tree, 0, q.get(1), q.get(2), 0, n - 1);
			} else {
				res += rangeQuery(tree, 0, q.get(1), q.get(2), 0, n - 1);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int n = 7;
		int[][] arr = { { 0, 3, 5 }, { 0, 0, 5 }, { 0, 0, 6 }, { 1, 6, 6 }, { 1, 1, 6 } };

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		for (int[] x : arr) {
			ArrayList<Integer> newList = new ArrayList<Integer>();
			for (int y : x)
				newList.add(y);
			list.add(newList);
		}

		MaskUpdate obj = new MaskUpdate();

		System.out.println(obj.solve(n, list));
	}

}