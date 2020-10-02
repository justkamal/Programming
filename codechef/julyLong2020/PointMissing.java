package julyLong2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PointMissing {
	
	private static BufferedReader br;
	private static StringTokenizer strz;
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			HashMap<Long, Integer> xCount = new HashMap<Long, Integer>();
			HashMap<Long, Integer> yCount = new HashMap<Long, Integer>();
			
			for(int i = 0; i < 4*n-1; ++i) {
				strz = new StringTokenizer(br.readLine());
				long x = Long.parseLong(strz.nextToken());
				long y = Long.parseLong(strz.nextToken());
				xCount.put(x, xCount.getOrDefault(x, 0) + 1);
				yCount.put(y, yCount.getOrDefault(y, 0) + 1);
			}
			
			long missing_x = 0, missing_y = 0;
			for(Long x : xCount.keySet())
				if((xCount.get(x) & 1) > 0)
					missing_x = x;
			
			for(Long y : yCount.keySet())
				if((yCount.get(y) & 1) > 0)
					missing_y = y;
			System.out.println(missing_x + " " + missing_y);
			/*
			 * System.out.println(xCount); System.out.println(yCount);
			 */
		}
	}

}