package julyLong2020;

import static java.lang.Math.max;
import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ChefinaSwaps {
	
	private static BufferedReader br;
	private static StringTokenizer strz;
	
	private static class Count{
		int a;
		int b;
		
		public Count() {
			this.a = 0;
			this.b = 0;
		}
		
		@Override
		public String toString() {
			return "["+ a + ", " + b + "]";
		}
	}
	
	public static long solve(ArrayList<Long> a, ArrayList<Long> b, HashMap<Long, Count> countMap) {
		long minCost = 0;
		
		Collections.sort(a);
		Collections.sort(b, Collections.reverseOrder());
		
		int i = 0, j = 0;
		while(i < a.size() && j < b.size()) {
			long x = a.get(i);
			long y = b.get(j);
			long xcount = countMap.get(x).a + countMap.get(x).b; 
			long ycount = countMap.get(y).a + countMap.get(y).b;
			
			if((xcount&1) == 1 || (ycount&1) == 1)
				return -1;
			if(countMap.get(x).a == countMap.get(x).b && countMap.get(y).a == countMap.get(y).b) {
				++i; ++j;
			} else {
				long xneed = max(xcount/2 - countMap.get(x).a, xcount/2 - countMap.get(x).b);
				long yneed = max(ycount/2 - countMap.get(y).a, ycount/2 - countMap.get(y).b);
				
				if(xneed == yneed) {
					minCost += min(x, y)*xneed;
					++i; ++j;
				} else if(xneed > yneed){
					minCost = min(x,y)*yneed;
					if(countMap.get(x).a > countMap.get(x).b) {
						countMap.get(x).a -= yneed;
						countMap.get(x).b += yneed;
					} else {
						countMap.get(x).a += yneed;
						countMap.get(x).b -= yneed;
					}
					++j;
				} else {
					minCost = min(x,y)*xneed;
					if(countMap.get(y).a > countMap.get(y).b) {
						countMap.get(y).a -= xneed;
						countMap.get(y).b += xneed;
					} else {
						countMap.get(y).a += xneed;
						countMap.get(y).b -= xneed;
					}
					++i;
				}
			}
		}
		
		return minCost;
	}
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			HashMap<Long, Count> countMap = new HashMap<Long, Count>();
			ArrayList<Long> a = new ArrayList<Long>();
			ArrayList<Long> b = new ArrayList<Long>();
			
			strz = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; ++i) {
				long x = Long.parseLong(strz.nextToken());
				Count count = countMap.getOrDefault(x, new Count());
				if(count.a == 0)
					a.add(x);
				++count.a;
				countMap.put(x, count);
			}
			
			strz = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; ++i) {
				long x = Long.parseLong(strz.nextToken());
				Count count = countMap.getOrDefault(x, new Count());
				if(count.b == 0)
					b.add(x);
				++count.b;
				countMap.put(x, count);
			}
			
			long ans = solve(a, b, countMap);
			System.out.println(ans);
		}
	}

}