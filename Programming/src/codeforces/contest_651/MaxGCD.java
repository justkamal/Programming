package codeforces.contest_651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxGCD {

    private static BufferedReader br;
    private static StringTokenizer strz;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while(test-- > 0){
            int n = Integer.parseInt(br.readLine());
            int ans = 0;
            if((n&1) == 1){
                ans = (n-1)/2;
            } else {
                ans = n/2;
            }
            System.out.println(ans);
        }
    }
}


