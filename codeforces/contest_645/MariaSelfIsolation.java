package contest_645;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MariaSelfIsolation {
	private static BufferedReader br;
	private static StringTokenizer strz;

	public static long countGranny(int[] grannyNeed) {
		Queue<Integer> yard = new LinkedList<Integer>();
		long count = 1; // maria

		for (int need : grannyNeed) {
			if (count >= need) {
				++count;
			} else{
				yard.add(need);
				if (count + yard.size() - 1 >= need) {
					count += yard.size();
					yard.clear();
				}
			}
			if(need > grannyNeed.length)
				return count;
		}

		return count;
	}

	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			strz = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; ++i)
				arr[i] = Integer.parseInt(strz.nextToken());
			Arrays.sort(arr);
			System.out.println(countGranny(arr));
		}
	}
}
