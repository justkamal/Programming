package april20_cook_off;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LiftRequests {
	
	private static BufferedReader br;
	private static StringTokenizer strz;
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			strz = new StringTokenizer(br.readLine());
			//int n = Integer.parseInt(strz.nextToken());
			int q = Integer.parseInt(strz.nextToken());
			int travel = 0;
			int curr = 0;
		
			while(q-- > 0) {
				strz = new StringTokenizer(br.readLine());
				int src = Integer.parseInt(strz.nextToken());
				int des = Integer.parseInt(strz.nextToken());
				
				travel += Math.abs(curr - src) + Math.abs(src - des);;
				curr = des;
			}
			
			System.out.println(travel);
		}

	}

}
