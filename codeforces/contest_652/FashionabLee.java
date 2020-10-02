package contest_652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FashionabLee {
	private static BufferedReader br;
	private static StringTokenizer strz;

	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0) {
			long n = Long.parseLong(br.readLine());
			if(n%4 ==0)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
}
