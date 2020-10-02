package globalround_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CPlus {
	private static BufferedReader br;
	private static StringTokenizer strz;

	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			strz = new StringTokenizer(br.readLine());
			long a = Long.parseLong(strz.nextToken());
			long b = Long.parseLong(strz.nextToken());
			long n = Long.parseLong(strz.nextToken());
			
			long count = 0;
			while(a <= n && b <= n) {
				long sum = a+b;
				if(a < b)
					a = sum;
				else 
					b = sum;
				++count;
			}
			System.out.println(count);
		}
	}
}
