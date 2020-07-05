package hackerEarth.PaypalChallenge;

import static java.lang.Math.min;

import java.util.Arrays;

public class PaintingBuildings {

	private static final int INFINITY = Integer.MAX_VALUE;
	
	public static long paint(int[][] cost, int buildings, int[] colorCount, int buildingIndex, int colors) {
		if (colors < 0 || colors > buildings - buildingIndex + 1) {
			return INFINITY;
		}

		if (buildingIndex >= buildings)
			return 0;
		
		long res = INFINITY;

		for (int color = 0; color < colorCount.length; ++color) {
			
			if (colorCount[color] == 0)
				--colors;
			colorCount[color]++;

			res = min(res, cost[buildingIndex][color] + paint(cost, buildings, colorCount, buildingIndex + 1, colors));	
			
			if (colorCount[color] == 1)
				++colors;
			if (colorCount[color] > 0)
				--colorCount[color];
		}

		return res;
	}

	public static long minCost(int[][] cost, int K) {
		int N = cost.length;
		int M = cost[0].length;

		if (K > M)
			return -1;

		long[][][] dp = new long[N + 1][K + 1][M + 1];		
		
		for (int col = 1; col <= M; ++col)
			dp[1][1][col] = cost[0][col - 1];

		for (int house_idx = 1; house_idx <= N; ++house_idx) {
			for (int partition = 1; partition <= K; ++partition) {
				for (int color = 1; color <= M; ++color) {
					long minCost = Long.MAX_VALUE;
					for (int c = 1; c <= M; ++c) {
						if (c == color)
							continue;
						minCost = min(minCost,
									dp[house_idx - 1][partition - 1][c] + cost[house_idx - 1][c - 1]);
					}
					dp[house_idx][partition][color] = min(minCost,
							dp[house_idx - 1][partition][color] + cost[house_idx - 1][color - 1]);
				}
			}

		}

		long ans = Long.MAX_VALUE;

		System.out.println(Arrays.toString(dp[N][K]));

		for (int col = 1; col <= M; ++col)
			ans = min(ans, dp[N][K][col]);

		return ans;
	}

	public static void main(String[] args) {
		int[][] cost = { { 100, 20, 10 }, { 30, 50, 40 }, { 71, 81, 50 } };
		int k = 2;
		int m = cost[0].length;
		int[] colorCount = new int[m];
		
		/*
		 * int[] config = new int[cost.length]; Arrays.fill(config, -1);
		 */
		/*
		 * long ans = paint(cost, cost.length, colorCount, 0, k);
		 * System.out.println(ans);
		 */

		System.out.println(minCost(cost, k));
	}
}