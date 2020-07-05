package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FrogJumps {

	private static BufferedReader br;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			StringBuilder str = new StringBuilder(br.readLine());
			int n = str.length();
			int d = 0, max = 0;

			for (int i = 0; i < n; i++) {
				if (str.charAt(i) == 'L') {
					d++;
				} else {
					if (max < d)
						max = d;
					d = 0;
				}
			}
			if (max < d)
				max = d;
			System.out.println(max + 1);
		}

	}

}