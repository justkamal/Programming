package dynamicProgramming;

public class WaysToDecode {
	
	public static int computeWaysToDecode(String str) {
		char[] arr = str.toCharArray();
		int count = 0;
		
		int prev = 1, curr = 0;
		
		for(int i = 0; i < arr.length; ++i) {
			int x = arr[i] - '0';
			if(x >= 1 && x <= 26) {
				count = prev + curr;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		String str = "1234";
		computeWaysToDecode(str);	
	}
}
