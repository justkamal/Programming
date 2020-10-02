package contest_639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PuzzlePieces {
	private static BufferedReader br;
	private static StringTokenizer strz;

	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			strz = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(strz.nextToken());
			int m = Integer.parseInt(strz.nextToken());
			if(n == 1 || m == 1) {
				System.out.println("YES");
			} else if(n <= 2 && m <= 2) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}