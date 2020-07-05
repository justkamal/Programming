package hackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestSubarray {
	private static BufferedReader br;

	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int maxLen = 0;
        int size = 0;
        int val1 = - 1, val2 = -1;
        
		while(t-- > 0) {
			int x = Integer.parseInt(br.readLine());
			if(val1 == -1 && val2 == -1){
                val1 = x;
                ++size;
            } else if(val1 != -1 && val2 == -1){
                if(val1 == x){
                    ++size;
                } else if(Math.abs(x - val1) <= 1){
                    val2 = x;
                    ++size;
                } else {
                	val1 = x;
                	size = 1;
                }
            } else if(val1 != -1 && val2 != -1){
                if(x == val1 || x == val2)
                    ++size;
                else if(Math.abs(x - val2) <= 1){
                    maxLen = Math.max(maxLen, size);
                    size = 2;

                    val1 = val2;
                    val2 = x;
                } else {
                    maxLen = Math.max(maxLen, size);
                    size = 1;

                    val1 = x;
                    val2 = -1;
                }
            }
			System.out.println("--------------------------------------");
            System.out.println("Element : " + x + " | Size : " + size);
			System.out.println("--------------------------------------");
		}
		System.out.println((int)Math.max(maxLen, size));
	}
}
