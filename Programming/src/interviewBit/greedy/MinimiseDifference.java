package interviewBit.greedy;

public class MinimiseDifference {

	public int solve(int[] A, int B) {
		int maxx = 0;
		int k = B;
		for (int i = 0; i < A.length; i++) {
			maxx = Math.max(maxx, A[i]);
		}

		int[] freq = new int[maxx + 1];

		for (int i = 0; i < A.length; i++) {
			freq[A[i]]++;
		}

		int i = 0, j = maxx;
		while (i < j) {
			if (freq[i] > freq[j]) {
				if (freq[j] <= k) { // perfrom decrement operation
					freq[j - 1] = freq[j - 1] + freq[j];
					k = k - freq[j];
					j--;
				} else {
					break;
				}
			} else {
				if (freq[i] <= k) { // perfrom increment operation
					freq[i + 1] = freq[i + 1] + freq[i];
					k = k - freq[i];
					i++;
				} else {
					break;
				}
			}
		}

		return j - i;
	}

	public static void main(String[] args) {
		MinimiseDifference obj = new MinimiseDifference();
		//7 2 8 3 7 8 7 9 | 9
		int[] arr =  {1,1,7};
		int B = 6;
		obj.solve(arr, B);
	}

}
