package hackerEarth;

import java.util.Arrays;
import java.util.Comparator;

public class MinParking {
	
	static class Pair{
		int start = 0;
		int end = 0;
		
		public Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	static int minParkingSpaces(int[][] parkingStartEndTimes) {
		int need = 0;
		Pair[] timings = new Pair[parkingStartEndTimes.length];
		
		Arrays.sort(timings, new Comparator<Pair>() {
			@Override
			public int compare(Pair t1, Pair t2) {
				return t1.end - t2.end;
			}
		});
		
		for(int i = 1; i < timings.length; ++i) 
			if(timings[i-1].end >= timings[i].start)
				++need;
		
		
		return need;
	}
	
	public static void main(String[] args) {

	}

}
