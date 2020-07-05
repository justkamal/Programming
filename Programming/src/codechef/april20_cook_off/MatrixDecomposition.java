package codechef.april20_cook_off;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MatrixDecomposition {

	private static final long MOD = (long) 1e9 + 7;
	private static BufferedReader br;
	private static StringTokenizer strz;

	static long power(long x, long y) {
		long res = 1;

		x = x % MOD;

		if (x == 0)
			return 0; 	// In case x is divisible by p;

		while (y > 0) {
			if ((y & 1) == 1)
				res = (res * x) % MOD;
			y = y >> 1;
			x = (x * x) % MOD;
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			strz = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(strz.nextToken());
			long a = Long.parseLong(strz.nextToken());
			long c = 0, b = a;
			long sum = a;

			for (int i = 2; i <= n; ++i) {
				a = ((a % MOD) * (b % MOD)) % MOD;
				a %= MOD;
				c = (long) (power(a, 2 * i - 1));
				c %= MOD;
				sum += c;
				sum %= MOD;
				b = c;
				if (a < 0)
					a += MOD;
				if (b < 0)
					a += MOD;
			}
			System.out.println(sum);
		}

	}
}