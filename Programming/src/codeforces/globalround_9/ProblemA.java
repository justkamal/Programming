package codeforces.globalround_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ProblemA {
	private static BufferedReader br;
	private static StringTokenizer strz;
	
	public static boolean computeFlip(long[] arr, int index, int reqPos, int reqNeg) {
		if(reqPos == reqNeg && reqPos == 0)
			return true;
		if(index + 1 > arr.length)
			return false;
		
		long diff1 = arr[index] - arr[index-1];
		long diff2 = arr[index] + arr[index-1];
		
		boolean ans1 = false;
		boolean ans2 = false;
		
		if(diff1 < 0 && (arr.length - index - 1 >= reqPos)) {
			ans1 = computeFlip(arr, index + 1, reqPos ,reqNeg - 1);
		} else if(diff1 > 0 && (arr.length - index - 1 >= reqNeg)) {
			ans1 = computeFlip(arr, index + 1, reqPos - 1,reqNeg);
		} else {
			ans1 = computeFlip(arr, index + 1, reqPos - 1,reqNeg - 1);
		}
		
		if(diff2 < 0 && (arr.length - index - 1 >= reqPos)) {
			ans2 = computeFlip(arr, index + 1, reqPos ,reqNeg - 1);
		} else if(diff1 > 0 && (arr.length - index - 1 >= reqNeg)) {
			ans2 = computeFlip(arr, index + 1, reqPos - 1,reqNeg);
		} else {
			ans2 = computeFlip(arr, index + 1, reqPos - 1,reqNeg - 1);
		}
		
		return ans1 || ans2;
	}
	
	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			strz = new StringTokenizer(br.readLine());
			
			long[] arr = new long[n];
			
			for(int i = 0; strz.hasMoreTokens(); ++i) 
				arr[i] = Long.parseLong(strz.nextToken());
			
			int reqPos = (n-1)/2;
			int reqNeg = (n-1)/2;
			
			computeFlip(arr, 1, reqPos, reqNeg);
			System.out.println(Arrays.toString(arr));
		}
	}
}
