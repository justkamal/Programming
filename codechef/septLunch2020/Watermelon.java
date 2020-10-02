package septLunch2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Watermelon {
	private static BufferedReader br;
	private static StringTokenizer strz;

	public static boolean solve(int[] arr, int index, int sum) {
		if (index >= arr.length)
			return sum == 0;
		if(sum == 0){
		    return true;
		} else if (sum > 0) {
			if (sum - index == 0) {
				return true;
			} else if(sum - index > 0){
				return solve(arr, index, sum - index) || solve(arr, index + 1, sum - index);
			} else {
				return false;
			}
		}
		
		return false;
	}

	public static void main(String[] args) throws java.lang.Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			strz = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			int sum = 0;
			for (int i = 0; i < arr.length; ++i) {
				arr[i] = Integer.parseInt(strz.nextToken());
				sum += arr[i];
			}
			boolean result = solve(arr, 1, sum);
			if (result)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
