package codeforces.contest_633;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SortingAdjustment {
	
	private static BufferedReader br;
	private static StringTokenizer strz;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in)); 
		
		int T, i, n, arr[];

		T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			strz = new StringTokenizer(br.readLine());
			
			for (i = 0; i < n; i++)
				arr[i] = Integer.parseInt(strz.nextToken());

			Arrays.sort(arr);

			if (n % 2 == 1)
				System.out.print(arr[n / 2] + " ");

			for (i = n / 2 - 1; i >= 0; i--)
				System.out.print(arr[i] + " " + arr[n - i - 1] + " ");

			System.out.println();
		}
	}
}
