import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		int[] coin = { 10, 15, 20, 5 };
		int sum = 30;
		System.out.println(minCoinCount(coin, sum));
		System.out.println(numWays(coin, sum));
	}
	
	// minimum number of coins needed to form the given sum through given set of coins
	public static int minCoinCount(int[] coin, int sum) {

		int[] dp = new int[sum + 1];

		Arrays.fill(dp, Integer.MAX_VALUE);

		dp[0] = 1; // base case

		for (int i = 1; i <= sum; ++i) {
			for (int j = 0; j < coin.length; ++j) {
				if (coin[j] <= i && dp[i - coin[j]] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], 1 + dp[i - coin[j]]);
				}
			}
		}

		return dp[sum];
	}

	// number of ways in which we can form the given sum through given set of coins
	public static int numWays(int[] coin, int sum) {
		int[] dp = new int[sum + 1];
		
		dp[0] = 1; // base case

		for (int c = 0; c < coin.length; ++c) {
			for (int s = coin[c]; s <= sum; ++s) {
				dp[s] += dp[s - coin[c]];
			}
		}

		return dp[sum];
	}
}