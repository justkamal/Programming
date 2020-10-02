package contest_650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EvenArray {
	private static BufferedReader br;
	private static StringTokenizer strz;

	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			strz = new StringTokenizer(br.readLine());

			int odd = 0, even = 0;
			for (int i = 0; strz.hasMoreTokens() && i < n; ++i) {
				int x = Integer.parseInt(strz.nextToken());
				if((x&1) == 1) {
					if((i&1) == 0)
						++odd;
				} else {
					if((i&1) == 1)
						++even;
				}
			}
			
			if(odd == even)
				System.out.println(odd);
			else
				System.out.println(-1);
		}
	}
}
