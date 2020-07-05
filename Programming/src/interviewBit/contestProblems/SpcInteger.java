package interviewBit.contestProblems;

import java.io.IOException;

public class SpcInteger {
	
	public static int solve(int[] A, int B) {
        int sum = 0;
        int i = 0, j = 0, n = A.length;
        int k = A.length;
        
        while(j < n){
            sum += A[j];
        	while(sum > B && i <= j) {
        		k = Math.min(k, j - i);
        		sum -= A[i];
                ++i;
            }
            ++j;
        }
        
        return k;
    }

	public static void main(String args[]) throws IOException {
		int[] A = { 1, 2, 3, 4, 5 };
		int B = 10;
		System.out.println(solve(A, B));
	}
}
