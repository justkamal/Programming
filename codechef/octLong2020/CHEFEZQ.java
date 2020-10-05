package octLong2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * link : https://www.codechef.com/OCT20B/problems/CHEFEZQ
 * */

public class CHEFEZQ {
	private static BufferedReader br;
	private static StringTokenizer strz;

	public static void main(String[] args) throws java.lang.Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			strz = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(strz.nextToken());
			long k = Long.parseLong(strz.nextToken());
			
			strz = new StringTokenizer(br.readLine());
			long[] q = new long[n];
			long rem = 0;
			long day = -1;
			int i = 0;
			for(i = 0; strz.hasMoreTokens(); ++i) {
				q[i] = Long.parseLong(strz.nextToken());
				if(q[i] > k) {
					rem += q[i] - k;
					q[i] = k;
				} else if(q[i] < k){
					long diff = Math.min(k-q[i], rem);
					q[i] += diff;
					rem -= diff;
				}
				if(day == -1 && q[i] < k) {
					day = i + 1;
				}
			}
			
			//remaining queries after nth day
			if(day == -1) {
				day = i + (rem/k) + 1L;
			}
			
			System.out.println(day);
		}
	}
}
