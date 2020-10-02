package contest_645;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ParkLight {
	private static BufferedReader br;
	private static StringTokenizer strz;

	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			strz = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(strz.nextToken());
			int c = Integer.parseInt(strz.nextToken());
			int ans = (r/2)*c + (r%2)*(c/2) + (r%2)*(c%2);
			System.out.println(ans);
		}
	}
}
