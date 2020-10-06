import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/*
 * link : https://www.codechef.com/OCT20B/problems/POSAND
 * */

/*
 * Calculations:
 * 
 *   
  0 0 1
  0 1 0
  0 1 1
  1 0 0
  1 0 1
  1 1 0
  1 1 1
1 0 0 0
1 0 0 1
1 0 1 0

3 4

8,9,10
4,5,6,7
2,3,6,7
1,3,5,7,9

Permutation: [8,9,10],[4,5,6,7],[2,3],[1]
*/

public class POSAND {
	private static BufferedReader br;

	private static int findBitCount(int n) {
		return (int)(Math.log(n)/Math.log(2)) + 1;
	}
	
	public static ArrayList<Integer> solve(int n) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		HashMap<Integer, HashSet<Integer>> groupMap = new HashMap<Integer, HashSet<Integer>>();
		
		int maxBitCount = findBitCount(n);
		
		for(int i = 0; i < maxBitCount; ++i) {
			HashSet<Integer> group = new HashSet<Integer>();
			for(int x = 1; x <= n; ++x) {
				if((1<<i & x) > 0) {
					group.add(x);
				}
			}
			groupMap.put(i+1, group);
		}
		
		int last = -1;
		HashSet<Integer> globalSet = new HashSet<Integer>();
		
		for(Integer groupIndex : groupMap.keySet()) {
			HashSet<Integer> group = groupMap.get(groupIndex);
			if(last == -1 || group.contains(last)) {
				for(Integer x : group) {
					if(!globalSet.contains(x)) {
						arr.add(x);
						globalSet.add(x);
						last = x;
					}
				}
			}
		}
		
		return arr;
	}
	
	public static void main(String[] args) throws java.lang.Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<Integer> arr = solve(n);
			
			
			if(arr.isEmpty())
				System.out.print(-1);
			else
				for(Integer x : arr)
					System.out.print(x + " ");
			System.out.println();
		}
	}
}
