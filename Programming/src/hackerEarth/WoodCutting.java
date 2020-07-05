package hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WoodCutting {

	private static BufferedReader br;
	private static StringTokenizer strz;
	
	public static int makeCut(int[] arr, int x, int y, int start, int end) {
		if(end - start < 2)
			return 0;
		
		int minCost = Integer.MAX_VALUE;
		
		for(int i = start + 1; i < end-1; ++i) {
			int cost = x*(arr[i] - arr[start]) + y*(arr[end] - arr[i]);
			minCost = Math.min(minCost, makeCut(arr, x, y, start, i-1) + makeCut(arr, x, y, i + 1, end) + cost);
		}
		
		return minCost;
	}
	
	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			strz = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(strz.nextToken());
			int y = Integer.parseInt(strz.nextToken());

			int n = Integer.parseInt(br.readLine());
			strz = new StringTokenizer(br.readLine());

			int[] arr = new int[n];
			for (int i = 0; strz.hasMoreTokens(); ++i)
				arr[i] = Integer.parseInt(strz.nextToken());

			int[][] dp = new int[n + 1][n + 1];

			for (int i = 1; i < n-1 ; i++) {
				for (int j = 1; j < n-i; j++) {
					int s = i + j + 1;
					dp[j][s] = Integer.MAX_VALUE;
					for (int k = j + 1; k < s; k++) {
						dp[j][s] = Math.min(dp[j][s], dp[j][k] + dp[k][s] + (arr[k-1] - arr[j-1]) * x + (arr[s-1] - arr[k-1]) * y);
					}
				}
			}
			System.out.println(dp[1][n]);
			System.out.println(makeCut(arr, x, y, 0, arr.length-1));
		}
	}
}
