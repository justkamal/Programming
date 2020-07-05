package interviewBit;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class SquareFulArrays {

	private static int count = 0;

	public static boolean isSquareFul(int x, int y) {
		return (Math.sqrt(x + y) * Math.sqrt(x + y)) - (x + y) == 0 ? true : false;
	}

	public static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	public static void permutate(int[] arr, int index) {
		if (index > 1 && (!isSquareFul(arr[index], arr[index - 1]) || !isSquareFul(arr[index - 1], arr[index - 2]))) {
			return;
		}
		// if index is the last, then check index with its adjancent neighbor
		if (index == arr.length - 1 && !isSquareFul(arr[index], arr[index - 1])) {
			return;
		}

		if (index == arr.length - 1) {
			count++;
			return;
		}

		HashSet<Integer> set = new HashSet<>();
		for (int i = index; i < arr.length; i++) {
			// avoids duplicate element case
			if (set.contains(arr[i])) {
				continue;
			}
			set.add(arr[i]);

			swap(arr, i, index);
			permutate(arr, index + 1);
			swap(arr, i, index);
		}
	}

	public static void main(String[] args) {
		Random random = new Random();

		int[] arr = new int[random.nextInt(12)];

		for (int i = 0; i < arr.length; ++i) {
			arr[i] = random.nextInt(100);
		}

		System.out.println(Arrays.toString(arr));

		permutate(arr, 0);
		System.out.println(count);
	}
}
