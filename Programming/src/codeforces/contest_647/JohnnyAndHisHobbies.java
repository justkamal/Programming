package codeforces.contest_647;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class JohnnyAndHisHobbies {
	private static BufferedReader br;
	private static StringTokenizer strz;

	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int ans = -1;
			
			HashSet<Integer> unique = new HashSet<Integer>();
			strz = new StringTokenizer(br.readLine());
			
			while (strz.hasMoreTokens())
				unique.add(Integer.parseInt(strz.nextToken()));
			
			HashSet<Integer> aux = new HashSet<Integer>();
			for (int k = 1; k <= 1024; ++k) {
				
				for (int x : unique) {
					int xor = x ^ k;
					if (unique.contains(xor) && !aux.contains(xor))
						aux.add(x ^ k);
				}
				
				if (aux.size() == n) {
					ans = k;
					break;
				}
				aux.clear();
			}

			System.out.println(ans);
		}
	}
}