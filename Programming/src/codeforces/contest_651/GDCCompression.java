package codeforces.contest_651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class GDCCompression {

    private static BufferedReader br;
    private static StringTokenizer strz;

    private static class Pair{
        int a = 0;
        int b = 0;
        public Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }

    private static int computeGCD(int a, int b){
        if (b == 0)
            return a;
        return computeGCD(b, a % b);
    }

    private static boolean gcdCompress(int[][] mat, HashSet<Integer> visited, int gcd, ArrayList<Pair> list){
        boolean check = false;
        for(int i = 0; i < mat.length; ++i){
            for(int j = 0; j < mat[i].length; ++j){
                if(!visited.contains(i) && !visited.contains(j)) {
                    int ans = computeGCD(gcd, mat[i][j]);
                    if(ans > 1){
                        visited.add(i); visited.add(j);
                        list.add(new Pair(i,j));
                        if(!gcdCompress(mat, visited, ans, list)){
                            visited.remove(i); visited.remove(j);
                            list.remove(list.size() - 1);
                        }
                    }
                }
            }
        }
        return check;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while(test-- > 0){
            int n = Integer.parseInt(br.readLine());
            strz = new StringTokenizer(br.readLine());
            int[] arr = new int[2*n];
            int[] cmp = new int[n - 1];

            for(int i = 0; i < 2*n; ++i)
                arr[i] = Integer.parseInt(strz.nextToken());

            int[][] mat = new int[2*n][2*n];
            for(int i = 0; i < 2*n; ++i)
                for(int j = 0; j < 2*n; ++j)
                    mat[i][j] = arr[i]+arr[j];
            HashSet<Integer> visited = new HashSet<Integer>();
            ArrayList<Pair> list = new ArrayList<Pair>();
            gcdCompress(mat, visited, 1, list);
            System.out.println(list);
        }
    }

}
