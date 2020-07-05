package hackerEarth.PaypalChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SumSubArray {
		
	private static BufferedReader br;
	private static StringTokenizer strz;
	
	public static int computeRearrange(int[] arr, int[] freq) {
		int sum = 0;
		
		Arrays.sort(arr);
		Arrays.sort(freq);
		
		for(int i = arr.length - 1; i >= 0; --i) 
			sum += freq[i]*arr[i];
		
		return sum;
	}
	
	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			strz = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(strz.nextToken());
			int k = Integer.parseInt(strz.nextToken());
			
			int[] arr = new int[n];
			
			strz = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; ++i)
				arr[i] = Integer.parseInt(strz.nextToken());
			
			int[] freq = new int[n];			
			int[] prefix = new int[n];
			prefix[0] = arr[0];
			
			for(int i = 1; i < n; ++i)
				prefix[i] = prefix[i-1] + arr[i];
			
			int sum_a = 0;
			
			for(int i = 1; i <= k; ++i) {
				strz = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(strz.nextToken()) - 1;
				int end = Integer.parseInt(strz.nextToken()) - 1;
				
				sum_a += prefix[end] - prefix[start] + arr[start];
				freq[start] += 1;
				if(end + 1 < n)
					freq[end + 1] -= 1;
			}
			
			for(int i = 1; i < n; ++i) 
				freq[i] += freq[i-1];
			
			int sum_b = computeRearrange(arr, freq);
			
			System.out.println(sum_b - sum_a);		
		}
	}
}