package codeforces.contest_647;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JohnnyAndAncientComputer {
	private static BufferedReader br;
	private static StringTokenizer strz;

	public static long reduceTest(long a, long b) {
		long count = 0;
		long need = 0;

		if (a == b)
			return 0;

		if (a > b) {
			long temp = b;
			b = a;
			a = temp;
		}

		if (b % a != 0)
			return -1;

		need = b / a;

		while (need > 1) {
			if (need % 8 == 0)
				need /= 8;
			else if (need % 4 == 0)
				need /= 4;
			else if (need % 2 == 0)
				need /= 2;
			else
				return -1;
			++count;
		}

		return count;
	}

	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			strz = new StringTokenizer(br.readLine());
			long a = Long.parseLong(strz.nextToken());
			long b = Long.parseLong(strz.nextToken());

			System.out.println(reduceTest(a, b));
		}
	}
}