package codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class BookPairs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer n = sc.nextInt();
		Integer a[] = new Integer[n], b[] = new Integer[n], d[] = new Integer[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		for (int i = 0; i < n; i++)
			b[i] = sc.nextInt();
		for (int i = 0; i < n; i++)
			d[i] = a[i] - b[i];
		Arrays.sort(d);
		long ans = 0;
		int l = 0, r = n - 1;
		while (l < r)
			if (d[l] + d[r] > 0) {
				ans = ans + r - l;
				r--;
			} else
				l++;
		System.out.println(ans);
	}
}
