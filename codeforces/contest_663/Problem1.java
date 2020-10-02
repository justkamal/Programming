package contest_663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1 {

	private static BufferedReader br;

	public static int findNumberOfBits(String bin) {
		int i = 0;

		while (bin.charAt(i++) != '1')
			;

		return bin.length() - i + 1;
	}

	public static int onesComplement(int n, int number_of_bits) {

		// shift 1 by number_of_bits places and then subtract 1 to generate 1111....n-1 times
		// so that now we can get the 1's complement by doing xor with it since 1^0 is 1 and 1^1 is 0
		return ((1 << number_of_bits) - 1) ^ n;
	}

	public static void main(String[] args) throws IOException {

		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int maxBits = findNumberOfBits(Integer.toBinaryString(n));

			int limit = n / 2;
			StringBuilder res = new StringBuilder();

			if ((n & 1) > 0) {
				res.append(n);
				res.append(" ");
			}

			for (int i = 1; i <= limit; ++i) {
				res.append(i);
				res.append(" ");
				res.append(onesComplement(i, maxBits));
				res.append(" ");
			}

			System.out.println(res);
		}

		// System.out.println(onesComplement(Integer.MAX_VALUE,
		// findNumberOfBits(Integer.toBinaryString(Integer.MAX_VALUE))));
	}

}
