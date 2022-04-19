package decLong2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EvenPairSum {

    private static BufferedReader br;
    private static StringTokenizer strz;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            strz = new StringTokenizer(br.readLine());
            long A = Long.parseLong(strz.nextToken());
            long B = Long.parseLong(strz.nextToken());

            long numOfEvenA = A/2;
            long numOfOddA = numOfEvenA;

            long numOfEvenB = B/2;
            long numOfOddB = numOfEvenB;

            if((A&1) == 1)
                ++numOfOddA;

            if((B&1) == 1)
                ++numOfOddB;

            long numOfPairs = (numOfEvenA*numOfEvenB) + (numOfOddA*numOfOddB);

            System.out.println(numOfPairs);
        }
    }

}