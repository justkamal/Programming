package codechef.juneLong2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EvenMatrix {
	private static BufferedReader br;

	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int odd = 1, even = 2;
			int[][] arr = new int[n][n];
			for(int i = 0; i < n; ++i) {
				for(int j = 0; j < n; ++j) {
					if(((i + j)&1) == 0) {
						arr[i][j] = even;
						even += 2;
					}else {
						arr[i][j] = odd;
						odd += 2;
					}
				}
			}
			
			for(int i = 0; i < n; ++i) {
				for(int j = 0; j < n; ++j)
					System.out.print(arr[i][j] + " ");
				System.out.println();
			}
		}
	}
}