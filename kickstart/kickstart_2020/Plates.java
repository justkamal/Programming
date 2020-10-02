package kickstart_2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Plates{
    
	private static BufferedReader br;
    private static StringTokenizer strz;
    private static int[][] dp;
    
    public static int compute(int[][] val, int k, int index, int plates){
        if(plates == 0)
            return 0;
        if(index >= val.length || plates < 0)
            return Integer.MIN_VALUE;
        
        if(dp[index][plates] != -1)
            return dp[index][plates];
            
        int ans = Integer.MIN_VALUE;    
        for(int i = 1; i <= k; ++i) {
        	int res = val[index][i] + compute(val, k, index + 1, plates - i);
        	ans = Math.max(ans, res);
        }
        return dp[index][plates] = ans;
    }
    
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; ++t){
            strz = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(strz.nextToken());
            int k = Integer.parseInt(strz.nextToken());
            int p = Integer.parseInt(strz.nextToken());
            
            dp = new int[n][p+1];
            for(int[] arr : dp)
                Arrays.fill(arr, -1);
                
            int[][] val = new int[n][k + 1];
            
            for(int i = 0; i < n; ++i){
                strz = new StringTokenizer(br.readLine());
                for(int j = 1; j <= k; ++j){
                    val[i][j] = Integer.parseInt(strz.nextToken());
                    val[i][j] += val[i][j-1];
                }
            }
            
            int beauty = compute(val, k, 0, p);
            
            System.out.println("Case #"+ t + ": " + beauty);
        }
    }
    
}