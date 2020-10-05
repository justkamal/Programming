package contest_675;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1 {
	private static BufferedReader br;
	private static StringTokenizer strz;

	public static void main(String[] args) throws java.lang.Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			strz = new StringTokenizer(br.readLine());
			long a = Long.parseLong(strz.nextToken());
			long b = Long.parseLong(strz.nextToken());
			long c = Long.parseLong(strz.nextToken());
			
			long max = Math.max(Math.max(a, b), c);
			
			System.out.println(max);
		}
	}
}
