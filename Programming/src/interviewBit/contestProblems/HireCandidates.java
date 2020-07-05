package interviewBit.contestProblems;

import java.util.Arrays;

public class HireCandidates {

	public int check(int[] arr, int limit, int cost) {
		int hireCost[] = new int[arr.length];
		int need = 0;
		
		for(int i = 0; i < arr.length; ++i) 
			hireCost[i] = arr[i] + (i+1)*limit;
			
		Arrays.sort(hireCost);
		
		for(int i = 0; i < limit; ++i) {
			need += hireCost[i];
			if(need > cost)
				return -1;
		}
		
		return need;
	}

	public int[] solve(int cost, int[] arr) {
		int low = 1, high = arr.length - 1;
		int maxStudent = 0, minCost = 0;

		while (low < high) {
			int mid = low + (high - low) / 2;
			int res = check(arr, mid, cost);
			if (res < 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
				minCost = res;
				maxStudent = mid;
			}
		}

		return new int[] { maxStudent, minCost };
	}

	public static void main(String[] args) {
		int[] arr = {5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8};
		HireCandidates obj = new HireCandidates();
		System.out.println(Arrays.toString(obj.solve(91, arr)));
		
	}

}
