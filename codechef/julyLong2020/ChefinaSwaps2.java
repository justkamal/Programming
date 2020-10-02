package julyLong2020;

import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ChefinaSwaps2 {
	
	private static BufferedReader br;
	private static StringTokenizer strz;
	
	public static long solve(long[] a, long[] b, int n) {
		long minCost = 0;
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		for(int i = 0; i < n; ++i) {
			if(a[i] != b[i]) {
				long temp = a[i];
				a[i] = b[i];
				b[i] = temp;
				minCost += min(a[i], b[i]);
			}
		}
		
		return minCost;
	}
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			long[] a = new long[n];
			long[] b = new long[n];
			
			strz = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; ++i) 
				a[i] = Long.parseLong(strz.nextToken());
			
			strz = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; ++i) 
				b[i] = Long.parseLong(strz.nextToken());
			
			long ans = solve(a, b, n);
			System.out.println(ans);
		}
	}
}
