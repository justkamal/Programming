package interviewBit;

import java.util.Arrays;
import java.util.Comparator;

public class StringQuery {

	private class Info {
		Integer index = 0;
		Integer maxLen = 0;
		Integer occ = 0;

		@Override
		public String toString() {
			return "[index=" + index + " maxLen=" + maxLen + " occ=" + occ + "]";
		}
	}

	public void computeInfo(Info info, String str, int index, char need) {
		char[] arr = str.toCharArray();

		info.index = index;
		int len = 1, max = 1;
		char prev = arr[0];
		for (int i = 0; i < str.length(); ++i) {
			if (arr[i] == need)
				++info.occ;
			if (arr[i] == prev + 1)
				++len;
			else
				len = 1;
			max = Math.max(len, max);
			prev = arr[i];
		}
		info.maxLen = max;
		System.out.println(info);
	}
	
	public int binarySearch(Info[] arr, int maxLen, int maxOcc) {
		int low = 0, high = arr.length - 1;
		int ans = -1;
		while(low <= high) {
			int mid = low + (high-low)/2;
			if(arr[mid].maxLen == maxLen) {
				if(arr[mid].occ == maxOcc) {
					ans = arr[mid].index;
					high = mid - 1;
				} else if(arr[mid].occ > maxOcc) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else if(arr[mid].maxLen > maxLen) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		
		return ans;
	}
	
	public String[] solve(String[] A, String B, int[][] Q) {
		Info[] info_arr = new Info[A.length];
		char need = B.charAt(0);
		for (int i = 0; i < A.length; ++i) {
			info_arr[i] = new Info();
			computeInfo(info_arr[i], A[i], i, need);
		}
		
		Arrays.sort(info_arr, new Comparator<Info>() {
			@Override
			public int compare(Info inf1, Info inf2) {
				if(inf1.maxLen < inf2.maxLen)
					return -1;
				else if(inf1.maxLen > inf2.maxLen)
					return 1;
				else{
					if(inf1.occ < inf2.occ)
						return -1;
					else if(inf1.occ > inf2.occ)
						return 1;
					return inf1.index.compareTo(inf2.index);
				}
			}
			
		});
		
		System.out.println(Arrays.toString(info_arr));
		
		String res[] = new String[Q.length];
		
		for(int q = 0; q < Q.length; ++q) {
			int maxLen = Q[q][0];
			int maxOcc = Q[q][1];
			int idx = binarySearch(info_arr, maxLen, maxOcc);
			if(idx != -1)
				res[q] = A[idx];
		}
		
		return res;
	}

	public static void main(String[] args) {
		StringQuery obj = new StringQuery();
		String[] A = {"abaclmn", "abcac", "abxpqr", "abcdefghijklmnqrs", "abcdefghij", "kabcdefghijklmnopqrstuvwzyxaaaabcd"};
		String B = "a";
		int[][] Q = {{3,2}, {23,5}};
		String[] res = obj.solve(A,B,Q);
		System.out.println(Arrays.toString(res));
	}

}
