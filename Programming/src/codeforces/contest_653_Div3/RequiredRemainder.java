package codeforces.contest_653_Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RequiredRemainder {
	private static BufferedReader br;
	private static StringTokenizer strz;

	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0) {
			strz = new StringTokenizer(br.readLine());
			
			Long x = Long.parseLong(strz.nextToken());
			Long y = Long.parseLong(strz.nextToken());
			Long n = Long.parseLong(strz.nextToken());
			
			Long r = n%x;
			if(r < y) {
				n -= x;
				n += (y-r);
			} else {
				n -= r-y;
			}
			System.out.println(n);
		}
	}
}
