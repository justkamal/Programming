package contest_647;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JohnnyAndAnotherRatingDrop {
	private static BufferedReader br;
	private static final int LIMIT = 1000000;
	private static long[] prefix = new long[1000000];
	
	private static void precompute() {
		for(int i = 1; i < prefix.length; ++i) 
			prefix[i] = prefix[i-1] + i^(i-1);
	}
	
	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		precompute();
		
		while(t-- > 0) {
			long n = Long.parseLong(br.readLine());
			if(n < LIMIT)
				System.out.println();
		}
	}
}
