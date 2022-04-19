package decLong2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class VaccineDistribution {

    private static BufferedReader br;
    private static StringTokenizer strz;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            strz = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(strz.nextToken());
            int D = Integer.parseInt(strz.nextToken());

            int riskCount = 0, notRiskCount = 0;

            strz = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; ++i) {
                int age = Integer.parseInt(strz.nextToken());
                if(age >= 80 || age <= 9){
                    ++riskCount;
                } else {
                    ++notRiskCount;
                }
            }

            int ans = riskCount/D + notRiskCount/D;

            if(riskCount%D != 0)
                ++ans;
            if(notRiskCount%D != 0)
                ++ans;

            System.out.println(ans);
        }
    }
}
