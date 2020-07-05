package codechef.juneLong2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class ChefAndIcecream {

	private static BufferedReader br;
	private static StringTokenizer strz;
	private static final int FIVE = 0;
	private static final int TEN = 1;

	public static void main(String[] args) throws java.lang.Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			strz = new StringTokenizer(br.readLine());
			int[] amt = new int[n];
			int wallet[] = new int[2];
			for (int i = 0; i < n; ++i)
				amt[i] = Integer.parseInt(strz.nextToken());
			int buy = 0;

			loop: for (int i = 0; i < amt.length; ++i) {
				switch (amt[i]) {
				case 5:
					wallet[FIVE]++;
					++buy;
					break;
				case 10:
					if (wallet[FIVE] >= 1) {
						--wallet[FIVE];
						++wallet[TEN];
						++buy;
					} else {
						break loop;
					}
					break;
				case 15:
					if (wallet[TEN] >= 1) {
						--wallet[TEN];
						++buy;
					} else if(wallet[FIVE] >= 2){
						wallet[FIVE] -= 2;
						++buy;
					}else {
						break loop;
					}
					break;
				}
			}

			if (buy == n)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}