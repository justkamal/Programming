package juneLong2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TomAndJerry {
	private static BufferedReader br;
	private static long powers2[] = new long[60];

	public static void precompute() {
		for (int i = 0; i < powers2.length; ++i)
			powers2[i] = 1L << i;
	}

	public static int findMinPowers(long x) {
		int count = 0;
		while((x&1) != 1) {
			x = x>>1;
			++count;
		}
		
		return count;
	}
	
	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		precompute();

		while (t-- > 0) {
			long tom = Long.parseLong(br.readLine());
			long res = 0;
			if ((tom & 1) != 0) {
				res = tom / 2;
			} else {
				long count = 0, prev = 0;
				int max = (int) (Math.log(tom) / Math.log(2));
				int min = findMinPowers(tom);
				for (int i = max; i > min; --i) {
					count = tom / powers2[i] - prev;
					res += count;
					prev = tom / powers2[i];
				}
			}

			System.out.println(res);
		}
	}
}