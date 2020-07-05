package codeforces.contest_635;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IchihimeTriangle {

	private static BufferedReader br;
	private static StringTokenizer strz;

	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		int T;

		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			long a,b,c,d;
			strz = new StringTokenizer(br.readLine());
			a = Long.parseLong(strz.nextToken());
			b = Long.parseLong(strz.nextToken());
			c = Long.parseLong(strz.nextToken());
			d = Long.parseLong(strz.nextToken());
			
			System.out.println(a + " " + c + " " + c);
		}
	}

}