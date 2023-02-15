package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MinSumPath {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer strz;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(br.readLine());
            int n = N;
            int[][] arr = new int[n][n];
            while(n > 0){
                strz = new StringTokenizer(br.readLine());
                int i = 0;
                while (strz.hasMoreTokens()){
                   arr[N-n][i++] =  Integer.parseInt(strz.nextToken());
                }
                --n;
            }
            System.out.println("Answer: " + minimumPathSum(arr, N));
        }
    }

    public static int minimumPathSum(int[][] triangle, int n) {
        int up, leftDiag;
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n - i + 1; ++j) {
                up = leftDiag = Integer.MAX_VALUE;
                if(i == 0 && j == 0){
                    continue;
                }else {
                    if(i > 0 && n-i >= j){
                        up = Math.min(up, triangle[i-1][j]);
                    }
                    if(i > 0 && j > 0){
                        leftDiag = Math.min(leftDiag, triangle[i-1][j-1]);
                    }
                    triangle[i][j] += Math.min(leftDiag, up);
                }
            }
            for(int k = 0; k < n; ++k){
                System.out.println(Arrays.toString(triangle[k]));
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < triangle[n-1].length; ++i){
            min = Math.min(min, triangle[n-1][i]);
        }

        return min;
    }
}
