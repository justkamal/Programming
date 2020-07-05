package interviewBit.dynamicProgramming;

import java.util.Arrays;

public class FlipArray {
	public int solve(final int[] a) {

		int sum = 0;
		int n = a.length;

		for (int num : a)
			sum += num;

		int[] dp = new int[2 * sum + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);

		dp[2 * sum] = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j <= 2 * sum; ++j) {
				if (dp[j] != Integer.MAX_VALUE) {
					dp[j - 2 * a[i]] = Math.min(dp[j] + 1, dp[j - 2 * a[i]]);
				}
			}
		}

		for (int i = sum; i < 2 * sum + 1; ++i)
			if (dp[i] != Integer.MAX_VALUE)
				return dp[i];

		return 0;
	}
	
	public static void main(String[] args) {
		int[] A = {15, 10, 6};
		FlipArray obj = new FlipArray();
		
		System.out.println(obj.solve(A));
	}
}