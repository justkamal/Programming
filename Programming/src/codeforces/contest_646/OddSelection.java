package codeforces.contest_646;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OddSelection {
	private static BufferedReader br;
	private static StringTokenizer strz;

	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			strz = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(strz.nextToken());
			int x = Integer.parseInt(strz.nextToken());

			strz = new StringTokenizer(br.readLine());
			int oddCount = 0, evenCount = 0;

			for (int i = 0; i < n; ++i) {
				int element = Integer.parseInt(strz.nextToken());
				if (element % 2 == 0)
					evenCount++;
				else
					oddCount++;
			}

			boolean possible = false;

			

			if (possible)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
