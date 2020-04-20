package BOJ.DP;

import java.io.*;
import java.util.Arrays;

public class N1699 {
    static int[] dp = new int[100_001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Arrays.fill(dp, Integer.MAX_VALUE);

        for(int i=1; i*i <100_001; i++){
            dp[i*i] = 1;
        }

        for(int i=2; i<=n; i++){
            if(dp[i] == 1) continue;

            for(int j=1; j*j < i; j++) {
                dp[i] = Math.min(dp[i], dp[j*j] + dp[i - j*j]);
            }
        }

        bw.write(dp[n]+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
