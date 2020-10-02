package trees;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class WeightCollection {
	    
    private static final int MOD = (int)1e9 + 7;
    
    public long dfs(HashMap<Integer, ArrayList<Integer>> tree, int root, int[] value, int k, long maxW){
    	if(k == 0)
    		return 0;
  
    	long ans = 0;
    	
    	if(tree.containsKey(root)) {
    		for(int child : tree.get(root)) {
        		int weight = Math.abs(value[root-1] - value[child-1])%MOD;
    			ans = Math.max(ans, weight + dfs(tree, child, value, k - 1, Math.max(weight, maxW)));
    			ans %= MOD;
        	}
    	} else {
    		return (k*maxW)%MOD;
    	}
    	
    	return ans%MOD;
    }
    
    public int solve(int k, int[] tree, int[] value) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();
        
        for(int i = 0; i < tree.length; ++i){
            int parent = tree[i];
            int child = i + 1;
            
            ArrayList<Integer> neighbour = adj.getOrDefault(parent, new ArrayList<Integer>());
            neighbour.add(child);
            adj.put(parent, neighbour);
        }
        
        long ans = dfs(adj, tree[1], value, k, 0);
        
        return (int)(ans%MOD);
    }
    
	public static void main(String args[]) throws IOException {
		WeightCollection obj = new WeightCollection();
		int[] tree = {0, 1, 1, 2, 2, 3};
		int[] v = {1, 6, 7, 21, 5, 18};
		int k = 3;
		long ans = obj.solve(k, tree, v);
		System.out.println(ans);
	}
}
