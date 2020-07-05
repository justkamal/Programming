package codeforces;

//https://codeforces.com/contest/1324/problem/A

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Tetris {
	
	private static BufferedReader br;
	private static StringTokenizer strz;
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			strz = new StringTokenizer(br.readLine());
			int count0 = 0, count1 = 0;
			for(int i = 0; i < n; ++i) {
				int height = Integer.parseInt(strz.nextToken());
				count1 += height%2;
				count0 += 1 - height%2;
			}
			if(count1 == 0 && count0 != 0 || count1 != 0 && count0 == 0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}