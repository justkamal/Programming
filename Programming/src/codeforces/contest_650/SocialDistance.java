package codeforces.contest_650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SocialDistance {
	private static BufferedReader br;
	private static StringTokenizer strz;

	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			strz = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(strz.nextToken());
			int k = Integer.parseInt(strz.nextToken());
			
			char[] arr = br.readLine().toCharArray();
			int maxFree = 0, free = 0, i = 0;
			boolean allZero = false;
			
			System.out.println(maxFree);
		}
	}
}
