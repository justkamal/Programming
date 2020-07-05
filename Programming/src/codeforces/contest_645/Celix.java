package codeforces.contest_645;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Celix {
	private static BufferedReader br;
	private static StringTokenizer strz;
	
	public static String compute(long x1, long y1, long x2, long y2) {
		BigInteger X1 = new BigInteger(Long.toString(x1).toString()).subtract(BigInteger.ONE);
		BigInteger Y1 = new BigInteger(Long.toString(y1)).subtract(BigInteger.ONE);
		BigInteger X2 = new BigInteger(Long.toString(x2)).subtract(BigInteger.ONE);
		BigInteger Y2 = new BigInteger(Long.toString(y2)).subtract(BigInteger.ONE);

		long ans = (x2-x1)*(y2-y1);
		System.out.println(ans);
		return X2.subtract(X1).multiply(Y2.subtract(Y1)).toString();
	}

	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			strz = new StringTokenizer(br.readLine());
			long x1 = Long.parseLong(strz.nextToken());
			long y1 = Long.parseLong(strz.nextToken());
			long x2 = Long.parseLong(strz.nextToken());
			long y2 = Long.parseLong(strz.nextToken());
			System.out.println(compute(x1, y1, x2, y2));
		}
	}
}
