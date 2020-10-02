package septLunch2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class GDCOperation {
	private static BufferedReader br;
	private static StringTokenizer strz;

	public static boolean solve(int[] arr, int[] need, HashSet<Integer> unique) {

		for (int i = 0; i < arr.length; ++i) {
			if (need[i] > arr[i]) {
				return false;
			} else if (need[i] < arr[i]) {
				if (arr[i] % need[i] == 0) {
					unique.remove(arr[i]);
					unique.add(need[i]);
				} else {
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) throws java.lang.Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			int[] need = new int[n];

			strz = new StringTokenizer(br.readLine());
			HashSet<Integer> unique = new HashSet<Integer>();
			for (int i = 0; i < n; ++i) {
				need[i] = Integer.parseInt(strz.nextToken());
				arr[i] = i + 1;
				unique.add(arr[i]);
			}

			boolean result = solve(arr, need, unique);
			if (result)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
