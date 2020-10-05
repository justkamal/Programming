package contest_675;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2 {
	private static BufferedReader br;
	private static StringTokenizer strz;

	public static long solve(long[][] mat, int n, int m) {
		long count = 0;
		
		for(int i = 0; i < n/2; ++i) {
			for(int j = 0; j < m/2; ++j) {
				//mat[i][j] mat[i][m-j-1] mat[n-i-1][j] mat[n-i-1][m-j-1]
				long x1 = 	Math.abs(mat[i][j] - mat[i][m-j-1]) 
						  + Math.abs(mat[i][j] - mat[n-i-1][j])
						  + Math.abs(mat[i][j] - mat[n-i-1][m-j-1]);
				
				long x2 = 	Math.abs(mat[i][m-j-1] - mat[i][j])
						  + Math.abs(mat[i][m-j-1] - mat[n-i-1][j])
						  + Math.abs(mat[i][m-j-1] - mat[n-i-1][m-j-1]);
				
				long x3 = 	Math.abs(mat[n-i-1][j] - mat[i][j])
						  + Math.abs(mat[n-i-1][j] - mat[i][m-j-1])
						  + Math.abs(mat[n-i-1][j] - mat[n-i-1][m-j-1]);
				
				long x4 = 	Math.abs(mat[n-i-1][m-j-1] - mat[i][j])
						  + Math.abs(mat[n-i-1][m-j-1] - mat[i][m-j-1])
						  + Math.abs(mat[n-i-1][m-j-1] - mat[n-i-1][j]);
				
				System.out.println(mat[i][j] + " " + mat[i][m-j-1] + " " + mat[n-i-1][j] + " " + mat[n-i-1][m-j-1]);
				
				count += Math.min(Math.min(x1, x2), Math.min(x3, x4));
			}
		}
		
		if(m%2 == 1){
			for(int i = 0, j = n - 1; i > j; ++i, --j) 
				count += Math.abs(mat[i][m/2] - mat[j][m/2]);
		}
		
		if(n%2 == 1) {
			for(int i = 0, j = m - 1; i > j; ++i, --j) 
				count += Math.abs(mat[n/2][i] - mat[n/2][j]);
		}
		
		return count;
	}
	
	public static void main(String[] args) throws java.lang.Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			strz = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(strz.nextToken());
			int m = Integer.parseInt(strz.nextToken());
			
			long[][] mat = new long[n][m];
			for(int i = 0; i < n; ++i) {
				strz = new StringTokenizer(br.readLine());
				for(int j = 0; j < m; ++j)
					mat[i][j] = Long.parseLong(strz.nextToken());
			}
			
			long count = solve(mat, n, m);
			System.out.println(count);
			
			/*
			 * for(int i = 0 ; i < n; ++i) { System.out.println(Arrays.toString(mat[i])); }
			 */
		}
	}
}