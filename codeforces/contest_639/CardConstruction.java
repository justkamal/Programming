package contest_639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CardConstruction {
	private static BufferedReader br;
	private static long[] pre;
	private static int MAX = 25821;

	public static void precompute() {
		long need = 0;
		pre = new long[MAX];

		for (int height = 1; height < MAX; ++height) {
			need += (height - 1) + 2 * height;
			pre[height] = need;
		}
	}

	public static int upperBound(long[] array, int length, long value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = (low + high) / 2;
            if (value >= array[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
	
	public static void main(String args[]) throws IOException {
		precompute();

		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			long n = Long.parseLong(br.readLine());
			long count = 0;
			while(n > 1) {
				int idx = upperBound(pre, pre.length, n);
				if(pre[idx] > n) {
					n -= pre[idx-1];
				} else {
					n -= pre[idx];
				}
				++count;
			}
			System.out.println(count);
		}

	}
}