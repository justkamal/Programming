package globalround_8;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Subsequences {

	private static BufferedReader br;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		long k = Long.parseLong(br.readLine());
		int[] count = new int[10];
		Arrays.fill(count, 1);		
		
		long result = 1;
		int i = 0;
		Arrays.fill(count, 1);
		while(result < k){
			result = result / count[i];
			count[i]++;
			result *= count[i];
			i = (i+1)%10;
		}
		
		//System.out.println(Arrays.toString(count));
		
		char[] s = "codeforces".toCharArray();
		
		for(i = 0; i < count.length; ++i)
			while(count[i]-- > 0)
				System.out.print(s[i]);
	}
}
