package dynamicProgramming;

import java.util.Vector;

public class OddPalindrome {

//Function to find the total palindromic 
//odd length sub-sequences 
	static void solve(char[] s) {
		int n = s.length;

		int[][] dp = new int[n][n];
		for (int len = n - 1; len >= 0; --len) {
			for (int i = 0; i + len < n; ++i) {
				int j = i + len;
				if (i == 0 && j == n - 1) {
					if (s[i] == s[j])
						dp[i][j] = 2;
					else if (s[i] != s[j])
						dp[i][j] = 1;
				} else {
					if (s[i] == s[j]) {
						if (i - 1 >= 0) {
							dp[i][j] += dp[i - 1][j];
						}
						if (j + 1 <= n - 1) {
							dp[i][j] += dp[i][j + 1];
						}
						if (i - 1 < 0 || j + 1 >= n) {
							dp[i][j] += 1;
						}
					} else if (s[i] != s[j]) {
						if (i - 1 >= 0) {
							dp[i][j] += dp[i - 1][j];
						}
						if (j + 1 <= n - 1) {
							dp[i][j] += dp[i][j + 1];
						}
						if (i - 1 >= 0 && j + 1 <= n - 1) {
							dp[i][j] -= dp[i - 1][j + 1];
						}
					}
				}
			}
		}

		Vector<Integer> ways = new Vector<>();
		for (int i = 0; i < n; ++i) {
			if (i == 0 || i == n - 1) {
				ways.add(1);
			} else {
				int total = dp[i - 1][i + 1];
				ways.add(total);
			}
		}
		for (int i = 0; i < ways.size(); ++i) {
			System.out.print(ways.get(i) + " ");
		}
	}
	public static void main(String[] args) {
		char[] s = "xyxyx".toCharArray();
		solve(s);
		solve("xyzx".toCharArray());
	}
}