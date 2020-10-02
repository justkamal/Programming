package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ScaredRashik {

	public static final long MAX = Integer.MAX_VALUE;

	public int lowerBound(ArrayList<Integer> array, int length, int value) {
		int low = 0;
		int high = length;
		while (low < high) {
			final int mid = (low + high) / 2;
			// checks if the value is less than middle element of the array
			if (value <= array.get(mid)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	public int[] solve(int A, int B, int[] C) {
		ArrayList<Integer> ax = new ArrayList<Integer>(1000);
		ArrayList<Integer> bx = new ArrayList<Integer>(1000);
		ArrayList<Integer> cx = new ArrayList<Integer>(1000);

		for (int i = 0; i < 32; ++i) {
			long x = (long) Math.pow(A, i);
			if (x >= MAX)
				break;
			ax.add((int) x);
			if (A == 1)
				break;
		}

		for (int i = 0; i < 32; ++i) {
			long x = (long) Math.pow(B, i);
			if (x >= MAX)
				break;
			bx.add((int) x);
			if (B == 1)
				break;
		}

		for (int i = 0; i < ax.size(); ++i) {
			for (int j = 0; j < bx.size(); ++j) {
				long sum = (long)ax.get(i) + (long)bx.get(j);
				if(sum < MAX)
					cx.add(ax.get(i) + bx.get(j));
			}
		}
		
		Collections.sort(cx);
		
		int[] res = new int[C.length];
		for (int i = 0; i < C.length; ++i)
			res[i] = lowerBound(cx, cx.size(), C[i]);

		return res;
	}

	public static void main(String[] args) {
		int A = 4, B = 5;
		int[] C = { 6,5 };
		ScaredRashik obj = new ScaredRashik();
		int[] res = obj.solve(A, B, C);
		System.out.println(Arrays.toString(res));
	}
}
