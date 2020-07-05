package interviewBit.dynamicProgramming;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class ValuableNodes {

	private HashMap<Integer, ArrayList<Integer>> tree, greatGrandChildren;

	public int computeMaxSum(int[] value, int root) {

		int ans1 = value[root-1], ans2 = 0;
		if(tree.containsKey(root)) {
			ArrayList<Integer> ggChildren = greatGrandChildren.get(root);
			ArrayList<Integer> children = tree.get(root);

			if(ggChildren != null){
				for(Integer ggChild : ggChildren)
					ans1 += computeMaxSum(value, ggChild);
			}
			for(Integer child : children)
				ans2 += computeMaxSum(value, child);
		}
		int ans = Math.max(ans1, ans2);

		return ans;
	}

	public int solve(int[] t, int[] value) {
		tree = new HashMap<Integer, ArrayList<Integer>>();
		greatGrandChildren = new HashMap<Integer, ArrayList<Integer>>();

		for(int i = 1; i < t.length; ++i) {
			int src = t[i];
			int des = i + 1;
			
			ArrayList<Integer> children = tree.getOrDefault(src, new ArrayList<Integer>());
			children.add(des);

			tree.put(src, children);
		}

		for(Integer root : tree.keySet()){
			ArrayList<Integer> children = tree.get(root);
			for(Integer child : children) {
				if (tree.containsKey(child)) {
					ArrayList<Integer> grandChildren = tree.get(child);
					for (Integer grandChild : grandChildren) {
						if (tree.containsKey(grandChild)) {
							ArrayList<Integer> ggChildren = tree.get(grandChild);
							ArrayList<Integer> existing = greatGrandChildren.getOrDefault(root, new ArrayList<Integer>());
							existing.addAll(ggChildren);
							greatGrandChildren.put(root, existing);
						}
					}
				}
			}
		}
		System.out.println(tree);
		for(Integer root : tree.keySet()){
			System.out.print(value[root-1] + "->[");
			for(Integer child : tree.get(root))
				System.out.print(value[child-1] + " ");
			System.out.println("]");
		}
		System.out.println(greatGrandChildren);
		return computeMaxSum(value, 1);
	}
	
	public static void main(String[] args) {
		ValuableNodes obj = new ValuableNodes();
		int[] t = {0, 1, 1, 1, 3, 3, 6, 6};
		int[] b = {90, 2, 100, 4, 5, 6, 7, 8};
		System.out.println(obj.solve(t,b));

	}

}