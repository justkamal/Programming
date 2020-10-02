package contest_639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HilbertHotel {
	private static BufferedReader br;
	private static StringTokenizer strz;

	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			
			int n = Integer.parseInt(br.readLine());
			long[] arr = new long[n];
			
			strz = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; ++i)
				arr[i] = Long.parseLong(strz.nextToken());	
		}
	}
}