package contest_672;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CubeSorting {
	
	private static BufferedReader br;
	private static StringTokenizer strz;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			long[] arr = new long[n];
			long[] cpy = new long[n];
			strz = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < arr.length; ++i) { 
				arr[i] = Long.parseLong(strz.nextToken());
				cpy[i] = arr[i];
			}
			
			Arrays.sort(arr);
			
			int change = 0;
			for(int i = 0; i < arr.length; ++i) {
				if(arr[i] != cpy[i])
					++change;
			}
			
			if((change&1) > 0)
				++change;
			change /= 2;
			
			int need = n*(n-1)/2 - 1;
			
			if(change > need) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	}

}