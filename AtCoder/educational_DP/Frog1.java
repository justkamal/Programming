package educational_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Frog1{
	
	private static BufferedReader br;
	private static StringTokenizer strz;
	
	public static int compute(int[] arr) {
		int n = arr.length;
		int[]dp = new int[n];
		
		for(int i = 0; i < n - 2; ++i) {
			dp[i] = Math.min(dp[i] + Math.abs(arr[i] - arr[i+1]), dp[i] + Math.abs(arr[i] - arr[i+2]));
		}
		
		return dp[0];
	}
	
	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr=  new int[n];
		
		strz = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i)
			arr[i] = Integer.parseInt(strz.nextToken());
		
		int res = compute(arr);
		System.out.println(res);
	}
}
