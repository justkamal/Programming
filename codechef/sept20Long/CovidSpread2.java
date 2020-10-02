package sept20Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CovidSpread2 {

	private static BufferedReader br;
	private static StringTokenizer strz;

	public static void main(String[] args) throws java.lang.Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			strz = new StringTokenizer(br.readLine());
			int[] v = new int[n];
			int[] count = new int[n];

			Arrays.fill(count, 1);

			for (int i = 0; i < n; ++i)
				v[i] = Integer.parseInt(strz.nextToken());

			for (int i = 0; i < n - 1; ++i) {
				for (int j = i + 1; j < n; ++j) {
					double time = 0;
					if (v[i] != v[j])
						time = (double) (j - i) / (v[i] - v[j]);
					if (time > 0.0) {
						count[j] = count[i] = Math.max(count[i], count[j]) + 1;
					}
				}
			}

			int best = Integer.MAX_VALUE;
			for (int x : count)
				best = Math.min(x, best);

			int worst = Integer.MIN_VALUE;
			for (int x : count)
				worst = Math.max(x, worst);

			System.out.println(best + " " + worst);
		}
	}
}