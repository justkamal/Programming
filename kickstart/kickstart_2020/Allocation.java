package kickstart_2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Allocation{
    
    private static BufferedReader br;
    private static StringTokenizer strz;
    
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; ++t){
            strz = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(strz.nextToken());
            int budget = Integer.parseInt(strz.nextToken());
            
            int[] prices = new int[n];
            strz = new StringTokenizer(br.readLine());
            
            for(int i = 0; i < n && strz.hasMoreTokens(); ++i)
                prices[i] = Integer.parseInt(strz.nextToken());
            
            Arrays.sort(prices);
            
            int buyCount = 0;
            for(int price : prices){
                if(budget - price >= 0){
                    ++buyCount;
                    budget -= price;
                }
            }
            
            System.out.println("Case #"+ t + ": " +buyCount);
        }
    }
}