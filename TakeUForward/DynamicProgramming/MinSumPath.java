package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MinSumPath {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer strz;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int n = N;
            int[][] arr = new int[n][n];
            while (n > 0) {
                strz = new StringTokenizer(br.readLine());
                int i = 0;
                while (strz.hasMoreTokens()) {
                    arr[N - n][i++] = Integer.parseInt(strz.nextToken());
                }
                --n;
            }
            System.out.println("Answer: " + minimumPathSumOptimal(arr, N));
        }
    }

    public static int minimumPathSum(int[][] triangle, int n) {
        int up, leftDiag;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                up = leftDiag = Integer.MAX_VALUE;
                if (j <= i - 1) {
                    up = Math.min(up, triangle[i - 1][j]);
                }
                if (j > 0) {
                    leftDiag = Math.min(leftDiag, triangle[i - 1][j - 1]);
                }
                triangle[i][j] += Math.min(leftDiag, up);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < triangle[n - 1].length; ++i) {
            min = Math.min(min, triangle[n - 1][i]);
        }

        return min;
    }

    //if you compute from bottom row to top, you wouldn't need to compute min of all at the last stage as going up
    //will eventually end up at one element array only (triangle property)

    public static int minimumPathSumOptimal(int[][] triangle, int n) {
        int down, rightDiag;
        for (int i = n-2; i >= 0; --i) {
            for (int j = 0; j <= i; ++j) {
                down = triangle[i+1][j];
                rightDiag = triangle[i+1][j+1];
                triangle[i][j] += Math.min(down, rightDiag);
            }
        }
        return triangle[0][0];
    }
}
