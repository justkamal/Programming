package contest_650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://codeforces.com/contest/1367/

public class ShortSubString {
	private static BufferedReader br;

	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			char[] str = br.readLine().toCharArray();
			for(int i = 0; i < str.length; i+=2) {
				System.out.print(str[i]);
			}
			System.out.println(str[str.length - 1]);
		}
	}
}
