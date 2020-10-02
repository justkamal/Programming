package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubsequencePalindrome {

	private static BufferedReader br;
	private static StringTokenizer strz;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			strz = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; ++i)
				arr[i] = Integer.parseInt(strz.nextToken());

			int i = 0;
			for (i = 0; i < n - 2; i++) {
				for (int j = i + 2; j < n; j++) {
					if (arr[i] == arr[j]) {
						i = n - 1;
						break;
					}
				}
			}
			if (i == n)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
