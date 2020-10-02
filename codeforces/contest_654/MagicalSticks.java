package contest_654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MagicalSticks {
	private static BufferedReader br;
	//private static StringTokenizer strz;

	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0) {
			long n = Long.parseLong(br.readLine()) - 1;
			System.out.println((n>>1) + 1);
		}
	}
}
