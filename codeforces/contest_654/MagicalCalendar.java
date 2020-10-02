package contest_654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MagicalCalendar {
	private static BufferedReader br;
	private static StringTokenizer strz;

	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0) {
			strz = new StringTokenizer(br.readLine());
			long n = Long.parseLong(strz.nextToken());
			long r = Long.parseLong(strz.nextToken());
			long res = 0;

			if (n <= 1) {
				System.out.println("1");
				continue;
			}
			if (n <= r) {
				r = n - 1;
				res = 1;
			}
			res += ((r + 1) * r) >> 1;
			System.out.println(res);
		}
	}
}
