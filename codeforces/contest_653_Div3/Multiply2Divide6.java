package contest_653_Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Multiply2Divide6 {
	private static BufferedReader br;
	//private static StringTokenizer strz;

	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0) {
			long n = Long.parseLong(br.readLine());
			long count = -1;
			
			long pow6 = (long)(Math.log(n)/Math.log(6));
			
			if((long)Math.pow(6, pow6) == n) {
				count = pow6;
			} else {
				long temp = (long)Math.pow(6, pow6+1);
				for(int i = 1; Math.pow(2,i) < temp; ++i) {
					long x = (long)Math.pow(2,i);
					if(temp/x == n) {
						count = i + pow6 + 1;
						break;
					}						
				}
			}
			
			System.out.println(count);
		}
	}
}
